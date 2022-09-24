package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayBiz;

/**
 * 支付业务(PayBiz)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:06
 */
@Mapper
public interface PayBizMapper extends MybatisCrudMapper<PayBiz> {

}

