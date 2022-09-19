package org.dows.pay.alipay;

import org.dows.pay.api.PayHandler;

/**
 * 支付相关业务功能,如：，
 * 当面付：https://open.alipay.com/api/detail?code=I1080300001000041016
 * app付款：https://open.alipay.com/api/detail?code=I1080300001000041313
 */
@PayHandler(channelCode = "alipay")
public class AlipayPayHandler {


}
