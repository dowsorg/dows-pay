package org.dows.pay.service.impl;


import org.springframework.stereotype.Service;
import org.dows.pay.service.IPayApiService;
import org.dows.pay.entity.PayApiEntity;
import org.dows.pay.mapper.PayApiMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

/**
 * 支付通道接口表 服务层实现。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Service
public class PayApiServiceImpl extends ServiceImpl<PayApiMapper, PayApiEntity> implements IPayApiService {

}