package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayWaterMapper;
import org.dows.pay.entity.PayWater;
import org.dows.pay.service.PayWaterService;
import org.springframework.stereotype.Service;


/**
 * 支付流水(PayWater)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:09
 */
@Service("payWaterService")
public class PayWaterServiceImpl extends MybatisCrudServiceImpl<PayWaterMapper, PayWater> implements PayWaterService {

}

