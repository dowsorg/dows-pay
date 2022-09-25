package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayInstanceMapper;
import org.dows.pay.entity.PayInstance;
import org.dows.pay.service.PayInstanceService;
import org.springframework.stereotype.Service;


/**
 * 支付通道实例(PayInstance)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:43
 */
@Service("payInstanceService")
public class PayInstanceServiceImpl extends MybatisCrudServiceImpl<PayInstanceMapper, PayInstance> implements PayInstanceService {

}

