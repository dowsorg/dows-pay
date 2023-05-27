package org.dows.pay.biz.job;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.dows.app.api.mini.request.PayApplyStatusReq;
import org.dows.pay.api.PayApi;
import org.dows.pay.entity.PayApply;
import org.dows.pay.service.PayApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
@Slf4j
public class QueryApplyStatusJob {

    @Autowired
    private PayApplyService payApplyService;

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
        PayApplyStatusReq payApplyStatusReq = new PayApplyStatusReq();
        payApplyStatusReq.setMerchantNo(p.getMerchantNo());
        try {
            payApi.queryPayApplyStatus(payApplyStatusReq);
        } catch (Exception e) {
            log.warn("doQueryStatus fail：", e);
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
