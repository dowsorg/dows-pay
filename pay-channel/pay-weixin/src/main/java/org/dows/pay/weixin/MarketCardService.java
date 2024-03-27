package org.dows.pay.weixin;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.github.binarywang.wxpay.bean.ecommerce.TransactionsResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.auth.biz.context.SecurityUtils;
import org.dows.framework.api.exceptions.BaseException;
import org.dows.marketing.entity.MarketChargeCardRecord;
import org.dows.marketing.entity.MarketChargeCardRule;
import org.dows.marketing.service.card.IMarketChargeCardRecordService;
import org.dows.marketing.service.card.IMarketChargeCardRuleService;
import org.dows.order.enums.OrderPayTypeEnum;
import org.dows.pay.form.PayTransactionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Slf4j
@Service
public class MarketCardService {

    @Autowired
    private WeixinPayHandler weixinPayHandler;

    @Autowired
    private IMarketChargeCardRuleService ruleService;

    @Autowired
    private IMarketChargeCardRecordService recordService;

    public TransactionsResult.JsapiResult charge(PayTransactionForm payTransactionForm, Long ruleId, Long accountId, MarketChargeCardRecord marketChargeCardRecord) {

        MarketChargeCardRule cardRule = ruleService.selectMarketChargeCardRuleByRuleId(ruleId);

        if (cardRule == null) {
            throw new BaseException("储值卡套餐不存在！");
        }
        String uuid = IdUtil.fastSimpleUUID();

        marketChargeCardRecord.setRecordId(IdWorker.getId());
        marketChargeCardRecord.setTransactionNo(uuid);

        payTransactionForm.setAmount(cardRule.getAmount());
        payTransactionForm.setOrderId(String.valueOf(marketChargeCardRecord.getRecordId()));
        payTransactionForm.setTransactionNo( uuid);
        payTransactionForm.setMerchantNo(SecurityUtils.getMerchantNo());
        payTransactionForm.setTransactionType(2);
        payTransactionForm.setDt(new Date());
        payTransactionForm.setStatus(OrderPayTypeEnum.pay.getCode());
        payTransactionForm.setTransactionTime(new Date());

        TransactionsResult.JsapiResult payStorageCard = weixinPayHandler.toPayStorageCard(payTransactionForm);

        recordService.charge(cardRule, accountId, marketChargeCardRecord);
        return payStorageCard;
    }

    /**
     * 回调方法
     *
     * @param transactionNo
     * @return
     */
    public int callBack(String transactionNo) {
        return recordService.callBack(transactionNo);
    }

}
