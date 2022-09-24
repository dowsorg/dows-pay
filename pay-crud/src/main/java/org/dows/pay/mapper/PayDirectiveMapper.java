package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayDirective;

/**
 * 支付指令集(PayDirective)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:07
 */
@Mapper
public interface PayDirectiveMapper extends MybatisCrudMapper<PayDirective> {

}

