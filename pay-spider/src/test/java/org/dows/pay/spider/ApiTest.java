package org.dows.pay.spider;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.spider.extract.WeixinDeveloperExtracter;
import org.dows.pay.spider.schema.BeanSchema;
import org.dows.pay.spider.schema.ModuleSchema;
import org.dows.pay.spider.schema.ProjectSchema;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Slf4j
@SpringBootTest
public class ApiTest {

//    @Autowired
//    private LinkExtractHandler linkExtractHandler;
//
//    @Autowired
//    private CrawlerConfig crawlerConfig;

    @Autowired
    private WeixinDeveloperSdkCrawler weixinDeveloperSdkCrawler;

    @Autowired
    private WeixinDeveloperExtracter weixinDeveloperExtracter;

    @Autowired
    private CatalogCrawler catalogCrawler;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testApi() {
        catalogCrawler.crawlerApi();
    }


    @Test
    public void testA() {
        log.info("");
        String file = this.getClass().getResource("").getPath() + File.separator + "bean-schema.json";

        Map link = new HashMap<>();
        try {
            String s = FileUtil.readString(new File(file), Charset.defaultCharset());
            link = JSONUtil.toBean(s, Map.class);
        } catch (Exception e) {

        }
        if (link.size() == 0) {
            link = weixinDeveloperExtracter.get("https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc", "//div[@class=\"TreeNavigation\"]/div/ul/li/div/ul//li/span/a", "");
            String jsonPrettyStr = JSONUtil.toJsonPrettyStr(link);
            FileUtil.writeString(jsonPrettyStr, file, Charset.defaultCharset());
        }
        //Map<String, BeanSchema> link = new HashMap<>();


        List<ModuleSchema> moduleSchemas = new ArrayList<>();
        //List<BeanSchema> beanSchemas = new ArrayList<>();

        ProjectSchema projectSchema = new ProjectSchema();
        projectSchema.setName("sdk-weixin");
        projectSchema.setRootPath("E:/workspaces/java/projects/dows/dows-pay/pay-sdk1");
        projectSchema.setBasePkg("org.dows.sdk.weixin");
        projectSchema.setModules(moduleSchemas);


        ModuleSchema moduleSchema = new ModuleSchema();
        moduleSchema.setProjectSchema(projectSchema);
        moduleSchemas.add(moduleSchema);
        //moduleSchema.setBeanSchemas(beanSchemas);

        Template template = templateEngine.getTemplate("api1.ftl");

        Set<String> strings = link.keySet();
        for (String string : strings) {
            BeanSchema beanSchema = JSONUtil.toBean((JSONObject) link.get(string), BeanSchema.class);
            String beanName = beanSchema.getName();
            beanSchema.setModuleSchema(moduleSchema);
            moduleSchema.addBeanSchema(beanSchema);
            String path = beanSchema.getPath();
            try {
                Files.createDirectories(Path.of(path));

                String render = template.render((Map) link.get(string));

                Files.write(Path.of(path + "/" + StrUtil.upperFirst(beanName) + ".java"), render.getBytes());
                log.info("");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
