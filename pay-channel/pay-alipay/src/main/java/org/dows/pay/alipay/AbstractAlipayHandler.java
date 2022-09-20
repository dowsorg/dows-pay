package org.dows.pay.alipay;

import org.dows.pay.api.PayHandler;
import org.dows.pay.api.enums.PayChannels;

public abstract class AbstractAlipayHandler implements PayHandler {

    @Override
    public String getChannel() {
        return PayChannels.ALIPAY.name();
    }
}
