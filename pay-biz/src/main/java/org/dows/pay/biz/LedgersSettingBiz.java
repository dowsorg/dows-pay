package org.dows.pay.biz;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.PayLedgersRequest;
import org.dows.pay.bo.RelationBingBo;
import org.dows.pay.entity.PayLedgers;
import org.dows.pay.form.PayLedgersForm;
import org.dows.pay.gateway.PayDispatcher;
import org.dows.pay.service.PayLedgersService;
import org.springframework.stereotype.Service;

/**
 * 账本设置
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class LedgersSettingBiz {

    private final PayLedgersService payLedgersService;

    private final PayDispatcher payDispatcher;

    /**
     * 分账关系设置
     * 根据当前商户ID+支付通道ID 查询分账配置，并调用支付通道对应的分账接口，设置第三方分账
     */
    public void allotSetting(PayLedgersForm payLedgersForm) {
        // 根据 params 查询分账配置实体
        PayLedgers entity = payLedgersService.lambdaQuery()
                .eq(PayLedgers::getAppId, payLedgersForm.getAppId())
                .eq(PayLedgers::getInstanceNo, payLedgersForm.getInstanceNo())
                .eq(PayLedgers::getMerchantNo, payLedgersForm.getMerchantNo())
                .eq(PayLedgers::getAccountId, payLedgersForm.getAccountId())
                .getEntity();
        // 填充分账请求对象
        PayLedgersRequest payRequest = new PayLedgersRequest();
        //"dows.trade.royalty.relation.bind"
        RelationBingBo relationBingBo = BeanUtil.copyProperties(entity, RelationBingBo.class);
        // 设置方法
        payRequest.setMethod(PayMethods.TRADE_ROYALTY_RELATION_BIND.getNamespace());
        // 设置bizModel
        payRequest.setBizModel(relationBingBo);
        // 填充公共参数
        payRequest.autoSet(payLedgersForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
    }


}
