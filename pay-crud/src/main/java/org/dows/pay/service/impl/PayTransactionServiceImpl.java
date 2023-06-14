package org.dows.pay.service.impl;

import cn.hutool.core.util.StrUtil;
import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayTransactionMapper;
import org.dows.pay.entity.PayTransaction;
import org.dows.pay.service.PayTransactionService;
import org.springframework.stereotype.Service;


/**
 * 支付交易(PayTransaction)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:44
 */
@Service("payTransactionService")
public class PayTransactionServiceImpl extends MybatisCrudServiceImpl<PayTransactionMapper, PayTransaction> implements PayTransactionService {

    @Override
    public void updateStatusByOrderId(String outTradeNo, Integer code) {
        this.lambdaUpdate()
                .eq(PayTransaction::getOrderId,outTradeNo)
                .set(PayTransaction::getStatus,code);
    }

    @Override
    public PayTransaction getByOrderIdAndMerchantNo(String merchantNo, String orderId) {
        return this.lambdaQuery()
                .eq(StrUtil.isNotEmpty(merchantNo),PayTransaction::getMerchantNo,merchantNo)
                .eq(PayTransaction::getOrderId,orderId)
                .last(" limit 1").one();
    }
}


