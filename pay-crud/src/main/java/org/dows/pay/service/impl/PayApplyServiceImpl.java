package org.dows.pay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.dows.framework.api.exceptions.BizException;
import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayApplyMapper;
import org.dows.pay.entity.PayApply;
import org.dows.pay.service.PayApplyService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


/**
 * 支付接入申请(PayApply)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:42
 */
@Service("payApplyService")
public class PayApplyServiceImpl extends MybatisCrudServiceImpl<PayApplyMapper, PayApply> implements PayApplyService {
    @Override
    public PayApply getByMerchantNoAndType(String merchantNo, Integer applyType) {
        LambdaQueryWrapper<PayApply> queryWrapper = new LambdaQueryWrapper<PayApply>()
                .eq(PayApply::getMerchantNo, merchantNo)
                .eq(PayApply::getApplyType, applyType)
                .eq(PayApply::getDeleted, 0)
                .orderByDesc(PayApply::getId)
                .last(" limit 1");
        return getOne(queryWrapper);
    }

    @Override
    public void updateApplyNoById(Long payApplyId, String applyId) {
        // 正常下肯定会有值
        PayApply payApply = getById(payApplyId);
        Optional.ofNullable(payApply).map(p -> {
            p.setApplyNo(applyId);
            p.setUpdateTime(new Date());
            updateById(p);
            return p;
        }).orElseThrow(() -> new BizException(String.format("back fill applyPaymentId fail because payApply is null and payApplyId :[%s]", payApplyId)));

    }

    @Override
    public Long createPayApply(String merchantNo, String appId, String applyId) {
        PayApply payApply = getOne(new LambdaQueryWrapper<PayApply>()
                .eq(PayApply::getMerchantNo, merchantNo)
                .eq(PayApply::getApplyType,1)
                .eq(PayApply::getAppId, appId)
                .eq(PayApply::getDeleted, 0)
                .last(" limit 1"));
       return Optional.ofNullable(payApply).map(PayApply::getId).orElseGet(()->getPayApplyId(merchantNo,appId,applyId));

    }

    private Long getPayApplyId(String merchantNo,String appId,String applyId) {
        PayApply  payApply = new PayApply();
        payApply.setMerchantNo(merchantNo);
        payApply.setChecked(false);
        payApply.setApplyNo(applyId);
        payApply.setApplyType(1);
        payApply.setAppId(appId);
        payApply.setBizName("申请微信支付能力");
        payApply.setDeleted(false);
        payApply.setDt(new Date());
        save(payApply);
        return payApply.getId();
    }
}

