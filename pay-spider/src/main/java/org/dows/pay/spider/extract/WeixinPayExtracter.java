package org.dows.pay.spider.extract;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
//import cn.hutool.core.lang.tree.TreeUtil;
import org.dows.pay.spider.schema.ModuleSchema;
import org.dows.pay.spider.util.TreeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.spider.model.Catalog;
import org.dows.pay.spider.model.WeixinPayLinkModel;
import org.dows.pay.spider.schema.BeanSchema;
import org.dows.pay.spider.schema.FieldSchema;
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
public class WeixinPayExtracter implements Extractable {


    public List<WeixinPayLinkModel> getLink(String seed, String regex) {

        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setIdKey("id");
        treeNodeConfig.setParentIdKey("pid");
        treeNodeConfig.setNameKey("name");
        treeNodeConfig.setChildrenKey("childs");
        // 最大递归深度，可不用配置,默认无限制
        //treeNodeConfig.setDeep(2);

        List<Catalog> catalogs = getCatalogs(seed, regex);


        return null;
    }

    public List<Catalog> getCatalogs(String seed, String regex) {
        List<Catalog> catalogs = new ArrayList<>();

        Document document = getDocument(seed);
        JXDocument jxDocument = JXDocument.create(document);

        String[] regexs = regex.split(",");
        List<JXNode> jxNodes = jxDocument.selN(regexs[0]);
        Long id1 = 1L;
        for (JXNode jxNode : jxNodes) {
            String menu1 = jxNode.selOne("/text()").asString();
            Catalog catalog = new Catalog();
            catalog.setName(menu1);
            catalog.setId(id1);
            catalog.setType("pkg");
            catalog.setPid(0L);
            id1++;
            catalogs.add(catalog);
            Catalog catalog2 = null;
            List<JXNode> sels = jxNode.sel(regexs[1]);
            for (JXNode sel : sels) {
                JXNode href = sel.selOne("/@href");
                JXNode text = sel.selOne("/text()");
                if (href.asString().startsWith("javascript")) {
                    catalog2 = new Catalog();
                    catalog2.setName(text.asString());
                    catalog2.setHref(href.asString());
                    catalog2.setType("bean");
                    catalog2.setId(id1);
                    catalog2.setPid(catalog.getId());
                    catalog2.setPatent(catalog);
                    catalog.addChild(catalog2);
                } else {
                    Catalog catalog3 = new Catalog();
                    catalog3.setName(text.asString());
                    catalog3.setHref(href.asString());
                    catalog3.setType("method");
                    catalog3.setId(id1);
                    if (catalog2 != null) {
                        catalog3.setPid(catalog2.getId());
                        catalog2.addChild(catalog3);
                        catalog3.setPatent(catalog2);
                    } else {
                        catalog3.setPid(catalog.getId());
                        catalog.addChild(catalog3);
                        catalog3.setPatent(catalog);
                    }
                }
                id1++;
            }
            log.info("");
        }
        return catalogs;
    }


    public void tree(List<Catalog> catalogs){

        for (Catalog catalog : catalogs) {

            if (catalog.getType().equals("pkg")) {
                catalog.setPkg(catalog.getName());
                ModuleSchema moduleSchema = new ModuleSchema();
            }
            if (catalog.getType().equals("bean")) {
                BeanSchema beanSchema = new BeanSchema();
                beanSchema.setPkg(catalog.getName());

            }
            if (catalog.getChilds().size() != 0) {
                tree(catalog.getChilds());
            }
        }
    }

    public Map<String, BeanSchema> get(String seed, String regex, String regex1) {
        //List<WeixinPayLinkModel> weixinLinkSchemas = getLink(seed, regex);

        //List<BeanSchema> beanSchemas = new ArrayList<>();
        List<Catalog> catalogs = getCatalogs(seed, regex);



        Map<String, BeanSchema> beanSchemaMap = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        map.put("catalogTree", "//div[@class='Breadcrumb']/span/child::span/text()");
        map.put("httpMethod", "//div[@class='language- extra-class']/pre/code/text()");
        map.put("url", "//div[@class='language- extra-class']/pre/code/text()");
        map.put("inputs", "//h3[@id='请求参数']/following-sibling::div[1]/table//tr");
        map.put("output", "//h3[@id='返回参数']/following-sibling::div[1]/table//tr");
        map.put("descr", "//h3[@id='功能描述']/following-sibling::p/text()");
        map.put("explain", "//h3[@id='第三方调用']/following-sibling::ul/li/*/text()");

//        for (WeixinPayLinkModel weixinLinkSchema : weixinLinkSchemas) {
//            BeanSchema beanSchema = weixinLinkSchema.getBeanSchema();
//            beanSchema = beanSchemaMap.get(beanSchema.getName());
//            if (beanSchema == null) {
//                beanSchema = weixinLinkSchema.getBeanSchema();
//                beanSchemaMap.put(beanSchema.getName(), beanSchema);
//            }
//            Document document = getDocument(weixinLinkSchema.getHref());
//            JXDocument jxDocument = JXDocument.create(document);
//
//            // 构建方法
//            String method = weixinLinkSchema.getHref().
//                    substring(weixinLinkSchema.getHref().lastIndexOf("/") + 1, weixinLinkSchema.getHref().lastIndexOf("."));
//            MethodSchema methodSchema = new MethodSchema();
//            methodSchema.setName(method);
//
//            beanSchema.addMethod(methodSchema);
//            //beanSchemas.add(beanSchema);
//
//            // 构建参数
//            map.forEach((k, v) -> {
//                List<JXNode> jxNodes = jxDocument.selN(v);
//
//                List<JXNode> ths = new ArrayList<>();
//                StringBuilder sb = new StringBuilder();
//
//                if (k.equalsIgnoreCase("inputs")) {
//
//                    ParamSchema paramSchema = new ParamSchema();
//                    paramSchema.setName(method + "Request");
//                    // 为method 设置 input入参列表
//                    methodSchema.addInput(paramSchema);
//                    for (JXNode jxNode : jxNodes) {
//                        buildParam(ths, paramSchema, jxNode);
//                    }
//                } else if (k.equalsIgnoreCase("output")) {
//                    ParamSchema paramSchema = new ParamSchema();
//                    paramSchema.setName(method + "Response");
//                    methodSchema.setOutput(paramSchema);
//                    for (JXNode jxNode : jxNodes) {
//                        buildParam(ths, paramSchema, jxNode);
//                    }
//                } else {
//                    for (JXNode jxNode : jxNodes) {
//                        sb.append(jxNode.asString());
//                    }
//                    methodSchema.setFieldValue(k, sb.toString());
//                }
//                log.info("jxNodes:{}", jxNodes);
//            });
//        }
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

            Map<String, Field> fields = fieldSchema.getWexinFieldMap();
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
