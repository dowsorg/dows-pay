package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayBindedMapper;
import org.dows.pay.entity.PayBinded;
import org.dows.pay.service.PayBindedService;
import org.springframework.stereotype.Service;


/**
 * 支付卡号绑定（后期放在钱包模块）(PayBinded)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:42
 */
@Service("payBindedService")
public class PayBindedServiceImpl extends MybatisCrudServiceImpl<PayBindedMapper, PayBinded> implements PayBindedService {

}

