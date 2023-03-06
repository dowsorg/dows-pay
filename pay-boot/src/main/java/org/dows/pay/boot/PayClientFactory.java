package org.dows.pay.boot;

import cn.hutool.core.util.StrUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.msg.AlipayMsgClient;
import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.open.api.WxOpenMaService;
import me.chanjar.weixin.open.api.WxOpenService;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayException;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.api.message.AlipayMessage;
import org.dows.pay.boot.properties.PayClientProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableConfigurationProperties(PayClientConfig.class)
public class PayClientFactory {

    private final PayClientConfig payClientConfig;
    private static final Map<String, PayClientProperties> PCM = new HashMap<>();
    private static final Map<String, AlipayClient> ALIPAY_CLIENT_MAP = new ConcurrentHashMap<>();
    private static final Map<String, AlipayMsgClient> ALIPAY_MSG_CLIENT_MAP = new ConcurrentHashMap<>();
    private static final Map<String, WxPayService> WEIXIN_CLIENT_MAP = new ConcurrentHashMap<>();
    private static final Map<String, WxOpenService> WEIXIN_OPEN_MAP = new ConcurrentHashMap<>();
    private static final Map<String, WxOpenMaService> WEIXIN_OPEN_MA_MAP = new ConcurrentHashMap<>();
    // 事件发布
    private final ApplicationEventPublisher applicationEventPublisher;
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
    public AlipayClient getAlipayClient(String appId) {
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
        // 设置消息客户端
        AlipayMsgClient alipayMsgClient = registAlipayMsgClient(appId);
        ALIPAY_MSG_CLIENT_MAP.put(appId, alipayMsgClient);

        ALIPAY_CLIENT_MAP.put(appId, client);
        return client;
    }




    public AlipayMsgClient getAlipayMsgClient(String appId) {
        AlipayMsgClient alipayMsgClient = ALIPAY_MSG_CLIENT_MAP.get(appId);

        return alipayMsgClient;
    }
    public PayClientProperties getPayClientProperties(String appId){
        PayClientProperties payClientProperties = payClientConfig.getClientConfigs().stream()
                .filter(p -> p.getAppId().equalsIgnoreCase(appId))
                .findFirst()
                .orElse(null);
        return payClientProperties;
    }


    private AlipayMsgClient registAlipayMsgClient(String appId) {
        PayClientProperties payClientProperties = PCM.get(appId + "@" + PayChannels.ALIPAY.name().toLowerCase());
        // 目标支付宝服务端地址，线上环境为 openchannel.alipay.com
        String serverHost = "openchannel.alipay.com";
        String signType = payClientProperties.getSignType();
        String charset = payClientProperties.getCharset();
        String appPrivateKey = payClientProperties.getPrivateKey();
        AlipayMsgClient alipayMsgClient = AlipayMsgClient.getInstance(appId);
        try {
            //设置 新应用公钥证书路径（需要变更）"classpath:alipay/appCertPublicKey_2021003129694075.crt"
            String certPath = ResourceUtils.getFile(payClientProperties.getAppCertPath()).getAbsolutePath();
            //设置支付宝公钥证书路径（无需变更）"alipay/alipayCertPublicKey_RSA2.crt"
            String alipayPublicCertPath = ResourceUtils.getFile(payClientProperties.getPayCertPath()).getAbsolutePath();
            //设置支付宝根证书路径（无需变更）"alipay/alipayRootCert.crt"
            String rootCertPath = ResourceUtils.getFile(payClientProperties.getPayRootCertPath()).getAbsolutePath();
            alipayMsgClient.setConnector(serverHost);
            alipayMsgClient.setSecurityCertConfig(signType, appPrivateKey, certPath, alipayPublicCertPath, rootCertPath);
            alipayMsgClient.setCharset(charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /**
         * 客户端接收到消息后回调此方法
         *  @param  msgApi 接收到的消息的消息api名
         *  @param  msgId 接收到的消息的消息id
         *  @param  bizContent 接收到的消息的内容，json格式
         */
        alipayMsgClient.setMessageHandler((msgApi, msgId, bizContent) -> {
            mqListener(appId, msgApi, msgId, bizContent);
        });
        try {
            alipayMsgClient.connect();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return alipayMsgClient;
    }


    /**
     * code	msg	说明	处理方式
     * 10000	success	消息提交成功	﻿-
     * 20000	msg.unknow-error	服务暂不可用	请稍后重试或者联系技术支持。
     * 20001	msg.no-permission	无权限发送该消息	请检查是否开通相关消息服务。
     * 30000	msg.invalid-parameter	存在非法的消息参数	请检查请求参数是否合法。
     * 30000	msg.invalid-sign	验签失败
     * 检查公私钥是否是一对。
     * 检查公钥上传是否与私钥匹配。
     * 存在中文需要做 urlencode。
     * 签名算法是否无误。
     * msg.invalid-app-id	无效的appId	检查入参 app_id，app_id 不存在，或者未上线。
     * msg.invalid-msg-api	消息 API 不存在	请检查消息 API 名称是否有误
     * msg.empty-content	消息内容不允许为空	请检查请求消息对象是否正常设置
     * msg.invalid-timestamp	时间戳格式非法或者过期	时间戳参数 timestamp 非法，请检查格式为数字，精确到毫秒级，且在10分钟内。
     * msg.invalid-sign-type	非法的签名类型	检查入参 sign_type，目前只支持 RSA、RSA2。
     * msg.invalid-version	非法的version	非法的协议参数 version，请检查入参 version。
     * msg.invalid-charset	非法的字符集类型	请求参数 charset 错误，目前支持格式：GBK，UTF-8。
     * 30001	msg.missing-sign	缺少sign参数	请检查是否缺少协议参数 sign。
     * msg.missing-charset	缺少charset参数	请检查是否缺少协议参数 charset。
     * msg.missing-sign-type	缺少sign_type参数	请检查是否缺少协议参数 sign_type。
     * msg.missing-timestamp	缺少timestamp参数	请检查是否缺少协议参数 timestamp。
     * msg.missing-app-id	缺少appId参数	请检查参数 APPID 是否缺失。
     * msg.missing-msg-api	缺少msgApi参数	请检查参数 msgApi 是否缺失。
     * msg.missing-msg-id	缺失msgId参数	请检查消息报文是否缺少 msgId。
     * msg.missing-content	消息内容为空	请确保投递的消息内容不为空。
     * 40000	msg.consumer-not-exist	该消息不存在消费方	请确保该消息接口存在订阅方。
     * msg.sys-abort	系统已终止该消息的发送	订阅方取消订阅或者系统自动放弃投递。
     *
     * @param appId
     */
    private void mqListener(String appId, String msgApi, String msgId, String bizContent) {
        log.info("处理:{},{},{},{}", appId, msgApi, msgId, bizContent);
        //  todo 通过event事件监听
        AlipayMessage alipayMessage = AlipayMessage.builder()
                .appId(appId)
                .msgApi(msgApi)
                .msgId(msgId)
                .bizContent(bizContent)
                .build();
        PayEvent payEvent = new PayEvent(this, alipayMessage);
        //payEvent.setHandlerClass();
        applicationEventPublisher.publishEvent(payEvent);
    }


    public WxPayService getWeixinClient(String appId) {

        WxPayService client = WEIXIN_CLIENT_MAP.get(appId);
        if (client != null) {
            return client;
        }
        PayClientProperties payClientProperties = PCM.get(appId + "@" + PayChannels.WEIXIN.name().toLowerCase());
        if (payClientProperties.getCertModel() == 0) {
            client = PayClientBuilder.buildWeixinClient(payClientProperties);
        } else if (payClientProperties.getCertModel() == 1) {
            client = PayClientBuilder.buildCertWeixinClient(payClientProperties);
        }

        WEIXIN_CLIENT_MAP.put(appId, client);
        return client;
    }

    public WxOpenService getWxOpenClient(String appId) {

        WxOpenService client = WEIXIN_OPEN_MAP.get(appId);
        if (client != null) {
            return client;
        }
        PayClientProperties payClientProperties = PCM.get(appId + "@" + PayChannels.WEIXIN.name().toLowerCase());
        if (payClientProperties.getCertModel() == 2) {
            client = PayClientBuilder.buildWxOpenClient(payClientProperties);
        }
        WEIXIN_OPEN_MAP.put(appId, client);
        return client;
    }

    public WxOpenMaService getWxOpenMaClient(String appId) {

        WxOpenMaService client = WEIXIN_OPEN_MA_MAP.get(appId);
        if (client != null) {
            return client;
        }
        PayClientProperties payClientProperties = PCM.get(appId + "@" + PayChannels.WEIXIN.name().toLowerCase());
        if (payClientProperties.getCertModel() == 3) {
            client = PayClientBuilder.buildWxOpenMaClient(payClientProperties);
        }
        WEIXIN_OPEN_MA_MAP.put(appId, client);
        return client;
    }
    public static void main(String[] args) {
        try {
            System.out.println(AlipaySignature.getCertSN("E:\\workspaces\\java\\projects\\dows\\dows-pay\\pay-boot\\src\\main\\resources\\alipay\\appCertPublicKey_2021003129694075.crt"));
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }


}
