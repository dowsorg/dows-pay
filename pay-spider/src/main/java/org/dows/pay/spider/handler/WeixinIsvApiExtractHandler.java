package org.dows.pay.spider.handler;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.spider.model.StepData;
import org.dows.pay.spider.model.WeixinParamSchema;
import org.dows.pay.spider.properties.Crawler;
import org.dows.pay.spider.properties.Flow;
import org.dows.pay.spider.properties.Rule;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeixinIsvApiExtractHandler implements ExtractHandler {

    @Override
    public StepData extract(Crawler crawler, Flow flow) {
        String seed = crawler.getSeed();
        StepData stepData = doExtract(getDocument(seed), flow);
        if (stepData != null) {
            stepData.setSeed(seed);
        }
        return stepData;
    }


    public StepData extract(String seed, List<Crawler> crawlers) {
        for (Crawler crawler : crawlers) {
            if (crawler.getChannel().equalsIgnoreCase("weixin")) {
                List<Flow> flows = crawler.getFlows();
                for (Flow flow : flows) {
                    if (flow.getHandler().equals(this.getClass())) {
                        if (!StrUtil.isBlank(seed)) {
                            crawler.setSeed(seed);
                        }
                        return extract(crawler, flow);
                    }
                }
            }
        }
        return null;
    }


    /**
     * HtmlUtil+Jsoup根据网页URL获取动态加载后的页面并得到指定标签的内容
     *
     * @return
     * @throws Exception
     */
    public StepData doExtract(Document document, Flow flow) {
        Rule rule = flow.getRule();
        Map<String, String> regex = rule.getRegex();

        JXDocument jxDocument = JXDocument.create(document);
        List<JXNode> jxNodes = jxDocument.selN(rule.getSection());

        StepData stepData = new StepData();
        stepData.setStep(flow.getStep());
        stepData.setDatas(new ArrayList<>());

        for (JXNode jxNode : jxNodes) {
            Map<String, String> map = new HashMap<>();
            regex.forEach((key, val) -> {
                List<JXNode> selectedNodes = jxNode.sel(val);

                List<JXNode> ths = new ArrayList<>();
                for (JXNode selectedNode : selectedNodes) {

                    Element element = (Element) selectedNode.value();

                    if (element.tagName().equalsIgnoreCase("tr")) {
                        // 处理表头
                        if(ths.isEmpty()) {
                            ths.addAll(selectedNode.sel("th"));
                        }

                        List<JXNode> tds = selectedNode.sel("td");
                        if(tds.size() != ths.size()){
                            continue;
                        }
                        WeixinParamSchema weixinParamSchema = new WeixinParamSchema();
                        Map<String, Field> fields = weixinParamSchema.getFields();
                        for (int i = 0; i < ths.size(); i++) {
                            Field field = fields.get(ths.get(i).selOne("/text()").asString());
                            if(field != null) {
                                field.setAccessible(true);
                                try {
                                    JXNode jxNode1 = tds.get(i);
                                    if (jxNode1 != null) {
                                        field.set(weixinParamSchema, tds.get(i).selOne("/text()").asString());
                                    }
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                        map.put(key, JSONUtil.toJsonStr(weixinParamSchema));
                        log.info("");
                    } else {
                        map.put(key, element.text());
                    }
                    stepData.getDatas().add(map);
                    log.info("共提取接口：{}", stepData.getDatas().size());
                }
            });
        }
        return stepData;
    }
}