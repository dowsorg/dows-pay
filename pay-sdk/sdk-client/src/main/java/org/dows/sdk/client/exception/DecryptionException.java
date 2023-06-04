package org.dows.sdk.client.exception;

public class DecryptionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DecryptionException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
