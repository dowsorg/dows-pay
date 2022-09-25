package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayBinded;

/**
 * 支付卡号绑定（后期放在钱包模块）(PayBinded)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:42
 */
@Mapper
public interface PayBindedMapper extends MybatisCrudMapper<PayBinded> {

}

