package org.dows.pay.service;

import org.dows.pay.entity.PayApply;
import org.dows.framework.crud.mybatis.MybatisCrudService;


/**
 * 支付接入申请(PayApply)表服务接口
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:42
 */
public interface PayApplyService extends MybatisCrudService<PayApply> {

    Long createPayApply(String merchantNo, String appId);

    void updateApplyNoById(Long payApplyId, String applyId);

    PayApply getByMerchantNoAndType(String merchantNo, Integer applyType);
}

