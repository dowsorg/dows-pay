package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayApplyItem;

/**
 * 支付接入申请明细(PayApplyItem)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:05
 */
@Mapper
public interface PayApplyItemMapper extends MybatisCrudMapper<PayApplyItem> {

}

