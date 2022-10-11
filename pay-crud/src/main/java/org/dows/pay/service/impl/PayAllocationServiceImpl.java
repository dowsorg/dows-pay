package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayAllocationMapper;
import org.dows.pay.entity.PayAllocation;
import org.dows.pay.service.PayAllocationService;
import org.springframework.stereotype.Service;


/**
 * 支付-分账记录(PayAllocation)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-10-11 18:37:36
 */
@Service("payAllocationService")
public class PayAllocationServiceImpl extends MybatisCrudServiceImpl<PayAllocationMapper, PayAllocation> implements PayAllocationService {

}

