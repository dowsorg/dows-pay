package org.dows.pay.spider.extract;

import cn.hutool.core.io.resource.ClassPathResource;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.SilentJavaScriptErrorListener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public interface Extractable {

    default Document getDocument(String seed) {
        Document document = null;
        if (seed.startsWith("http://") || seed.startsWith("https://")) {

            /** 创建模拟指定浏览器的客户端对象 */
            final WebClient webClient = new WebClient(BrowserVersion.EDGE);

            /** JS执行出错不抛出异常 */
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            /** HTTP状态不是200时不抛出异常 */
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            /** 不启用CSS */
            webClient.getOptions().setCssEnabled(false);
            /** 启用JS(非常重要) */
            webClient.getOptions().setJavaScriptEnabled(true);
            // webClient.getOptions().setActiveXNative(false);
            //webClient.getOptions().setTimeout(3000);
            /** 支持AJAX(非常重要) */
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            webClient.setJavaScriptErrorListener(new SilentJavaScriptErrorListener());
            /** JS执行需要一定时间，设置等待时间(非常重要) */
            webClient.waitForBackgroundJavaScript(3000);


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
            document = Jsoup.parse(pageXml);
            webClient.close();
        } else if (seed.startsWith("file://")) {
            try {
                document = Jsoup.parse(new File(seed.substring("file://".length())));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (seed.startsWith("classpath://")) {
            ClassPathResource classPathResource = new ClassPathResource(seed.substring("classpath://".length()));
            document = Jsoup.parse(classPathResource.readUtf8Str());
        } else {
            document = Jsoup.parse(seed);
        }
        return document;
    }
}
