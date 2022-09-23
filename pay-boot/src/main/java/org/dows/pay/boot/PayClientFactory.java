package org.dows.pay.boot;

import cn.hutool.core.util.StrUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import lombok.RequiredArgsConstructor;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.boot.config.PayClientConfig;
import org.dows.pay.boot.config.PayClientProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Configuration
@EnableConfigurationProperties(PayClientConfig.class)
public class PayClientFactory {

    private final PayClientConfig payClientConfig;
    private static final Map<String, PayClientProperties> PCM = new HashMap<>();

    private static final Map<String, AlipayClient> ALIPAY_CLIENT_MAP = new ConcurrentHashMap<>();

    private static final Map<String, AlipayClient> WEIXIN_CLIENT_MAP = new ConcurrentHashMap<>();
    /**
     * SpringBoot获取当前环境代码,Spring获取当前环境代码
     */
    @Value("${spring.profiles.active}")
    private String profiles;


    @PostConstruct
    public void init() {

    }

    /**
     * 容器bean初始化完成后加载配置
     *
     * @param contextRefreshedEvent
     */
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //todo 从数据查询客户端配置列表payClientConfigService.selectAll(profiles);
        List<PayClientProperties> payClientPropertiesList = null;
        //PCM.putAll(payClientPropertiesList.stream().collect(Collectors.toMap(PayClientProperties::getAppId, Function.identity())));
        PCM.putAll(payClientConfig.getClientConfigs().stream()
                .filter(pc -> StrUtil.isNotBlank(pc.getAppId()))
                .collect(Collectors.toMap(PayClientProperties::getPayId, Function.identity())));
    }

    /**
     * 获取支付宝客户端
     *
     * @param appId
     * @return
     */
    public static AlipayClient getAlipayClient(String appId) {
        AlipayClient client = ALIPAY_CLIENT_MAP.get(appId);
        if (client != null) {
            return client;
        }
        PayClientProperties payClientProperties = PCM.get(appId + "@" + PayChannels.ALIPAY.name().toLowerCase());
        if (payClientProperties.getCertModel() == 0) {
            client = PayClientBuilder.buildClient(payClientProperties);
        } else if (payClientProperties.getCertModel() == 1) {
            client = PayClientBuilder.buildCertClient(payClientProperties);
        }
        ALIPAY_CLIENT_MAP.put(appId, client);
        return client;
    }


    public static AlipayClient getWeixinClient(String appId) {
        AlipayClient client = WEIXIN_CLIENT_MAP.get(appId);
        if (client != null) {
            return client;
        }
        PayClientProperties payClientProperties = PCM.get(appId + "@" + PayChannels.ALIPAY.name().toLowerCase());
        if (payClientProperties.getCertModel() == 0) {
            client = PayClientBuilder.buildClient(payClientProperties);
        } else if (payClientProperties.getCertModel() == 1) {
            client = PayClientBuilder.buildCertClient(payClientProperties);
        }
        WEIXIN_CLIENT_MAP.put(appId, client);
        return client;
    }


}
