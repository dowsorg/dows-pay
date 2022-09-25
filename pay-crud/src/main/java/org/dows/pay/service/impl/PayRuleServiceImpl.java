package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayRuleMapper;
import org.dows.pay.entity.PayRule;
import org.dows.pay.service.PayRuleService;
import org.springframework.stereotype.Service;


/**
 * 支付规则(PayRule)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:44
 */
@Service("payRuleService")
public class PayRuleServiceImpl extends MybatisCrudServiceImpl<PayRuleMapper, PayRule> implements PayRuleService {

}

