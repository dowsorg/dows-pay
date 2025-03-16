package org.dows.pay.service.impl;


import org.springframework.stereotype.Service;
import org.dows.pay.service.IPayMethodService;
import org.dows.pay.entity.PayMethodEntity;
import org.dows.pay.mapper.PayMethodMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

/**
 * 支付方法表 服务层实现。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Service
public class PayMethodServiceImpl extends ServiceImpl<PayMethodMapper, PayMethodEntity> implements IPayMethodService {

}