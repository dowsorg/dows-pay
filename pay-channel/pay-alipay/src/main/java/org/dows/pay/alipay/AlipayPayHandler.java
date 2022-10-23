package org.dows.pay.alipay;

import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.message.AlipayMessage;
import org.springframework.context.event.EventListener;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 支付相关业务功能,如：，
 * 当面付：https://open.alipay.com/api/detail?code=I1080300001000041016
 * app付款：https://open.alipay.com/api/detail?code=I1080300001000041313
 */
public class AlipayPayHandler extends AbstractAlipayHandler {


    /**
     * 去支付
     * @param payRequest
     */
    public void toPay(PayRequest payRequest){


    }




    /**
     * todo 用户支付成功回调，内部数据处理逻辑
     *
     * @param request
     * @return
     * @throws IOException
     */
    /**
     * 商户确认服务商代创建小程序结果通知
     */
    @EventListener(value = {PayEvent.class})
    public String onPaySuccess(PayEvent<AlipayMessage> payEvent) {


        return null;
    }

}
