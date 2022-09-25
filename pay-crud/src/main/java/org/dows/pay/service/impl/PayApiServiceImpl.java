package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayApiMapper;
import org.dows.pay.entity.PayApi;
import org.dows.pay.service.PayApiService;
import org.springframework.stereotype.Service;


/**
 * 支付通道接口(PayApi)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:42
 */
@Service("payApiService")
public class PayApiServiceImpl extends MybatisCrudServiceImpl<PayApiMapper, PayApi> implements PayApiService {

}

