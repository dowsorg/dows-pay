package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayRule;

/**
 * 支付规则(PayRule)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:09
 */
@Mapper
public interface PayRuleMapper extends MybatisCrudMapper<PayRule> {

}

