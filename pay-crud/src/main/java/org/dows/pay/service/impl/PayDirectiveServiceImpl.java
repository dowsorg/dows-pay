package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayDirectiveMapper;
import org.dows.pay.entity.PayDirective;
import org.dows.pay.service.PayDirectiveService;
import org.springframework.stereotype.Service;


/**
 * 支付指令集(PayDirective)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:07
 */
@Service("payDirectiveService")
public class PayDirectiveServiceImpl extends MybatisCrudServiceImpl<PayDirectiveMapper, PayDirective> implements PayDirectiveService {

}

