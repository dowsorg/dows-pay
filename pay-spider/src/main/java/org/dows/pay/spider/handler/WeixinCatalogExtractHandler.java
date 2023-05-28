package org.dows.pay.spider.handler;

import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.spider.extract.Extractable;
import org.dows.pay.spider.model.StepData;
import org.dows.pay.spider.properties.Crawler;
import org.dows.pay.spider.properties.Flow;
import org.dows.pay.spider.properties.Rule;
import org.jsoup.nodes.Document;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class WeixinCatalogExtractHandler implements ExtracterHandler {

//    public StepData extract(Crawler crawler, Flow flow) {
//        String seed = crawler.getSeed();
//        StepData stepData = doExtract(getDocument(seed), flow);
//        if(stepData != null) {
//            stepData.setSeed(seed);
//        }
//        return stepData;
//    }

    @Override
    public StepData extract(Crawler crawler, Flow flow) {
        String seed = crawler.getSeed();
        StepData stepData = doExtract(getDocument(seed), flow);
        if (stepData != null) {
            stepData.setSeed(seed);
        }
        return stepData;
    }

    @Override
    public StepData extract(String seed, List<Crawler> crawlers) {
        for (Crawler crawler : crawlers) {
            if (crawler.getChannel().equalsIgnoreCase("weixin")) {
                List<Flow> flows = crawler.getFlows();
                for (Flow flow : flows) {
                    if (flow.getHandler().equals(this.getClass())) {
                        if(!StrUtil.isBlank(seed)) {
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
        JXDocument jxDocument = JXDocument.create(document);
        List<JXNode> jxNodes = jxDocument.selN(rule.getSection());

        StepData stepData = new StepData();
        stepData.setStep(flow.getStep());
        stepData.setDatas(new ArrayList<>());
        Map<String, String> regex = rule.getRegex();

        for (JXNode jxNode : jxNodes) {
            List<JXNode> trs = jxNode.sel("//tbody/tr");
            for (JXNode trNode : trs) {
                Map<String, Object> map = new HashMap<>();
                regex.forEach((key, val) -> {
                    JXNode jxNode1 = trNode.selOne(val);
                    if (jxNode1 != null) {
                        String value = jxNode1.asString();
                        map.put(key, value);
                    }
                });
                stepData.getDatas().add(map);
            }
            log.info("共提取接口：{}", stepData.getDatas().size());
        }
        return stepData;
    }


}
