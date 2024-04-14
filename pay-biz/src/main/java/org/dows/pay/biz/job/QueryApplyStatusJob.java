package org.dows.pay.biz.job;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alipay.api.response.AlipayOpenAgentOrderQueryResponse;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsStatusResult;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.alipay.AlipayAgentHandler;
import org.dows.pay.api.PayApi;
import org.dows.pay.api.enums.AliPayStatusEnum;
import org.dows.pay.api.request.PayApplyStatusReq;
import org.dows.pay.api.request.PayQueryIsvRequest;
import org.dows.pay.entity.PayApply;
import org.dows.pay.service.PayApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class QueryApplyStatusJob {

    @Autowired
    private PayApplyService payApplyService;

    @Autowired
    private AlipayAgentHandler alipayAgentHandler;

    @Autowired
    private PayApi payApi;

    private static final Integer PAGE_SIZE = 10;

    /**
     * 表达式暂时写死
     */
    @Scheduled(cron = "0 0 */1 * * ?")
    public void queryApplyStatus() {
        log.info("queryApplyStatus start.........");
        Long id = 0L;
        boolean flag = true;
        while (flag) {
            List<PayApply> payApplyList = listPayApply(id, PAGE_SIZE);
            if (CollUtil.isNotEmpty(payApplyList)) {
                payApplyList.forEach(this::doQueryStatus);
                id = payApplyList.stream().max(Comparator.comparing(PayApply::getId)).get().getId();
            } else {
                flag = false;
                log.info("queryApplyStatus end.........");
            }
        }

    }

    private void doQueryStatus(PayApply p) {
        if(p.getApplyType().equals(2)){
            if (!p.getChecked()) {
                PayQueryIsvRequest payQueryIsvRequest = new PayQueryIsvRequest();
                payQueryIsvRequest.setBatch_no(p.getApplyNo());
                AlipayOpenAgentOrderQueryResponse response=new AlipayOpenAgentOrderQueryResponse();
                try {
                    response = alipayAgentHandler.queryAgent(payQueryIsvRequest);
                    log.info("####查询支付宝申请状态:{}", JSON.toJSONString(response));
                } catch (Exception e) {
                    log.warn("doQueryStatus fail：", e);
                }
                if (StrUtil.isNotBlank(response.getRejectReason())) {
                    p.setApplymentStateDesc(response.getRejectReason());
                } else {
                    p.setApplymentStateDesc(AliPayStatusEnum.getDesc(response.getOrderStatus()));
                }
                if (StrUtil.isNotBlank(response.getSubCode())) {
                    p.setApplymentState(response.getSubCode());
                    p.setApplymentStateDesc(response.getSubMsg());
                }
                if(StrUtil.isNotBlank(response.getMerchantPid())){
                    p.setSubMchid(response.getMerchantPid());
                }
                if(StrUtil.isNotBlank(response.getAgentAppId())){
                    p.setAppId(response.getAgentAppId());
                }
                p.setApplymentState(response.getOrderStatus());
                p.setUpdateTime(new Date());
                p.setAppUrl(response.getConfirmUrl());

                if(Objects.equals("MERCHANT_CONFIRM_SUCCESS",response.getOrderStatus())){
                    p.setChecked(true);
                }
                payApplyService.updateById(p);
            }
        }else {
            PayApplyStatusReq payApplyStatusReq = new PayApplyStatusReq();
            payApplyStatusReq.setMerchantNo(p.getMerchantNo());
            payApplyStatusReq.setStoreId(p.getStoreId());
            try {
                payApi.queryPayApplyStatus(payApplyStatusReq);
            } catch (Exception e) {
                log.warn("doQueryStatus fail：", e);
            }
        }




    }

    private List<PayApply> listPayApply(Long id, Integer pageSize) {
        LambdaQueryWrapper<PayApply> queryWrapper = new LambdaQueryWrapper<PayApply>()
                .gt(id > 0, PayApply::getId, id)
                .eq(PayApply::getChecked, false)
                .orderByDesc(PayApply::getId)
                .last(" limit " + pageSize);
        return payApplyService.list(queryWrapper);
    }
}
