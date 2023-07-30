package org.dows.pay.boot;

import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.open.api.WxOpenConfigStorage;
import me.chanjar.weixin.open.api.WxOpenMaService;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.api.impl.WxOpenInMemoryConfigStorage;
import me.chanjar.weixin.open.api.impl.WxOpenMaServiceImpl;
import me.chanjar.weixin.open.api.impl.WxOpenServiceImpl;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.dows.auth.api.TempRedisApi;
import org.dows.pay.boot.properties.PayClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class PayClientBuilder {

    private static String PREFIX_CERTIFICATE_PATH = "/opt/file/";
    @Autowired
    private   TempRedisApi tempRedisApi;
    private static  PayClientBuilder payClientBuilder;
    @PostConstruct
    public void init(){
        payClientBuilder = this;
        payClientBuilder.tempRedisApi = this.tempRedisApi;
    }
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
            alipayConfig.setAppCertPath(getAbsolutePath(alipayProperties.getAliCertPath()));
            //设置支付宝公钥证书路径（无需变更）"alipay/alipayCertPublicKey_RSA2.crt"
            alipayConfig.setAlipayPublicCertPath(getAbsolutePath(alipayProperties.getAliPayCertPath()));
            //设置支付宝根证书路径（无需变更）"alipay/alipayRootCert.crt"
            alipayConfig.setRootCertPath(getAbsolutePath(alipayProperties.getAliPayRootCertPath()));
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

    private static String getAbsolutePath(String aliCertPath) {
        String filePath = PREFIX_CERTIFICATE_PATH + aliCertPath.split(StringPool.COLON)[1];
        File inuModel = new File(filePath);
        if (inuModel.exists()) {
            return inuModel.getAbsolutePath();
        }
        try {
            Resource resource = new ClassPathResource(aliCertPath.split(StringPool.COLON)[1]);
            FileUtils.copyToFile(resource.getInputStream(), inuModel);
            return inuModel.getAbsolutePath();
        } catch (IOException e) {
           log.error("getAbsolutePath error:",e);
        }
        return null;
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
        log.info("Redis中的component_verify_ticket:{}",payClientBuilder.tempRedisApi.getKey("component_verify_ticket").getRvalue());
        wxOpenConfigStorage.setComponentVerifyTicket(payClientBuilder.tempRedisApi.getKey("component_verify_ticket").getRvalue());
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
