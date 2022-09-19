package org.dows.pay.boot;

import com.alipay.api.AlipayClient;
import org.dows.pay.boot.PayClientBuilder;
import org.dows.pay.boot.config.PayClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@ConfigurationProperties(prefix = "dows.pay")
public class PayClientFactory {
    private static final Map<String, PayClientConfig> PCM = new HashMap<>();
    @NestedConfigurationProperty
    private List<PayClientConfig> payClientConfigs;
    /**
     * SpringBoot获取当前环境代码,Spring获取当前环境代码
     */
    @Value("${spring.profiles.active}")
    private String profiles;

    /**
     * 容器bean初始化完成后加载配置
     *
     * @param contextRefreshedEvent
     */
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //todo 从数据查询客户端配置列表payClientConfigService.selectAll(profiles);
        List<PayClientConfig> payClientConfigList = null;
        //PCM.putAll(payClientConfigList.stream().collect(Collectors.toMap(PayClientConfig::getAppId, Function.identity())));
        PCM.putAll(payClientConfigs.stream().collect(Collectors.toMap(PayClientConfig::getAppId, Function.identity())));
    }

    /**
     * 获取支付宝客户端
     *
     * @param appId
     * @return
     */
    public AlipayClient getAlipayClient(String appId) {
        PayClientConfig payClientConfig = PCM.get(appId);
        AlipayClient alipayClient = PayClientBuilder.buildClient(payClientConfig);
        return alipayClient;
    }


}
