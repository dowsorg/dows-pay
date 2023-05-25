package org.dows.pay.spider;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.spider.handler.WeixinCatalogExtractHandler;
import org.dows.pay.spider.handler.WeixinIsvApiExtractHandler;
import org.dows.pay.spider.model.MenuInfo;
import org.dows.pay.spider.model.StepData;
import org.dows.pay.spider.properties.Crawler;
import org.dows.pay.spider.properties.CrawlerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        for (Map<String, String> data : stepData.getDatas()) {
            MenuInfo menuInfo = BeanUtil.toBean(data, MenuInfo.class);
            String seed = stepData.getSeed();
            menuInfo.setHref(seed + menuInfo.getHref().substring(1));
            menuInfos.add(menuInfo);
        }

        Map<String, List<MenuInfo>> collect = menuInfos.stream().collect(Collectors.groupingBy(MenuInfo::getModule));

        List<StepData> stepDataList = new ArrayList<>();
        for (MenuInfo menuInfo : menuInfos) {
            log.info("菜单信息：{}", JSONUtil.toJsonStr(menuInfo));
            String href = menuInfo.getHref();
            System.out.println("");
            StepData stepData1 = weixinIsvApiExtractHandler.extract(href, crawlers);
            stepDataList.add(stepData1);
            log.info("{}", stepData1);
        }

    }


}
