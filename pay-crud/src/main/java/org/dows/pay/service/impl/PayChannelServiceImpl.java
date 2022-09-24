package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayChannelMapper;
import org.dows.pay.entity.PayChannel;
import org.dows.pay.service.PayChannelService;
import org.springframework.stereotype.Service;


/**
 * 支付通道(PayChannel)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:06
 */
@Service("payChannelService")
public class PayChannelServiceImpl extends MybatisCrudServiceImpl<PayChannelMapper, PayChannel> implements PayChannelService {

}

