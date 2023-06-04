package org.dows.sdk.weixin.auth.base;

import lombok.extern.slf4j.Slf4j;
import org.dows.sdk.client.cipher.Verifier;
import org.dows.sdk.client.http.HttpHeaders;
import org.dows.sdk.client.security.Validator;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;

import static java.util.Objects.requireNonNull;
import static org.dows.sdk.client.http.Constant.*;

/**
 * 微信支付返回验证器
 */
@Slf4j
public final class WechatPay2Validator implements Validator {

    private static final int RESPONSE_EXPIRED_MINUTES = 5;
    private final Verifier verifier;

    public WechatPay2Validator(Verifier verifier) {
        this.verifier = requireNonNull(verifier);
    }

    @Override
    public <T> boolean validate(HttpHeaders responseHeaders, String responseBody) {
        String timestamp = responseHeaders.getHeader(WECHAT_PAY_TIMESTAMP);
        try {
            Instant responseTime = Instant.ofEpochSecond(Long.parseLong(timestamp));
            // 拒绝过期请求
            if (Duration.between(responseTime, Instant.now()).abs().toMinutes() >= RESPONSE_EXPIRED_MINUTES) {
                throw new IllegalArgumentException(String.format(
                        "Validate http response,timestamp[%s] of httpResponse is expires, " + "request-id[%s]",
                        timestamp, responseHeaders.getHeader(REQUEST_ID)));
            }
        } catch (DateTimeException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format(
                    "Validate http response,timestamp[%s] of httpResponse is invalid, request-id[%s]",
                    timestamp, responseHeaders.getHeader(REQUEST_ID)));
        }
        String message = timestamp
                + "\n"
                + responseHeaders.getHeader(WECHAT_PAY_NONCE)
                + "\n"
                + (responseBody == null ? "" : responseBody)
                + "\n";
        log.debug("Message for verifying signatures is[{}]", message);
        String serialNumber = responseHeaders.getHeader(WECHAT_PAY_SERIAL);
        log.debug("SerialNumber for verifying signatures is[{}]", serialNumber);
        String signature = responseHeaders.getHeader(WECHAT_PAY_SIGNATURE);
        log.debug("Signature for verifying signatures is[{}]", signature);
        return verifier.verify(serialNumber, message, signature);
    }
}
