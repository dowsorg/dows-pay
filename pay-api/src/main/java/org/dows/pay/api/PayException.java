package org.dows.pay.api;

/**
 * 支付异常
 */
public class PayException extends Exception {

    private static final long serialVersionUID = -5710488447295073398L;

    public PayException() {
    }

    public PayException(String message) {
        super(message);
    }

    public PayException(Throwable throwable) {
        super(throwable);
    }

    public PayException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
