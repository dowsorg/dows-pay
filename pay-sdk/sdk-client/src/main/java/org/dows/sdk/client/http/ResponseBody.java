package org.dows.sdk.client.http;

/**
 * HTTP返回体
 */
public interface ResponseBody {

    /**
     * 获取返回体的数据类型
     *
     * @return 返回体的数据类型
     */
    String getContentType();
}
