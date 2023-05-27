package org.dows.pay.spider;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateEngine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.spider.handler.WeixinCatalogExtractHandler;
import org.dows.pay.spider.handler.WeixinIsvApiExtractHandler;
import org.dows.pay.spider.model.MenuInfo;
import org.dows.pay.spider.model.StepData;
import org.dows.pay.spider.model.schema.ApiSchema;
import org.dows.pay.spider.model.schema.FieldSchema;
import org.dows.pay.spider.properties.Crawler;
import org.dows.pay.spider.properties.CrawlerProperties;
import org.dows.pay.spider.schema.BeanSchema;
import org.dows.pay.spider.schema.ModuleSchema;
import org.dows.pay.spider.schema.ProjectSchema;
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
public class WeixinDeveloperSdkCrawler {

    private final CrawlerConfig crawlerConfig;

    private final ApplicationContext applicationContext;

    private final WeixinIsvApiExtractHandler weixinIsvApiExtractHandler;
    private final WeixinCatalogExtractHandler weixinCatalogExtractHandler;

    private final TemplateEngine templateEngine;


    public void crawlerApi() {

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
