package org.dows.pay.service.impl;

import cn.hutool.core.util.StrUtil;
import org.dows.framework.api.exceptions.BizException;
import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.entity.PayTransaction;
import org.dows.pay.mapper.PayTransactionMapper;
import org.dows.pay.service.PayTransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;


/**
 * 支付交易(PayTransaction)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:44
 */
@Service("payTransactionService")
public class PayTransactionServiceImpl extends MybatisCrudServiceImpl<PayTransactionMapper, PayTransaction> implements PayTransactionService {

    @Override
    public void updateStatusByOrderId(String transactionId,String desc,String outTradeNo, Integer code,Integer amount) {
        this.lambdaUpdate()
                .eq(PayTransaction::getTransactionNo, outTradeNo)
                .set(PayTransaction::getStatus, code)
                .set(PayTransaction::getAmount,new BigDecimal(amount.toString()).divide(new BigDecimal(100),2, RoundingMode.DOWN))
                .set(PayTransaction::getTradeState,desc)
                .set(PayTransaction::getTransactionTime,new Date())
                .set(PayTransaction::getDealTo, transactionId)
                .update();
    }

    @Override
    public PayTransaction getByTransactionNo(String outTradeNo) {
        return this.lambdaQuery()
                .eq(PayTransaction::getTransactionNo,outTradeNo)
                .last(" limit 1")
                .one();
    }

    @Override
    public PayTransaction getByOrderId(String orderId) {
        return this.lambdaQuery()
                .eq(PayTransaction::getOrderId,orderId)
                .last(" limit 1")
                .one();
    }

    @Override
    public PayTransaction queryPayOrder(String orderId, String outTradeNo) {
        if (StrUtil.isEmpty(orderId) && StrUtil.isEmpty(outTradeNo)) {
            throw new BizException("交易单号任选一项必填");
        }
        return this.lambdaQuery()
                .eq(StrUtil.isNotEmpty(orderId), PayTransaction::getOrderId, orderId)
                .eq(StrUtil.isNotEmpty(outTradeNo), PayTransaction::getDealTo, outTradeNo)
                .orderByDesc(PayTransaction::getId)
                .last(" limit 1").one();
    }

    private String queryWechatOrder(String transactionNo, String appId) {

        return null;
    }

    @Override
    public PayTransaction getByOrderIdAndMerchantNo(String merchantNo, String orderId) {
        return this.lambdaQuery()
                .eq(StrUtil.isNotEmpty(merchantNo),PayTransaction::getMerchantNo,merchantNo)
                .eq(PayTransaction::getOrderId,orderId)
                .last(" limit 1").one();
    }
}


