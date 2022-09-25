package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayDetails;

/**
 * 支付交易明细(PayDetails)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:43
 */
@Mapper
public interface PayDetailsMapper extends MybatisCrudMapper<PayDetails> {

}

