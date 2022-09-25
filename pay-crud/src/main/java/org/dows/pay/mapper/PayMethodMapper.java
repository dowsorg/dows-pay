package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayMethod;

/**
 * 支付方法(PayMethod)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:44
 */
@Mapper
public interface PayMethodMapper extends MybatisCrudMapper<PayMethod> {

}

