package org.dows.pay.service.impl;


import org.springframework.stereotype.Service;
import org.dows.pay.service.IPayTransactionService;
import org.dows.pay.entity.PayTransactionEntity;
import org.dows.pay.mapper.PayTransactionMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

/**
 * 支付交易表 服务层实现。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Service
public class PayTransactionServiceImpl extends ServiceImpl<PayTransactionMapper, PayTransactionEntity> implements IPayTransactionService {

}