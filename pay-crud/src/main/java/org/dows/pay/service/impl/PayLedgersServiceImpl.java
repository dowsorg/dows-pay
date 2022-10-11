package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayLedgersMapper;
import org.dows.pay.entity.PayLedgers;
import org.dows.pay.service.PayLedgersService;
import org.springframework.stereotype.Service;


/**
 * 支付-分账账本(PayLedgers)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-10-11 18:37:36
 */
@Service("payLedgersService")
public class PayLedgersServiceImpl extends MybatisCrudServiceImpl<PayLedgersMapper, PayLedgers> implements PayLedgersService {

}

