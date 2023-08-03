package org.dows.pay.rest.tenant.v1;

import com.github.binarywang.wxpay.bean.ecommerce.PartnerTransactionsResult;
import com.github.binarywang.wxpay.bean.ecommerce.TransactionsResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.request.AccountsRequest;
import org.dows.pay.biz.IsvBiz;
import org.dows.pay.biz.OrderPayBiz;
import org.dows.pay.form.*;
import org.dows.pay.weixin.WeixinPayHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.dows.pay.api.PayRequest;
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
    @PostMapping("/orderpay/topay")
    @ApiOperation(value = "去支付")
    public Response<PayResponse> toPay(@RequestBody PayTransactionForm payTransactionForm) {
        return orderPayBiz.toPay(payTransactionForm);
    }

    @PostMapping("/orderpay/toAccounts")
    @ApiOperation(value = "去分账")
    public Response<String> toAccounts(@RequestBody AccountsRequest accountsRequest) {
        String result = weixinPayHandler.toAccounts(accountsRequest);
        return Response.ok(result);
    }
    @PostMapping("/orderpay/topayNoAcc")
    @ApiOperation(value = "去支付无分账")
    public Response topayNoAcc(@RequestBody PayTransactionForm payTransactionForm) {
        TransactionsResult.JsapiResult result= weixinPayHandler.toPayNoAcc(payTransactionForm);
        return Response.ok(result);
    }

    @PostMapping("/orderpay/toCombinePay")
    @ApiOperation(value = "去合并支付")
    public Response<PayResponse> toCombinePay(@RequestBody PayCombineTransactionForm payCombineTransactionForm) {
        orderPayBiz.toCombinePay(payCombineTransactionForm);
        return Response.ok();
    }

    @PostMapping("/orderpay/queryOrder")
    @ApiOperation(value = "订单查询")
    public Response<PartnerTransactionsResult> queryOrder(@RequestBody PayPartnerTransactionsQueryForm payPartnerTransactionsQueryForm) {
        PartnerTransactionsResult result = weixinPayHandler.queryOrder(payPartnerTransactionsQueryForm);
        return Response.ok(result);
    }


    @PostMapping("/orderpay/queryCombineOrder")
    @ApiOperation(value = "合并订单查询")
    public Response<PayResponse> queryCombineOrder(@RequestBody PayCombineTransactionForm payCombineTransactionForm) {
        orderPayBiz.queryCombineOrder(payCombineTransactionForm);
        return Response.ok();
    }
    @PostMapping("/orderpay/closeOrder")
    @ApiOperation(value = "关闭单笔订单")
    public Response<String> closeOrder(@RequestBody PayPartnerTransactionsQueryForm payPartnerTransactionsQueryForm) {
        String result = weixinPayHandler.closeOrder(payPartnerTransactionsQueryForm);
        return Response.ok(result);
    }


    @PostMapping("/orderpay/closeCombineOrder")
    @ApiOperation(value = "关闭合并订单")
    public Response<PayResponse> closeCombineOrder(@RequestBody PayCombineTransactionForm payCombineTransactionForm) {
        orderPayBiz.closeCombineOrder(payCombineTransactionForm);
        return Response.ok();
    }
    @PostMapping("/orderpay/refunds")
    @ApiOperation(value = "申请退款")
    public Response<PayResponse> refunds(@RequestBody PayRefundsTransactionForm payRefundsTransactionForm) {
        orderPayBiz.refunds(payRefundsTransactionForm);
        return Response.ok();
    }


    @PostMapping("/orderpay/queryRefundByRefundId")
    @ApiOperation(value = "查询退款情况")
    public Response<PayResponse> queryRefundByRefundId(@RequestBody PayRefundsTransactionForm payRefundsTransactionForm) {
        orderPayBiz.queryRefundByRefundId(payRefundsTransactionForm);
        return Response.ok();
    }
    @PostMapping("/orderpay/subWithdraw")
    @ApiOperation(value = "二级商户提现申请")
    public Response<PayResponse> subWithdraw(@RequestBody PaySubWithDrawTransactionForm paySubWithDrawTransactionForm) {
        orderPayBiz.subWithdraw(paySubWithDrawTransactionForm);
        return Response.ok();
    }


    @PostMapping("/orderpay/querySubWithdrawByOutRequestNo")
    @ApiOperation(value = "二级商户提现申请查询")
    public Response<PayResponse> querySubWithdrawByOutRequestNo(@RequestBody PaySubWithDrawTransactionForm paySubWithDrawTransactionForm) {
        orderPayBiz.querySubWithdrawByOutRequestNo(paySubWithDrawTransactionForm);
        return Response.ok();
    }
    @PostMapping("/orderpay/spWithdraw")
    @ApiOperation(value = "平台提现申请")
    public Response<PayResponse> spWithdraw(@RequestBody PaySpWithDrawTransactionForm paySpWithDrawTransactionForm) {
        orderPayBiz.spWithdraw(paySpWithDrawTransactionForm);
        return Response.ok();
    }


    @PostMapping("/orderpay/querySpWithdrawByOutRequestNo")
    @ApiOperation(value = "平台提现申请查询")
    public Response<PayResponse> querySpWithdrawByOutRequestNo(@RequestBody PaySpWithDrawTransactionForm paySpWithDrawTransactionForm) {
        orderPayBiz.querySpWithdrawByOutRequestNo(paySpWithDrawTransactionForm);
        return Response.ok();
    }
}
