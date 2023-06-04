package org.dows.sdk.client.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class ApiFeignClientConfig implements RequestInterceptor {
    /**
     * 聚瑞云控厂商规定token请求头名称
     */
    public static final String AUTHORIZATION = "Authorization";
    /**
     * 不需要token请求头标识
     */
    public static final String NO_NEED_TO_TOKEN = "No-Need-To-Token";


    @Bean
    public Decoder feignDecoder() {
        ApiMessageConverter txtPlainMessageConverter = new ApiMessageConverter();
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(txtPlainMessageConverter);
        return new SpringDecoder(objectFactory);
    }


    @Override
    public void apply(RequestTemplate requestTemplate) {
        //获取接口是否不需要加载token
        boolean noNeedToToken = requestTemplate.headers().containsKey(NO_NEED_TO_TOKEN);
        //取反就是需要加载token
        if (!noNeedToToken) {
            //获取用户认证token
            String token = this.getToken();
            //把用户认证token添加到请求头中
            requestTemplate.header(AUTHORIZATION, token);
        }
    }

    /**
     * 使用系统配置默认用户获取token
     *
     * @return token 用户登录凭证
     */
    public String getToken() {
        //开始构建请求参数
        Map<String, Object> params = new HashMap<>(4);
        //设置用户名
        params.put("loginName", "");
        //设置密码
        params.put("password", "");
        //使用系统配置的用户名密码进行登录
        // todo 获取token
        return null;
    }


}

