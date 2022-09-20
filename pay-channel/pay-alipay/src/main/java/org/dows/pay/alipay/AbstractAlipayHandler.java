package org.dows.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.boot.PayClientFactory;

public abstract class AbstractAlipayHandler implements PayHandler {

    protected AlipayClient getAlipayClient(String appId) {
        return PayClientFactory.getAlipayClient(appId);
    }

    protected AlipayClient getCertAlipayClient(String appId) throws AlipayApiException {
        return PayClientFactory.getCertAlipayClient(appId);
    }


    public String getChannel() {
        return PayChannels.ALIPAY.name();
    }
}