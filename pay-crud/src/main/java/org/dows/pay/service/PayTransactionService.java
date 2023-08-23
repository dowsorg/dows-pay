package org.dows.pay.service;

import org.dows.pay.entity.PayTransaction;
import org.dows.framework.crud.mybatis.MybatisCrudService;


/**
 * 支付交易(PayTransaction)表服务接口
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:44
 */
public interface PayTransactionService extends MybatisCrudService<PayTransaction> {

    PayTransaction getByOrderIdAndMerchantNo(String merchantNo, String orderId);

    void updateStatusByOrderId(String transactionId,String payDesc,String outTradeNo, Integer code,Integer amount);

    PayTransaction getByTransactionNo(String outTradeNo);

    PayTransaction getByOrderId(String orderId);

    PayTransaction queryPayOrder(String orderId, String outTradeNo);
}

