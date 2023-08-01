package org.dows.pay.api;

import com.github.binarywang.wxpay.bean.ecommerce.PartnerTransactionsResult;
import org.dows.pay.form.PayPartnerTransactionsQueryForm;

public interface weixinPayHandlerApiServiceImpl {

    /**
     * 查询订单
     * @param payRequest
     */
    PartnerTransactionsResult queryOrder(PayPartnerTransactionsQueryForm payRequest);

    /**
     * 关闭订单
     * @param payRequest
     */
    String closeOrder(PayPartnerTransactionsQueryForm payRequest);
}
