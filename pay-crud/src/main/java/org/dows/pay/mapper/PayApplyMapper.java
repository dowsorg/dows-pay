package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayApply;

/**
 * 支付接入申请(PayApply)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:42
 */
@Mapper
public interface PayApplyMapper extends MybatisCrudMapper<PayApply> {

}

