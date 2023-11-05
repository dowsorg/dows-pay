package org.dows.pay.rest.tenant.v1;


import com.alibaba.fastjson.JSON;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.alipay.AlipayPayHandler;
import org.dows.pay.api.request.ScanPayApplyRes;
import org.dows.pay.form.AliPayRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付宝支付接口(PayApi)表控制层
 *
 * @author zoubo
 * @since 2023-08-05 09:39:51
 */
@Api(tags = "支付宝支付接口")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1")
public class IsvPayRest {

    private final AlipayPayHandler alipayPayHandler;

    @PostMapping("/isvPay/topay")
    @ApiOperation(value = "支付宝去支付")
    public Response toPay(@RequestBody AliPayRequest payTransactionForm) {
        AlipayTradeCreateResponse result= alipayPayHandler.toPay(payTransactionForm);
        return Response.ok(result);
    }

    @PostMapping("/alipay/micropay")
    @ApiOperation(value = "支付宝付款码支付")
    public Response miacropay(@RequestBody AliPayRequest aliPayRequest) {
        log.info("开始支付宝付款码支付:{}", JSON.toJSONString(aliPayRequest));
        AlipayTradePayResponse result= alipayPayHandler.payByAuthCode(aliPayRequest);
        return Response.ok(result);
    }


    @PostMapping("/scanPay")
    @ApiOperation(value = "支付宝去支付")
    public Response scanPay(@RequestBody AliPayRequest payTransactionForm) {
        ScanPayApplyRes result= alipayPayHandler.scanPay(payTransactionForm);
        return Response.ok(result);
    }


}

