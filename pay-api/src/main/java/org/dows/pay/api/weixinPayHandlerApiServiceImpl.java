package org.dows.pay.api;

import com.github.binarywang.wxpay.bean.ecommerce.PartnerTransactionsResult;
import org.dows.pay.form.PayPartnerTransactionsQueryForm;

public interface weixinPayHandlerApiServiceImpl {

    /**
     * 创建订单 (服务员和扫码下单)
     * @param queryRequest
     */
    PartnerTransactionsResult queryOrder(PayPartnerTransactionsQueryForm queryRequest);

    /**
     * 创建订单 (服务员和扫码下单)
     * @param closeRequest
     */
    String closeOrder(PayPartnerTransactionsQueryForm closeRequest);
}
