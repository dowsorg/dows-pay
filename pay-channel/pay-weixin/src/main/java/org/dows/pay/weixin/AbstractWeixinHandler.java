package org.dows.pay.weixin;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.boot.PayClientFactory;

public abstract class AbstractWeixinHandler implements PayHandler {

    /**
     * todo 改换成微信的
     *
     * @param appId
     * @return
     */
    protected AlipayClient getWeixinClient(String appId) {
        return PayClientFactory.getAlipayClient(appId);
    }

    /**
     * todo 改成微信的
     *
     * @param appId
     * @return
     * @throws AlipayApiException
     */
    protected AlipayClient getCertWeixinClient(String appId) throws AlipayApiException {
        return PayClientFactory.getCertAlipayClient(appId);
    }


    @Override
    public String getChannel() {
        return PayChannels.WEIXIN.name();
    }
}
