package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayChannel;

/**
 * 支付通道(PayChannel)表数据库访问层
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:06
 */
@Mapper
public interface PayChannelMapper extends MybatisCrudMapper<PayChannel> {

}

