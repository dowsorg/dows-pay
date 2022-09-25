package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayInstance;

/**
 * 支付通道实例(PayInstance)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:43
 */
@Mapper
public interface PayInstanceMapper extends MybatisCrudMapper<PayInstance> {

}

