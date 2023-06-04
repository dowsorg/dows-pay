package org.dows.sdk.weixin.auth.base;

import lombok.extern.slf4j.Slf4j;
import org.dows.sdk.client.cipher.SignatureResult;
import org.dows.sdk.client.cipher.Signer;
import org.dows.sdk.client.security.Credential;
import org.dows.sdk.client.util.NonceUtil;

import java.net.URI;
import java.time.Instant;

import static java.util.Objects.requireNonNull;

/**
 * 微信支付认证凭据生成器
 */
@Slf4j
public final class WechatPay2Credential implements Credential {
    public static final String SCHEMA_PREFIX = "WECHATPAY2-";
    private static final int NONCE_LENGTH = 32;
    private final String merchantId;
    private final Signer signer;

    public WechatPay2Credential(String merchantId, Signer signer) {
        this.merchantId = requireNonNull(merchantId);
        this.signer = requireNonNull(signer);
    }

    @Override
    public String getMerchantId() {
        return merchantId;
    }

    @Override
    public String getSchema() {
        return SCHEMA_PREFIX + signer.getAlgorithm();
    }

    @Override
    public String getAuthorization(URI uri, String httpMethod, String signBody) {
        requireNonNull(uri);
        requireNonNull(httpMethod);
        return getSchema() + " " + getToken(uri, httpMethod, signBody);
    }

    private String getToken(URI uri, String httpMethod, String signBody) {
        String nonceStr = NonceUtil.createNonce(NONCE_LENGTH);
        long timestamp = Instant.now().getEpochSecond();
        String message = buildMessage(nonceStr, timestamp, uri, httpMethod, signBody);
        log.debug("authorization message[{}]", message);
        SignatureResult signature = signer.sign(message);
        String token = "mchid=\""
                + getMerchantId()
                + "\","
                + "nonce_str=\""
                + nonceStr
                + "\","
                + "timestamp=\""
                + timestamp
                + "\","
                + "serial_no=\""
                + signature.getCertificateSerialNumber()
                + "\","
                + "signature=\""
                + signature.getSign()
                + "\"";
        log.debug("The generated request signature information is[{}]", token);
        return token;
    }

    private String buildMessage(String nonce, long timestamp, URI uri, String httpMethod, String signBody) {
        String canonicalUrl = uri.getRawPath();
        if (uri.getQuery() != null) {
            canonicalUrl += "?" + uri.getRawQuery();
        }
        return httpMethod
                + "\n"
                + canonicalUrl
                + "\n"
                + timestamp
                + "\n"
                + nonce
                + "\n"
                + (signBody == null ? "" : signBody)
                + "\n";
    }
}
