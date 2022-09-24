package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayMerchant;

/**
 * 支付商户(PayMerchant)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:08
 */
@Mapper
public interface PayMerchantMapper extends MybatisCrudMapper<PayMerchant> {

}

