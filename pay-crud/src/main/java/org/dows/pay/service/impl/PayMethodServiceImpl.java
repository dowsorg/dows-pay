package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayMethodMapper;
import org.dows.pay.entity.PayMethod;
import org.dows.pay.service.PayMethodService;
import org.springframework.stereotype.Service;


/**
 * 支付方法(PayMethod)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:08
 */
@Service("payMethodService")
public class PayMethodServiceImpl extends MybatisCrudServiceImpl<PayMethodMapper, PayMethod> implements PayMethodService {

}

