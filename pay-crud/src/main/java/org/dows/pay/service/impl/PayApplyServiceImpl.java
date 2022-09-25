package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayApplyMapper;
import org.dows.pay.entity.PayApply;
import org.dows.pay.service.PayApplyService;
import org.springframework.stereotype.Service;


/**
 * 支付接入申请(PayApply)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:42
 */
@Service("payApplyService")
public class PayApplyServiceImpl extends MybatisCrudServiceImpl<PayApplyMapper, PayApply> implements PayApplyService {

}

