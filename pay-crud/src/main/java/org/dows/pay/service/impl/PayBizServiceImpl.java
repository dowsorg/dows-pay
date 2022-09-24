package org.dows.pay.service.impl;

import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayBizMapper;
import org.dows.pay.entity.PayBiz;
import org.dows.pay.service.PayBizService;
import org.springframework.stereotype.Service;


/**
 * 支付业务(PayBiz)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:06
 */
@Service("payBizService")
public class PayBizServiceImpl extends MybatisCrudServiceImpl<PayBizMapper, PayBiz> implements PayBizService {

}

