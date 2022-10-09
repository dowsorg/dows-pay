package org.dows.pay.alipay;

import org.dows.pay.api.PayHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 支付相关业务功能,如：，
 * 当面付：https://open.alipay.com/api/detail?code=I1080300001000041016
 * app付款：https://open.alipay.com/api/detail?code=I1080300001000041313
 */
public class AlipayPayHandler  extends AbstractAlipayHandler  {



    /**
     * todo 用户支付成功回调，内部数据处理逻辑
     *
     * @param request
     * @return
     * @throws IOException
     */
    public String onPaySuccess(HttpServletRequest request) {


        return null;
    }

}
