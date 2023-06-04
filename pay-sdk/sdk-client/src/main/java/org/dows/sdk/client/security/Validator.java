package org.dows.sdk.client.security;


import org.dows.sdk.client.http.HttpHeaders;

/**
 * 验证器
 */
public interface Validator {

    /**
     * 验证返回是否合法
     *
     * @param responseHeaders HTTP返回头
     * @param body            HTTP返回体
     * @param <T>             返回对象类型
     * @return 返回是否合法
     */
    <T> boolean validate(HttpHeaders responseHeaders, String body);
}
