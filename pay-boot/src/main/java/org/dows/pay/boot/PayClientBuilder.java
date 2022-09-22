package org.dows.pay.boot;

import com.alipay.api.*;
import org.dows.pay.boot.config.PayClientProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class PayClientBuilder {

    /**
     * 普通公钥方式
     */
    public static AlipayClient buildClient(PayClientProperties config) {
        AlipayClient alipayClient = new DefaultAlipayClient(
                config.getServiceUrl(),
                config.getAppId(),
                config.getPrivateKey(),
                config.getFormat(),
                config.getCharset(),
                config.getPayPublicKey(),
                config.getSignType());
        return alipayClient;
    }


    /**
     * 证书模式
     *
     * @return {@link AlipayClient}  支付宝支付配置
     * @throws AlipayApiException 支付宝 Api 异常
     */
    public static AlipayClient buildCertClient(PayClientProperties alipayProperties) {
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setServerUrl(alipayProperties.getServiceUrl());
        //设置应用Id
        alipayConfig.setAppId(alipayProperties.getAppId());
        //设置 新应用私钥（需要变更）
        alipayConfig.setPrivateKey(alipayProperties.getPrivateKey());
        //设置请求格式，固定值json
        alipayConfig.setFormat(alipayProperties.getFormat());
        //设置字符集
        alipayConfig.setCharset(alipayProperties.getCharset());
        //设置签名类型
        alipayConfig.setSignType(alipayProperties.getSignType());
        try {
            //设置 新应用公钥证书路径（需要变更）"classpath:alipay/appCertPublicKey_2021003129694075.crt"
            alipayConfig.setAppCertPath(ResourceUtils.getFile(alipayProperties.getAppCertPath()).getAbsolutePath());
            //设置支付宝公钥证书路径（无需变更）"alipay/alipayCertPublicKey_RSA2.crt"
            alipayConfig.setAlipayPublicCertPath(ResourceUtils.getFile(alipayProperties.getPayCertPath()).getAbsolutePath());
            //设置支付宝根证书路径（无需变更）"alipay/alipayRootCert.crt"
            alipayConfig.setRootCertPath(ResourceUtils.getFile(alipayProperties.getPayRootCertPath()).getAbsolutePath());
            //构造client
            return new DefaultAlipayClient(alipayConfig);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
//        certAlipayRequest.setAppId(alipayProperties.getAppId());
//        certAlipayRequest.setCertPath(alipayProperties.getAppCertPath());
//        certAlipayRequest.setAlipayPublicCertPath(alipayProperties.getPayCertPath());
//        certAlipayRequest.setRootCertPath(alipayProperties.getPayRootCertPath());
//        certAlipayRequest.setServerUrl(alipayProperties.getServiceUrl());
//        certAlipayRequest.setPrivateKey(alipayProperties.getPrivateKey());
//        certAlipayRequest.setFormat(alipayProperties.getFormat());
//        certAlipayRequest.setCharset(alipayProperties.getCharset());
//        certAlipayRequest.setSignType(alipayProperties.getSignType());
//        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
    }


    /**
     * 普通公钥方式
     */
    public static AlipayClient buildWeixinClient(PayClientProperties config) {
        AlipayClient alipayClient = new DefaultAlipayClient(
                config.getServiceUrl(),
                config.getAppId(),
                config.getPrivateKey(),
                config.getFormat(),
                config.getCharset(),
                config.getPayPublicKey(),
                config.getSignType());
        return alipayClient;
    }


    public static AlipayClient buildCertWeixinClient(PayClientProperties alipayProperties) throws AlipayApiException {
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        certAlipayRequest.setAppId(alipayProperties.getAppId());
        certAlipayRequest.setCertPath(alipayProperties.getAppCertPath());
        certAlipayRequest.setAlipayPublicCertPath(alipayProperties.getPayCertPath());
        certAlipayRequest.setRootCertPath(alipayProperties.getPayRootCertPath());
        certAlipayRequest.setServerUrl(alipayProperties.getServiceUrl());
        certAlipayRequest.setPrivateKey(alipayProperties.getPrivateKey());
        certAlipayRequest.setFormat(alipayProperties.getFormat());
        certAlipayRequest.setCharset(alipayProperties.getCharset());
        certAlipayRequest.setSignType(alipayProperties.getSignType());
        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
        return alipayClient;
    }


}
