package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayAllocation;

/**
 * 支付-分账记录(PayAllocation)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-10-11 18:37:36
 */
@Mapper
public interface PayAllocationMapper extends MybatisCrudMapper<PayAllocation> {

}

