package org.dows.pay.service.impl;


import org.springframework.stereotype.Service;
import org.dows.pay.service.IPayInstanceService;
import org.dows.pay.entity.PayInstanceEntity;
import org.dows.pay.mapper.PayInstanceMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

/**
 * 支付通道实例表 服务层实现。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Service
public class PayInstanceServiceImpl extends ServiceImpl<PayInstanceMapper, PayInstanceEntity> implements IPayInstanceService {

}