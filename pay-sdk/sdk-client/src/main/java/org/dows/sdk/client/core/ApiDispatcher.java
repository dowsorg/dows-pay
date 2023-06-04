package org.dows.sdk.client.core;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.sdk.client.ApiClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class ApiDispatcher {

    private static MD5 md5 = MD5.create();
    // private final ApiClient apiHttpClient;
    //@Qualifier("apiHttpClient")
    @Qualifier("apiFeignClient")
    private final ApiClient apiClient;
    private final ApplicationContext applicationContext;


    public JSONObject dispatch(String env, String orgUri, JSONObject params) {
        JSONObject result = new JSONObject();
        UriSchema uriSchema = UriSchema.of(orgUri);
        try {
            if (uriSchema.isPost()) {
                log.info("do http post:{}", orgUri);
                Map headers = new HashMap();
                String s = apiClient.post(URI.create(uriSchema.getUrl()), headers, params);
                JSONObject jsonObject = JSONUtil.parseObj(s);
                return jsonObject;
            } else if (uriSchema.isGet()) {
//                log.info("do http get:{}", url);
//                Map<String, String> headers = buildHeaders(channelEnv, channelSetting, params);
//                //Map<String, String> headers = new HashMap<>();
//                String s = restClient.get(URI.create(url), headers);
//                JSONObject jsonObject = JSONUtil.parseObj(s);
//                jsonObject.putAll(headers);
//                return jsonObject;
            } else if (uriSchema.isPut()) {
//                log.info("do http put:{}", url);
//                Map<String, String> headers = buildHeaders(channelEnv, channelSetting, params);
//                Object s = restClient.put(URI.create(url), headers, params);
//                return JSONUtil.parseObj(s);
            } else if (uriSchema.isDelete()) {
//                log.info("do http delete:{}", url);
//                Map<String, String> headers = buildHeaders(channelEnv, channelSetting, params);
//                Object s = restClient.delete(URI.create(url), headers, params);
//                return JSONUtil.parseObj(s);
            } else {
//                String[] split = url.substring(1).split("/");
//                String clazz = split[0];
//                String method = split[1];
//                Class<?> aClass = Class.forName(clazz);
//                Method method1 = aClass.getDeclaredMethod(method, JSONObject.class);
//                if (AnnotationUtils.isAnnotationDeclaredLocally(Component.class, aClass)) {
//                    Object bean = applicationContext.getBean(aClass);
//                    Object obj = method1.invoke(bean, params);
//                    if (obj == null) {
//                        return result;
//                    }
//                    return JSONUtil.parseObj(obj);
//                } else {
//                    Object obj = method1.invoke(null, params);
//                    if (obj == null) {
//                        return result;
//                    }
//                    return JSONUtil.parseObj(obj);
//                }
            }
        } catch (Exception e) {
            log.error("error:{}", e);
            //throw new RuntimeException(e);
        }
        return result;

    }


}
