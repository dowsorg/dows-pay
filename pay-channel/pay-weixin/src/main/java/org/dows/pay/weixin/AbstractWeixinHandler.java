package org.dows.pay.weixin;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.boot.PayClientFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractWeixinHandler implements PayHandler {
    @Autowired
    private PayClientFactory payClientFactory;

    /**
     * todo 改换成微信的
     *
     * @param appId
     * @return
     */
    protected AlipayClient getWeixinClient(String appId) {
        return payClientFactory.getWeixinClient(appId);

    }


    @Override
    public String getChannel() {
        return PayChannels.WEIXIN.name();
    }
}
