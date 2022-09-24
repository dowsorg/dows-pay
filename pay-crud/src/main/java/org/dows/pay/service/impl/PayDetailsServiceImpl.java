package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayDetailsMapper;
import org.dows.pay.entity.PayDetails;
import org.dows.pay.service.PayDetailsService;
import org.springframework.stereotype.Service;


/**
 * 支付交易明细(PayDetails)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:07
 */
@Service("payDetailsService")
public class PayDetailsServiceImpl extends MybatisCrudServiceImpl<PayDetailsMapper, PayDetails> implements PayDetailsService {

}

