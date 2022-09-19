package org.dows.pay.boot;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import org.dows.pay.boot.config.PayClientConfig;
import org.springframework.stereotype.Service;

@Service
public class PayClientBuilder {

    /**
     * 普通公钥方式
     */
    public static AlipayClient buildClient(PayClientConfig config) {
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
    public static AlipayClient buildCertClient(PayClientConfig alipayProperties) throws AlipayApiException {
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
