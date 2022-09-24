package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayCodeMapper;
import org.dows.pay.entity.PayCode;
import org.dows.pay.service.PayCodeService;
import org.springframework.stereotype.Service;


/**
 * 支付通道状态码(PayCode)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:07
 */
@Service("payCodeService")
public class PayCodeServiceImpl extends MybatisCrudServiceImpl<PayCodeMapper, PayCode> implements PayCodeService {

}

