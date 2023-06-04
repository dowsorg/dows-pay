package org.dows.sdk.client.feign;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

// 创建一个新的转换器 解析[text/plain]
public class ApiMessageConverter extends MappingJackson2HttpMessageConverter {

    public ApiMessageConverter() {
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        setSupportedMediaTypes(mediaTypes);
    }
}