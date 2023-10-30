package org.dows.pay.rest.user.v1;

import com.github.binarywang.wxpay.bean.ecommerce.TransactionsResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.biz.OrderPayBiz;
import org.dows.pay.form.PayTransactionForm;
import org.dows.pay.weixin.WeixinPayHandler;
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


    @PostMapping("/orderpay/topayNoAcc")
    @ApiOperation(value = "去支付无分账")
    public Response topayNoAcc(@RequestBody PayTransactionForm payTransactionForm) {
        TransactionsResult.JsapiResult result= weixinPayHandler.toPayNoAcc(payTransactionForm);
        return Response.ok(result);
    }

}
