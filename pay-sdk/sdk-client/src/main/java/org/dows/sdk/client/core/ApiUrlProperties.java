package org.dows.sdk.client.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@ConfigurationProperties("dows.sdk")
public class ApiUrlProperties {

    private Map<String, String> weixin;

    private Map<String, String> alipay;

    private Map<String, String> douyin;
}
