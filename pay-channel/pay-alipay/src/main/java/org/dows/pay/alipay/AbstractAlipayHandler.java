package org.dows.pay.alipay;

import com.alipay.api.AlipayClient;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.boot.PayClientFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractAlipayHandler implements PayHandler {

    @Autowired
    private PayClientFactory payClientFactory;

    protected AlipayClient getAlipayClient(String appId) {
        return payClientFactory.getAlipayClient(appId);
    }


//    protected AlipayMsgClient getAlipayMsgClient(String appId) {
//        return PayClientFactory.getAlipayMsgClient(appId);
//    }


    public String getChannel() {
        return PayChannels.ALIPAY.name();
    }
}
