package org.dows.pay.api;

public interface PayMessage {
    String getAppId();

    String getMsgApi();

    String getMsgId();

    String getBizContent();
}
