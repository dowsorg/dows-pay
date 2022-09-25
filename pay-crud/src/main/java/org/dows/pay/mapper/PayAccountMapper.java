package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayAccount;

/**
 * 支付通道账号(PayAccount)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:42
 */
@Mapper
public interface PayAccountMapper extends MybatisCrudMapper<PayAccount> {

}

