package org.dows.pay.service.impl;


import org.springframework.stereotype.Service;
import org.dows.pay.service.IPayCodeService;
import org.dows.pay.entity.PayCodeEntity;
import org.dows.pay.mapper.PayCodeMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

/**
 * 支付通道状态码表 服务层实现。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Service
public class PayCodeServiceImpl extends ServiceImpl<PayCodeMapper, PayCodeEntity> implements IPayCodeService {

}