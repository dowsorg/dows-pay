package org.dows.pay.spider;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ApiTest {

//    @Autowired
//    private LinkExtractHandler linkExtractHandler;
//
//    @Autowired
//    private CrawlerConfig crawlerConfig;


    @Autowired
    private CatalogCrawler catalogCrawler;
    @Test
    public void testApi() {
        catalogCrawler.crawlerApi();
    }
}
