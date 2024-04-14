package org.dows.pay.service;

import org.dows.pay.entity.PayApply;
import org.dows.framework.crud.mybatis.MybatisCrudService;

import java.util.List;


/**
 * 支付接入申请(PayApply)表服务接口
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:42
 */
public interface PayApplyService extends MybatisCrudService<PayApply> {

    Long createPayApply(String merchantNo,String storeId, String appId, String applyId);

    void updateApplyNoById(Long payApplyId, String applyId);

    PayApply getByMerchantNoAndType(String merchantNo, Integer applyType);
    PayApply getByMerchantNoAndType(String merchantNo,String storeId, Integer applyType);

    List<PayApply> queryByMerchantNoAndType(String merchantNo, Integer applyType);

    PayApply getByMchIdAndType(String mchId,Integer applyType);

    PayApply getByApplyNo(String batchNo);
}

