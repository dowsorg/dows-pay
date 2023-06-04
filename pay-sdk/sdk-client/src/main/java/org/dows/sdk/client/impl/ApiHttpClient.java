//package org.dows.sdk.client.impl;
//
//import cn.hutool.http.HttpRequest;
//import cn.hutool.http.HttpResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.dows.sdk.client.ApiClient;
//import org.springframework.stereotype.Service;
//
//import java.net.URI;
//import java.util.Map;
//
///**
// * http 实现
// */
//@Slf4j
//@Service
//public class ApiHttpClient implements ApiClient {
//    @Override
//    public String get(URI uri, Map<String, String> headers) {
//        HttpResponse getResponse = HttpRequest.get(uri.toString())
//                .addHeaders(headers)
////                .header("Content-Type", "application/json")
////                .header("token", "")
//                .execute();
//        log.info("请求响应状态码:{}", getResponse.getStatus());
//        String body = getResponse.body();
//        return body;
//    }
//
//    @Override
//    public String post(URI uri, Map<String, String> headers, Map<String, Object> params) {
//
//        String result = HttpRequest.post(uri.toString())
//                .addHeaders(headers)
//                /*.header("Content-Type", "application/json")*/
//                //.body(jsonObject.toJSONString(0))
//                .form(params)
//                .execute()
//                .body();
//        return result;
//    }
//
//    @Override
//    public String delete(URI uri, Map<String, String> headers, Map<String, Object> params) {
//        return null;
//    }
//
//    @Override
//    public String put(URI uri, Map<String, String> headers, Map<String, Object> params) {
//        return null;
//    }
//}
