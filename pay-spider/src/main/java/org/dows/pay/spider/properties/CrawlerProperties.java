package org.dows.pay.spider.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


/**
 * dows:
 *   crawlers:
 * #    - channel: alipay
 * #      host: https://alipay.com/api
 *
 *
 *     - channel: weixin
 *       seed: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc
 *       flows:
 *         - step: 1
 *           next: 2
 *           rule:
 *             section: div[class="content custom"]
 *             regex: h2.text
 *             mapping:
 *           handler: org.dows.pay.spider.handler.TextExtractHandler
 *
 *         - step: 2
 *           next: 3
 *           rule:
 *             section: div[class="content custom"]
 *             regex: h2 h3.text
 *           handler: org.dows.pay.spider.handler.TextExtractHandler
 *
 *         - step: 3
 *           next:
 *           rule:
 *             section: div[class="content custom"]
 *             regex: div.table.tr.td[0].a[href]
 *           handler: org.dows.pay.spider.handler.LinkExtractHandler
 */
@Data
@ConfigurationProperties("dows")
public class CrawlerProperties {

    private List<Crawler> crawlers;

}
