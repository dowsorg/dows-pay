package org.dows.pay.service;

import org.dows.pay.entity.PayAccount;
import org.dows.framework.crud.mybatis.MybatisCrudService;


/**
 * 支付通道账号(PayAccount)表服务接口
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:42
 */
public interface PayAccountService extends MybatisCrudService<PayAccount> {

    PayAccount getByMerchantNo(String merchantNo,Integer appType);
}

