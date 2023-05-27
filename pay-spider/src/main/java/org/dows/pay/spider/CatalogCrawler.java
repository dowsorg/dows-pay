package org.dows.pay.spider;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateEngine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.spider.handler.WeixinCatalogExtractHandler;
import org.dows.pay.spider.handler.WeixinIsvApiExtractHandler;
import org.dows.pay.spider.model.schema.ApiSchema;
import org.dows.pay.spider.model.schema.FieldSchema;
import org.dows.pay.spider.model.MenuInfo;
import org.dows.pay.spider.model.StepData;
import org.dows.pay.spider.properties.Crawler;
import org.dows.pay.spider.properties.CrawlerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class CatalogCrawler {

    private final CrawlerConfig crawlerConfig;

    private final ApplicationContext applicationContext;

    private final WeixinIsvApiExtractHandler weixinIsvApiExtractHandler;
    private final WeixinCatalogExtractHandler weixinCatalogExtractHandler;

    private final TemplateEngine templateEngine;

    /**
     * dows:
     * crawlers:
     * #    - channel: alipay
     * #      host: https://alipay.com/api
     * <p>
     * <p>
     * - channel: weixin
     * seed: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc
     * flows:
     * - step: 1
     * next: 2
     * type:
     * sync:
     * rule:
     * section: div[class="content custom"]
     * regex: h2.text
     * mapping: org.dows.pay.spider.model.Catalog
     * handler: org.dows.pay.spider.handler.TextExtractHandler
     * <p>
     * - step: 2
     * next: 3
     * rule:
     * section: div[class="content custom"]
     * regex: h2 h3.text
     * mapping: org.dows.pay.spider.model.Catalog
     * handler: org.dows.pay.spider.handler.TextExtractHandler
     * <p>
     * - step: 3
     * next: 4
     * rule:
     * section: div[class="content custom"]
     * regex: div.table.tr.td[0].a[href]
     * mapping: org.dows.pay.spider.model.Catalog
     * handler: org.dows.pay.spider.handler.LinkExtractHandler
     * <p>
     * - step: 4
     * next:
     * handler: org.dows.pay.spider.handler.LinkExtractHandler
     */
    public void crawlerApi() {
        CrawlerProperties crawlerProperties = crawlerConfig.getCrawlerProperties();

        List<Crawler> crawlers = crawlerProperties.getCrawlers();

        List<MenuInfo> menuInfos = new ArrayList<>();
        StepData stepData = weixinCatalogExtractHandler.extract(null, crawlers);
        for (Map<String, Object> data : stepData.getDatas()) {
            MenuInfo menuInfo = BeanUtil.toBean(data, MenuInfo.class);
            String seed = stepData.getSeed();
            menuInfo.setHref(seed + menuInfo.getHref().substring(1));
            menuInfos.add(menuInfo);
        }

        Map<String, List<MenuInfo>> collect = menuInfos.stream().collect(Collectors.groupingBy(MenuInfo::getModule));


        String rootpkg = "org.dows.sdk.weixin";
        List<Map<String, String>> listMap = new ArrayList<>();
        collect.forEach((module, menuInfoList) -> {
            Map<String, List<MenuInfo>> apiCollection = menuInfoList.stream().filter(m -> !StrUtil.isBlank(m.getSub())).collect(Collectors.groupingBy(MenuInfo::getSub));
            List<ApiSchema> apiSchemas = new ArrayList<>();
            apiCollection.forEach((sub, menuInfos1) -> {

                for (MenuInfo menuInfo : menuInfos1) {

                    String href = menuInfo.getHref();
                    StepData stepData1 = weixinIsvApiExtractHandler.extract(href, crawlers);

                    String doc = href;

                    String s = doc.replace("-", "_");
                    String start = "OpenApiDoc/";
                    int i = s.indexOf("OpenApiDoc/") + start.length();
                    int methodIndex = s.lastIndexOf("/");

                    //String pkg = "";
                    String fp = rootpkg;
                    String clazzStr = s.substring(0, methodIndex);
                    try {
                        String pkg = s.substring(i, clazzStr.lastIndexOf("/")).replaceAll("/", ".").replaceAll("_", ".");
                        fp = rootpkg + "." + pkg;
                    } catch (Exception e) {
                        log.error("");
                    }


                    String clazz = StrUtil.toCamelCase(clazzStr.substring(clazzStr.lastIndexOf("/") + 1));
                    String method = menuInfo.getCode();
                    Map<String, Object> stringStringMap = stepData1.getDatas().get(0);


                    ApiSchema apiSchema = new ApiSchema(stringStringMap);
                    apiSchema.setClazz(clazz);
                    apiSchema.setMethod(method);
                    apiSchema.setApiPkg(fp);
                    apiSchema.setApiPath("E:\\workspaces\\java\\projects\\dows\\dows-pay\\pay-sdk\\sdk-weixin");
                    apiSchemas.add(apiSchema);
                    log.info("");
                }
            });
            Map<String, List<ApiSchema>> collect1 = apiSchemas.stream().collect(Collectors.groupingBy(ApiSchema::getClazz));

            collect1.forEach((k, v) -> {
                log.info("{}", k);
                String java = StrUtil.upperFirst(k);

                apiBuild(java, v);

            });

        });
        log.info("所有接口元数据{}", listMap);

        /**
         * "output" -> "{"descr":"版本号，action=get时返回","field":"version","fieldType":"number"}"
         * "explain" -> "调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：49、64服务商获得其中之一权限集授权后，可通过使用代商家进行调用"
         * "input" -> "{"descr":"版本号，action=set时必填","field":"version","must":"是","fieldType":"number"}"
         * "descr" -> "通过本接口可以开启或关闭cloudbase_access_token的使用权限，使用过程中如遇到问题，可在发帖交流。"
         * "catalog" -> "普通代云开发/开通与权限管理"
         * "doc" -> "https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/setCloudAccessToken.html"
         * "httpMethod" -> "POST https://api.weixin.qq.com/tcb/usecloudaccesstoken?access_token=ACCESS_TOKEN"
         * "url" -> "POST https://api.weixin.qq.com/tcb/usecloudaccesstoken?access_token=ACCESS_TOKEN"
         */
    }

    private void modelBuild(Map<String, String> stringStringMap) {

    }

    private void apiBuild(String java, List<ApiSchema> apiSchemas) {
        try {
            ApiSchema apiSchema = apiSchemas.get(0);
            Template template = templateEngine.getTemplate("api.ftl");
            Template beanTemplate = templateEngine.getTemplate("param.ftl");
            Files.createDirectories(Path.of(apiSchema.getApiPath(), "request"));
            Files.createDirectories(Path.of(apiSchema.getApiPath(), "response"));

            Map<String, Object> paramMap = new HashMap<>();

            for (ApiSchema schema : apiSchemas) {
                Map<String, List<FieldSchema>> request = schema.getRequest();
                request.forEach((resq, ps) -> {
                    try {
                        paramMap.put("pkg", apiSchema.getApiPkg() + ".request");
                        paramMap.put("clazz", resq);
                        paramMap.put("fields", ps);
                        Files.write(Path.of(apiSchema.getApiPath() + File.separator + "request" + File.separator + resq + ".java"),
                                beanTemplate.render(paramMap).getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                Map<String, List<FieldSchema>> response = schema.getResponse();
                response.forEach((resp, ps) -> {
                    try {
                        paramMap.put("pkg", apiSchema.getApiPkg() + ".response");
                        paramMap.put("clazz", resp);
                        paramMap.put("fields", ps);
                        Files.write(Path.of(apiSchema.getApiPath() + File.separator + "response" + File.separator + resp + ".java"),
                                beanTemplate.render(paramMap).getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            String javaClass = java+"Api";
            Map<String, Object> map = new HashMap<>();
            map.put("pkg", apiSchema.getApiPkg());
            map.put("apiSchemas", apiSchemas);
            map.put("clazz",javaClass );
            map.put("descr", apiSchema.getExplain());
            Files.write(Path.of(apiSchema.getApiPath() + File.separator + javaClass + ".java"), template.render(map).getBytes());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
