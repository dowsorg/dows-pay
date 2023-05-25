package org.dows.pay.spider;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.dows.pay.spider.properties.CrawlerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@RequiredArgsConstructor
@EnableConfigurationProperties({CrawlerProperties.class})
public class CrawlerConfig {

    private final CrawlerProperties crawlerProperties;


}
