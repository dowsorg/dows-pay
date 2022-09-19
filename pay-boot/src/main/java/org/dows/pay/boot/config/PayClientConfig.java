package org.dows.pay.boot.config;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 通道配置 在yml/db/配置中心/数据库中配置
 */
@Data
public class PayClientConfig {

    // 环境（沙箱环境xbox/正式环境prd）
    private String env;
    private String channelCode = "alipay";
    @NotBlank(message = "appId 值不能为空")
    private String appId;
    @NotBlank(message = "privateKey 值不能为空")
    private String privateKey;
    private String payPublicKey;
    private String serviceUrl = "https://openapi.alipay.com/gateway.do";
    private String charset = "UTF-8";
    private String signType = "RSA2";
    private String format = "json";
    private boolean certModel;
    // 应用公钥证书路径
    private String appCertPath;
    //支付宝公钥证书文件路径
    private String payCertPath;
    //支付宝CA根证书文件路径
    private String payRootCertPath;
}
