package org.dows.pay.spider.handler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.dows.pay.spider.model.StepData;
import org.dows.pay.spider.properties.Crawler;
import org.dows.pay.spider.properties.Flow;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

public interface ExtracterHandler {

    //StepData extract(Crawler crawler, Flow flow);
    StepData extract(Crawler crawler, Flow flow);

    StepData extract(String seed, List<Crawler> crawlers);

    default Document getDocument(String seed) {
        /** 创建模拟指定浏览器的客户端对象 */
        final WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
        /** JS执行出错不抛出异常 */
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        /** HTTP状态不是200时不抛出异常 */
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        /** 不启用CSS */
        webClient.getOptions().setCssEnabled(false);
        /** 启用JS(非常重要) */
        webClient.getOptions().setJavaScriptEnabled(true);
        /** 支持AJAX(非常重要) */
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());

        /** JS执行需要一定时间，设置等待时间(非常重要) */
        webClient.waitForBackgroundJavaScript(3000);
        // webClient.getOptions().setActiveXNative(false);
        //webClient.getOptions().setTimeout(3000);

        /** 加载网页 */
        HtmlPage page = null;
        try {
            page = webClient.getPage(seed);
            //Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /** 将加载的网页转换成XML形式 */
        String pageXml = page.asXml();
        /** Jsoup获取HTML文档 */
        Document seedDocument = Jsoup.parse(pageXml);
        webClient.close();
        return seedDocument;
    }
}
