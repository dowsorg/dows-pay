package org.dows.pay.weixin.service;

import com.github.binarywang.wxpay.bean.ecommerce.PartnerTransactionsResult;
import org.dows.pay.form.PayPartnerTransactionsQueryForm;

public interface weixinPayHandlerService {

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
