package org.dows.pay.spider.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.spider.extract.Extractable;
import org.dows.pay.spider.model.WeixinDeveloperLinkModel;
import org.dows.pay.spider.schema.BeanSchema;
import org.dows.pay.spider.schema.FieldSchema;
import org.dows.pay.spider.schema.MethodSchema;
import org.dows.pay.spider.schema.ParamSchema;
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
public class WeixinDeveloperExtracter implements Extractable {


    public List<WeixinDeveloperLinkModel> getLink(String seed, String regex) {
        Document document = getDocument(seed);
        JXDocument jxDocument = JXDocument.create(document);
        List<JXNode> jxNodes = jxDocument.selN(regex);

        List<WeixinDeveloperLinkModel> weixinLinkSchemas = new ArrayList<>();
        for (JXNode jxNode : jxNodes) {
            JXNode href = jxNode.selOne("/@href");
            JXNode text = jxNode.selOne("/text()");

            if (!href.asString().startsWith("javascript")) {
                WeixinDeveloperLinkModel linkSchema = new WeixinDeveloperLinkModel();
                linkSchema.setHref(href.asString());
                linkSchema.setName(text.asString());
                weixinLinkSchemas.add(linkSchema);
            }
            //return weixinLinkSchemas;
        }
        return weixinLinkSchemas;
    }


    public Map<String, BeanSchema> get(String seed, String regex) {
        List<WeixinDeveloperLinkModel> weixinLinkSchemas = getLink(seed, regex);

        //List<BeanSchema> beanSchemas = new ArrayList<>();
        Map<String, BeanSchema> beanSchemaMap = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        map.put("httpMethod", "//div[@class='language- extra-class']/pre/code/text()");
        map.put("url", "//div[@class='language- extra-class']/pre/code/text()");
        map.put("inputs", "//h3[@id='请求参数']/following-sibling::div[1]/table//tr");
        map.put("output", "//h3[@id='返回参数']/following-sibling::div[1]/table//tr");
        map.put("descr", "//h3[@id='功能描述']/following-sibling::p/text()");
        map.put("overview", "//h3[@id='第三方调用']/following-sibling::ul/li/*/text()");

        for (WeixinDeveloperLinkModel weixinLinkSchema : weixinLinkSchemas) {
            BeanSchema beanSchema = weixinLinkSchema.getBeanSchema();
            beanSchema = beanSchemaMap.get(beanSchema.getName());
            if (beanSchema == null) {
                beanSchema = weixinLinkSchema.getBeanSchema();
                beanSchemaMap.put(beanSchema.getName(), beanSchema);
            }
            Document document = getDocument(weixinLinkSchema.getHref());
            JXDocument jxDocument = JXDocument.create(document);

            // 构建方法
            String method = weixinLinkSchema.getHref().
                    substring(weixinLinkSchema.getHref().lastIndexOf("/") + 1, weixinLinkSchema.getHref().lastIndexOf("."));
            MethodSchema methodSchema = new MethodSchema();
            methodSchema.setName(method);
            methodSchema.setDocUrl(weixinLinkSchema.getHref());

            beanSchema.addMethod(methodSchema);
            //beanSchemas.add(beanSchema);

            // 构建参数
            map.forEach((k, v) -> {
                List<JXNode> jxNodes = jxDocument.selN(v);

                List<JXNode> ths = new ArrayList<>();
                StringBuilder sb = new StringBuilder();

                if (k.equalsIgnoreCase("inputs")) {

                    ParamSchema paramSchema = new ParamSchema();
                    paramSchema.setName(method + "Request");
                    paramSchema.setType(method + "Request");
                    paramSchema.setIot("in");
                    // 为method 设置 input入参列表
                    methodSchema.addInput(paramSchema);
                    for (JXNode jxNode : jxNodes) {
                        buildParam(ths, paramSchema, jxNode);
                    }
                    paramSchema.setDocUrl(methodSchema.getDocUrl());
                } else if (k.equalsIgnoreCase("output")) {
                    ParamSchema paramSchema = new ParamSchema();
                    paramSchema.setName(method + "Response");
                    paramSchema.setType(method + "Response");
                    paramSchema.setIot("out");
                    methodSchema.setOutput(paramSchema);
                    for (JXNode jxNode : jxNodes) {
                        buildParam(ths, paramSchema, jxNode);
                    }
                    paramSchema.setDocUrl(methodSchema.getDocUrl());
                } else {
                    for (JXNode jxNode : jxNodes) {
                        sb.append(jxNode.asString());
                    }
                    methodSchema.setFieldValue(k, sb.toString());
                }
                log.info("jxNodes:{}", jxNodes);
            });
        }
        return beanSchemaMap;
    }

    private void buildParam(List<JXNode> ths, ParamSchema paramSchema, JXNode jxNode) {
        Element element = (Element) jxNode.value();
        if (element.tagName().equalsIgnoreCase("tr")) {
            // 处理表头
            if (ths.isEmpty()) {
                ths.addAll(jxNode.sel("th"));
            }

            List<JXNode> tds = jxNode.sel("td");
            if (tds.size() != ths.size()) {
                return;
            }

            FieldSchema fieldSchema = new FieldSchema();
            paramSchema.addField(fieldSchema);

            Map<String, Field> fields = fieldSchema.getWexinOpenFieldMap();
            for (int i = 0; i < ths.size(); i++) {
                Field field = fields.get(ths.get(i).selOne("/text()").asString());
                if (field != null) {
                    field.setAccessible(true);
                    try {
                        JXNode jxNode1 = tds.get(i);
                        JXNode jxNode2 = jxNode1.selOne("/text()");
                        if (jxNode1 != null && jxNode2 != null) {
                            field.set(fieldSchema, jxNode2.asString());
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
