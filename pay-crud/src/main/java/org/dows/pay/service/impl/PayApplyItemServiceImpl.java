package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayApplyItemMapper;
import org.dows.pay.entity.PayApplyItem;
import org.dows.pay.service.PayApplyItemService;
import org.springframework.stereotype.Service;


/**
 * 支付接入申请明细(PayApplyItem)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:42
 */
@Service("payApplyItemService")
public class PayApplyItemServiceImpl extends MybatisCrudServiceImpl<PayApplyItemMapper, PayApplyItem> implements PayApplyItemService {

}

