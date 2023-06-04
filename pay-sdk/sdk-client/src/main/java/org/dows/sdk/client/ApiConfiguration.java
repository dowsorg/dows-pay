package org.dows.sdk.client;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dows.framework.api.util.YamlPropertySourceFactory;
import org.dows.sdk.client.core.ApiUrlProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@PropertySource(value = {"classpath:open/org-dows-sdk-weixin-open-dsfptdypz.yml"}, factory = YamlPropertySourceFactory.class)
@EnableConfigurationProperties(ApiUrlProperties.class)
@Getter
@Configuration
public class ApiConfiguration {

    private final ApiUrlProperties apiUrlProperties;

//    private List<SourceReader> sourceReaders;

    /**
     * 请求拦截器,做切面处理
     */
    private List<ApiChain> chains;

    /**
     * 结果集处理类，如果需要不同的结果转换时，可以继承并注册
     */
//    private List<ResponseGeneratorConvertor> convertors;

    /**
     * 入参处理类，如果需要扩展参数的转换方式时可以继承并注册
     */
//    private List<MethodParameterResolver> parameterResolvers;

    private Map<String, String> urlAlias;

    public void init() {
        chains = new ArrayList<>();
//        convertors = new ArrayList<>();
//        parameterResolvers = new ArrayList<>();
        urlAlias = new HashMap<>();

//        if (sourceReaders != null && !sourceReaders.isEmpty()) {
//            for (SourceReader reader : sourceReaders) {
//                if (reader != null) {
//                    if (reader.getChains() != null) {
//                        chains.addAll(reader.getChains());
//                    }
//                    if (reader.getConvertors() != null) {
//                        convertors.addAll(reader.getConvertors());
//                    }
//                    if (reader.getParameterResolvers() != null) {
//                        parameterResolvers.addAll(reader.getParameterResolvers());
//                    }
//                    if (reader.getUrlAlias() != null) {
//                        urlAlias.putAll(reader.getUrlAlias());
//                    }
//                }
//            }
//        }

        //默认的链
//        chains.add(new BeanParamParseChain());
//        chains.add(new UrlWrapperChain(this));
//        chains.add(new ParameterResolverChain(this));
//        chains.add(new GenerateResponseChain(this));
//        chains.add(new ExecuteRequestChain());

//        //默认参数解析类
//        parameterResolvers.add(new UrlParameterResolver());
//        parameterResolvers.add(new ArrayParameterResolver());
//        parameterResolvers.add(new RequestBodyParameterResolver());
//        parameterResolvers.add(new DefaultMethodParameterResolver());
//
//        //默认结果解析器
//        convertors.add(new JsonPathConvertor());
//        convertors.add(new DefaultResponseGeneratorConvertor());

    }

}
