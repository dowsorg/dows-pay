package org.dows.pay.boot;

import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.alipay.api.*;
import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.BaseWxPayServiceImpl;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import me.chanjar.weixin.open.api.WxOpenComponentService;
import me.chanjar.weixin.open.api.WxOpenConfigStorage;
import me.chanjar.weixin.open.api.WxOpenMaService;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.api.impl.WxOpenInMemoryConfigStorage;
import me.chanjar.weixin.open.api.impl.WxOpenMaServiceImpl;
import me.chanjar.weixin.open.api.impl.WxOpenServiceAbstractImpl;
import me.chanjar.weixin.open.api.impl.WxOpenServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.dows.pay.boot.properties.PayClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
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
    public static WxPayService buildWeixinClient(PayClientProperties config) {
        WxPayConfig wxPayConfig = new WxPayConfig();
        //设置应用公众号ID
        wxPayConfig.setAppId(StringUtils.trimToNull(config.getAppId()));
        //设置商户号ID
        wxPayConfig.setMchId(StringUtils.trimToNull(config.getMchId()));
        //设置商户号KEY;
        wxPayConfig.setMchKey(StringUtils.trimToNull(config.getMchKey()));
        //设置应用公众号子ID
        wxPayConfig.setSubAppId(StringUtils.trimToNull(config.getSubAppId()));
        //设置商户号子ID
        wxPayConfig.setSubMchId(StringUtils.trimToNull(config.getSubMchId()));
        //设置KEYPATH;
        wxPayConfig.setKeyPath(StringUtils.trimToNull(config.getKeyPath()));
        //以下是apiv3以及支付分相关
        wxPayConfig.setServiceId(StringUtils.trimToNull(config.getServiceId()));
        wxPayConfig.setPayScoreNotifyUrl(StringUtils.trimToNull(config.getPayScoreNotifyUrl()));
        //设置私钥路径
        wxPayConfig.setPrivateKeyPath(StringUtils.trimToNull(config.getPrivateKeyPath()));
        //设置私钥证书路径
        wxPayConfig.setPrivateCertPath(StringUtils.trimToNull(config.getPrivateCertPath()));
        //设置私钥证书序列号
        wxPayConfig.setCertSerialNo(StringUtils.trimToNull(config.getCertSerialNo()));
        //设置APIV3KEY
        wxPayConfig.setApiV3Key(StringUtils.trimToNull(config.getApiV3Key()));
        WxPayService wxPayService  = new WxPayServiceImpl();
        wxPayService.setConfig(wxPayConfig);

        return wxPayService;
    }

    /**
     * 证书方式
     */

    public static WxPayService buildCertWeixinClient(PayClientProperties config) {
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId(StringUtils.trimToNull(config.getAppId()));
        wxPayConfig.setMchId(StringUtils.trimToNull(config.getMchId()));
        wxPayConfig.setMchKey(StringUtils.trimToNull(config.getMchKey()));
        wxPayConfig.setSubAppId(StringUtils.trimToNull(config.getSubAppId()));
        wxPayConfig.setSubMchId(StringUtils.trimToNull(config.getSubMchId()));
        wxPayConfig.setKeyPath(StringUtils.trimToNull(config.getKeyPath()));
        //以下是apiv3以及支付分相关
        wxPayConfig.setServiceId(StringUtils.trimToNull(config.getServiceId()));
        wxPayConfig.setPayScoreNotifyUrl(StringUtils.trimToNull(config.getPayScoreNotifyUrl()));
        wxPayConfig.setPrivateKeyPath(StringUtils.trimToNull(config.getPrivateKeyPath()));
        wxPayConfig.setPrivateCertPath(StringUtils.trimToNull(config.getPrivateCertPath()));
        wxPayConfig.setCertSerialNo(StringUtils.trimToNull(config.getCertSerialNo()));
        wxPayConfig.setApiV3Key(StringUtils.trimToNull(config.getApiV3Key()));
        WxPayService wxPayService  = new WxPayServiceImpl();
        wxPayService.setConfig(wxPayConfig);
        return wxPayService;
    }
    /**
     * 微信开放平台
     */
    public static WxOpenService buildWxOpenClient(PayClientProperties config) {
        WxOpenConfigStorage wxOpenConfigStorage = new WxOpenInMemoryConfigStorage();
        wxOpenConfigStorage.setComponentAppId(config.getAppId());
        wxOpenConfigStorage.setComponentAesKey(config.getAesKey());
        wxOpenConfigStorage.setComponentAppSecret(config.getAppSecret());
        wxOpenConfigStorage.setComponentToken(config.getToken());
        WxOpenService wxOpenService  = new WxOpenServiceImpl();
        wxOpenService.setWxOpenConfigStorage(wxOpenConfigStorage);

        return wxOpenService;
    }

    /**
     * 微信开放平台-管理二级商户相关
     */
    public static WxOpenMaService buildWxOpenMaClient(PayClientProperties config) {
        WxMaConfig wxMaConfig = new WxMaDefaultConfigImpl();
        WxOpenService wxOpenService = buildWxOpenClient(config);
        WxOpenMaService wxOpenMaService  = new WxOpenMaServiceImpl(wxOpenService.getWxOpenComponentService(),config.getAppId(), wxMaConfig);

        return wxOpenMaService;
    }

}
