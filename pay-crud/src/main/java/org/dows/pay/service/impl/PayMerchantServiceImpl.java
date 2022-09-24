package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayMerchantMapper;
import org.dows.pay.entity.PayMerchant;
import org.dows.pay.service.PayMerchantService;
import org.springframework.stereotype.Service;


/**
 * 支付商户(PayMerchant)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:08
 */
@Service("payMerchantService")
public class PayMerchantServiceImpl extends MybatisCrudServiceImpl<PayMerchantMapper, PayMerchant> implements PayMerchantService {

}

