package org.dows.pay.api;

public interface PayHandler {

    String getChannel();

    default void onMessage(PayMessage payMessage) {
    }


}
