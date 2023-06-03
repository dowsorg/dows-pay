package org.dows.sdk.weixin.auth;

import org.dows.sdk.weixin.auth.base.Credential;
import org.dows.sdk.weixin.auth.base.Validator;
import org.dows.sdk.weixin.auth.base.WechatPay2Credential;
import org.dows.sdk.weixin.auth.base.WechatPay2Validator;
import org.dows.sdk.weixin.auth.certificate.CertificateProvider;
import org.dows.sdk.weixin.auth.cipher.*;
import org.dows.sdk.weixin.auth.util.PemUtil;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/**
 * RSAConfig抽象类
 */
public abstract class AbstractRSAConfig implements Config {

    protected AbstractRSAConfig(
            String merchantId,
            PrivateKey privateKey,
            String merchantSerialNumber,
            CertificateProvider certificateProvider) {
        this.merchantId = merchantId;
        this.privateKey = privateKey;
        this.merchantSerialNumber = merchantSerialNumber;
        this.certificateProvider = certificateProvider;
    }

    /**
     * 商户号
     */
    private final String merchantId;
    /**
     * 商户私钥
     */
    private final PrivateKey privateKey;
    /**
     * 商户证书序列号
     */
    private final String merchantSerialNumber;
    /**
     * 微信支付平台证书Provider
     */
    private final CertificateProvider certificateProvider;

    @Override
    public PrivacyEncryptor createEncryptor() {
        X509Certificate certificate = certificateProvider.getAvailableCertificate();
        return new RSAPrivacyEncryptor(
                certificate.getPublicKey(), PemUtil.getSerialNumber(certificate));
    }

    @Override
    public PrivacyDecryptor createDecryptor() {
        return new RSAPrivacyDecryptor(privateKey);
    }

    @Override
    public Credential createCredential() {
        return new WechatPay2Credential(merchantId, createSigner());
    }

    @Override
    public Validator createValidator() {
        return new WechatPay2Validator(new RSAVerifier(certificateProvider));
    }

    @Override
    public Signer createSigner() {
        return new RSASigner(merchantSerialNumber, privateKey);
    }
}
