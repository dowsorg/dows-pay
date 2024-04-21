package org.dows.pay.rest.user.v1;

import cn.hutool.core.bean.BeanUtil;
import com.github.binarywang.wxpay.bean.ecommerce.TransactionsResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.auth.biz.context.SecurityUtils;
import org.dows.framework.api.Response;
import org.dows.marketing.card.req.MarketChargeCardRecordReq;
import org.dows.marketing.entity.MarketChargeCardRecord;
import org.dows.pay.weixin.MarketCardService;
import org.dows.pay.biz.OrderPayBiz;
import org.dows.pay.form.PayTransactionForm;
import org.dows.pay.weixin.WeixinPayHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一收单
 */
@Api(tags = "服务商下单相关接口")
@RestController
@RequestMapping(value = "/v1")
@Slf4j
@RequiredArgsConstructor
public class OrderSettleRest {
    private final OrderPayBiz orderPayBiz;

    private final WeixinPayHandler weixinPayHandler;

    @Autowired
    private MarketCardService marketCardService;

    @PostMapping("/orderpay/topayNoAcc")
    @ApiOperation(value = "去支付分账-重要")
    public Response topayNoAcc(@RequestBody PayTransactionForm payTransactionForm) {
        TransactionsResult.JsapiResult result= weixinPayHandler.toPayNoAcc(payTransactionForm);
        return Response.ok(result);
    }

    /**
     * 新增储值卡记录
     */
    @ApiOperation("储值卡充值")
    @PostMapping("card/charge")
    public Response charge(@RequestBody MarketChargeCardRecordReq cardRecordReq) {

        MarketChargeCardRecord marketChargeCardRecord = new MarketChargeCardRecord();
        BeanUtil.copyProperties(cardRecordReq,marketChargeCardRecord);
        //todo String accountId = "1610967398052057089";
        String accountId = SecurityUtils.getAccountId();
        return Response.ok(marketCardService.charge(cardRecordReq.getPayTransactionForm(),cardRecordReq.getRuleId(),Long.valueOf(accountId),marketChargeCardRecord));
    }

}
