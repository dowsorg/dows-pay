package org.dows.pay.service.impl;


import org.springframework.stereotype.Service;
import org.dows.pay.service.IPayAccountService;
import org.dows.pay.entity.PayAccountEntity;
import org.dows.pay.mapper.PayAccountMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

/**
 * 支付通道账号表 服务层实现。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Service
public class PayAccountServiceImpl extends ServiceImpl<PayAccountMapper, PayAccountEntity> implements IPayAccountService {

}