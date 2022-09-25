package org.dows.pay.service.impl;

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

}

