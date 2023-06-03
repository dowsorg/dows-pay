package org.dows.sdk.weixin.auth.exception;

public class DecryptionException extends WechatPayException {
    private static final long serialVersionUID = 1L;

    public DecryptionException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
