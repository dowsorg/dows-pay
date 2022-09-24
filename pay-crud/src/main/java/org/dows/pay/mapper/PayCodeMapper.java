package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayCode;

/**
 * 支付通道状态码(PayCode)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:07
 */
@Mapper
public interface PayCodeMapper extends MybatisCrudMapper<PayCode> {

}

