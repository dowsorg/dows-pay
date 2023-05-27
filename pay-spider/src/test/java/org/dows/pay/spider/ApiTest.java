package org.dows.pay.spider;

import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.spider.handler.WeixinDeveloperLinkExtracter;
import org.dows.pay.spider.schema.BeanSchema;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

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
    private WeixinDeveloperLinkExtracter weixinDeveloperLinkExtracter;

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
        Map<String, BeanSchema> link = weixinDeveloperLinkExtracter.get("https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc", "//div[@class=\"TreeNavigation\"]/div/ul/li/div/ul//li/span/a","");
        log.info("");

        Template template = templateEngine.getTemplate("");
        template.render(null);

    }

}
