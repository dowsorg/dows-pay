package org.dows.pay.spider;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.spider.handler.WeixinDeveloperExtracter;
import org.dows.pay.spider.extract.WxOpenExtracter;
import org.dows.pay.spider.extract.WxPayExtracter;
import org.dows.pay.spider.extract.DyOpenExtracter;
import org.dows.pay.spider.schema.*;
import org.dows.pay.spider.util.SchemaUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

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
    private WxPayExtracter wxPayExtracter;

    @Autowired
    private WxOpenExtracter wxOpenExtracter;

    @Autowired
    private DyOpenExtracter dyOpenExtracter;

    @Autowired
    private CatalogCrawler catalogCrawler;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testApi() {
        catalogCrawler.crawlerApi();
    }



    @Test
    public void test(){
        String 测试小程序 = SchemaUtil.getPingYin("测试小程序Api");
        log.info(测试小程序);
    }
    @Test
    public void testDyOpen() {
        String seed = "classpath://html/application-zijie-api.html";
        String regex = "//ul[@role='menu']/li/ul//a,../..//span[@title]";
        dyOpenExtracter.genSdk(seed, regex);
        log.info("");
    }

    @Test
    public void testWxOpen() {
        String seed = "https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc";
        //String regex = "//div[@class='TreeNavigation']/div/ul/li/div/ul//li/span/a";
        // //div[@class='TreeNavigation']/div/ul/li/div//ul/li
        String regex = "//div[@class='TreeNavigation']/div/ul/li/div//ul,li//a";
        wxOpenExtracter.genSdk(seed, regex);
        log.info("");
    }


    @Test
    public void testWxPay() {
        String seed = "https://pay.weixin.qq.com/wiki/doc/apiv3_partner/apis/index.shtml";
        String regex = "//div[@class='doc-menu ']/dl/dt,/following-sibling::dd//a";
        wxPayExtracter.genSdk(seed, regex);
        log.info("");
    }










    @Test
    public void testWxOpen1() {
        log.info("");
        String file = this.getClass().getResource("").getPath() + File.separator + "bean-schema.json";

        Map<String, BeanSchema> link = new HashMap<>();
        try {
            String s = FileUtil.readString(new File(file), Charset.defaultCharset());
            link = JSONUtil.toBean(s, Map.class);
        } catch (Exception e) {

        }
        if (link.size() == 0) {
            link = weixinDeveloperExtracter.get("https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc", "//div[@class=\"TreeNavigation\"]/div/ul/li/div/ul//li/span/a");
            String jsonPrettyStr = JSONUtil.toJsonPrettyStr(link);
            FileUtil.writeString(jsonPrettyStr, file, Charset.defaultCharset());
        }

        List<ModuleSchema> moduleSchemas = new ArrayList<>();
        ProjectSchema projectSchema = new ProjectSchema();
        projectSchema.setName("sdk-weixin");
        projectSchema.setRootPath("E:/workspaces/java/projects/dows/dows-pay/pay-sdk");
        projectSchema.setBasePkg("org.dows.sdk.weixin");
        projectSchema.setModules(moduleSchemas);

        String apiSuffix = "Api";


        ModuleSchema moduleSchema = new ModuleSchema();
        moduleSchema.setProjectSchema(projectSchema);
        moduleSchemas.add(moduleSchema);
        //moduleSchema.setBeanSchemas(beanSchemas);

        Template template = templateEngine.getTemplate("api1.ftl");
        Template modelTemplate = templateEngine.getTemplate("param1.ftl");
        Template ymlTemplate = templateEngine.getTemplate("wexiapi.ftl");

        //link.entrySet().stream().iterator().next().getValue().stream().collect(Collectors.groupingBy(BeanSchema::getPkg));
        List<BeanSchema> beanSchemas = new ArrayList<>();
        Set<String> strings = link.keySet();
        for (String string : strings) {
            //BeanSchema beanSchema = JSONUtil.toBean((JSONObject) link.get(string), BeanSchema.class);
            BeanSchema beanSchema = (BeanSchema) link.get(string);
            beanSchema.setDescr(string);
            String beanName = beanSchema.getName();
            beanSchema.setModule(moduleSchema);
            moduleSchema.addBeanSchema(beanSchema);
            String path = beanSchema.getPath();
            try {
                Files.createDirectories(Path.of(path));

                String render = template.render(BeanUtil.beanToMap(beanSchema));

                Files.write(Path.of(path + "/" + StrUtil.upperFirst(beanName) + ".java"), render.getBytes());
                log.info("");

                List<MethodSchema> methods = beanSchema.getMethods();

                for (MethodSchema method : methods) {
                    List<ParamSchema> inputs = method.getInputs();
                    for (ParamSchema input : inputs) {
                        Files.createDirectories(Path.of(path, "request"));
                        input.setPkg(beanSchema.getPkg() + ".request");
                        String request = modelTemplate.render(BeanUtil.beanToMap(input));
                        Files.write(Path.of(path + "/request/" + StrUtil.upperFirst(input.getType()) + ".java"), request.getBytes());
                    }
                    ParamSchema output = method.getOutput();
                    output.setPkg(beanSchema.getPkg() + ".response");
                    Files.createDirectories(Path.of(path, "response"));
                    Map<String, Object> stringObjectMap = BeanUtil.beanToMap(output);
                    String response = modelTemplate.render(stringObjectMap);
                    Files.write(Path.of(path + "/response/" + StrUtil.upperFirst(output.getType()) + ".java"), response.getBytes());

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            beanSchemas.add(beanSchema);
        }

        // 生成yml
        Map<String, List<BeanSchema>> collect = beanSchemas.stream().collect(Collectors.groupingBy(BeanSchema::getPkg));
        collect.forEach((k, v) -> {
            try {
                Files.createDirectories(Path.of(moduleSchema.getResourcesPath()));
                BeanUtil.beanToMap(v);
                Map<String, List<BeanSchema>> map = new HashMap<>();
                map.put("beanSchemas", v);
                String render = ymlTemplate.render(map);
                Files.write(Path.of(moduleSchema.getResourcesPath() + "/" + k.replaceAll("\\.", "-") + ".yml"), render.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
