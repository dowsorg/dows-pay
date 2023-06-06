package org.dows.pay.rest.tenant.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayResponse;
import org.dows.pay.biz.IsvBiz;
import org.dows.pay.biz.OrderPayBiz;
import org.dows.pay.form.*;
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

    @PostMapping("/orderpay/topay")
    @ApiOperation(value = "去支付")
    public Response<PayResponse> toPay(@RequestBody PayTransactionForm payTransactionForm) {
        return orderPayBiz.toPay(payTransactionForm);
    }

    @PostMapping("/orderpay/topayNoAcc")
    @ApiOperation(value = "去支付无分账")
    public Response<PayResponse> topayNoAcc(@RequestBody PayTransactionForm payTransactionForm) {
        return orderPayBiz.toPayNoAcc(payTransactionForm);
    }

    @PostMapping("/orderpay/toCombinePay")
    @ApiOperation(value = "去合并支付")
    public Response<PayResponse> toCombinePay(@RequestBody PayCombineTransactionForm payCombineTransactionForm) {
        orderPayBiz.toCombinePay(payCombineTransactionForm);
        return Response.ok();
    }

    @PostMapping("/orderpay/queryOrder")
    @ApiOperation(value = "订单查询")
    public Response<PayResponse> queryOrder(@RequestBody PayPartnerTransactionsQueryForm payPartnerTransactionsQueryForm) {
        orderPayBiz.queryOrder(payPartnerTransactionsQueryForm);
        return Response.ok();
    }


    @PostMapping("/orderpay/queryCombineOrder")
    @ApiOperation(value = "合并订单查询")
    public Response<PayResponse> queryCombineOrder(@RequestBody PayCombineTransactionForm payCombineTransactionForm) {
        orderPayBiz.queryCombineOrder(payCombineTransactionForm);
        return Response.ok();
    }
    @PostMapping("/orderpay/closeOrder")
    @ApiOperation(value = "关闭单笔订单")
    public Response<PayResponse> closeOrder(@RequestBody PayPartnerTransactionsQueryForm payPartnerTransactionsQueryForm) {
        orderPayBiz.closeOrder(payPartnerTransactionsQueryForm);
        return Response.ok();
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
