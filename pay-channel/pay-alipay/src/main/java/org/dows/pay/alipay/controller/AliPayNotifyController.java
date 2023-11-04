package org.dows.pay.alipay.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.order.api.OrderInstanceBizApiService;
import org.dows.order.bo.OrderUpdatePaymentStatusBo;
import org.dows.pay.alipay.AlipayAuthHandler;
import org.dows.pay.alipay.AlipayPayHandler;
import org.dows.pay.api.request.AliRelationBindReq;
import org.dows.pay.api.response.PayQueryRes;
import org.dows.pay.api.util.HttpRequestUtils;
import org.dows.pay.entity.PayTransaction;
import org.dows.pay.service.PayTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/aliPay")
@RequiredArgsConstructor
@Slf4j
public class AliPayNotifyController {

    private final PayTransactionService payTransactionService;


    private final AlipayPayHandler alipayPayHandler;

    private final OrderInstanceBizApiService orderInstanceBizApiService;

    private final AlipayAuthHandler alipayAuthHandler;


    /**
     * 支付回调
     *
     *          交易状态：WAIT_BUYER_PAY（交易创建，等待买家付款）、
     *          TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）、
     *          TRADE_SUCCESS（交易支付成功）、
     *          TRADE_FINISHED（交易结束，不可退款）
     *
     * @param request
     * @return
     */
    @PostMapping( "/notify")
    public ResponseEntity<Object> notify(HttpServletRequest request) {

        log.info("收到支付宝异步回调：{}", JSON.toJSONString(request.getParameterMap().toString()));
        // 获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();

        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        log.info("notify params=={}",JSON.toJSONString(params));
//        boolean signVerified= AlipaySignature.rsaCertCheckV1(params, "", "UTF-8","RSA2");

        String tradeStatus = getRequestParameter(request, "trade_status");
        // 商户订单号
        String outTradeNo = getRequestParameter(request, "out_trade_no");
        //支付宝交易号
        String tradeNo = getRequestParameter(request, "trade_no");
        //付款金额
        String totalAmount = getRequestParameter(request, "total_amount");
        //退款金额
        String refundFee = getRequestParameter(request, "refund_fee");
        log.info("tradeStatus=={} outTradeNo=={} tradeNo=={} totalAmount={}",tradeStatus,outTradeNo,tradeNo,totalAmount);

        String notifyData = HttpRequestUtils.getRequestParam(request).toString();
        log.info("notifyData=={}",notifyData);

        PayTransaction payTransaction = payTransactionService.getByTransactionNo(outTradeNo);
        PayTransaction updatePay = new PayTransaction();
        updatePay.setId(payTransaction.getId());
        updatePay.setTradeState(tradeStatus);
        updatePay.setDealTo(tradeNo);
        OrderUpdatePaymentStatusBo instanceBo = new OrderUpdatePaymentStatusBo();
        if (Objects.equals(tradeStatus,"TRADE_SUCCESS")) {
            updatePay.setStatus(1);
            instanceBo.setTradeStatus(3);
        } else {
            instanceBo.setTradeStatus(2);
        }
        updatePay.setAmount(new BigDecimal(totalAmount));
        payTransactionService.updateById(updatePay);

        instanceBo.setPayChannel(2);
        instanceBo.setTradeType(1);
        instanceBo.setOrderId(payTransaction.getOrderId());
        log.info("aliPay notify order req is {}",JSON.toJSONString(instanceBo));
        orderInstanceBizApiService.updateOrderInstance(instanceBo);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }


    @RequestMapping("/authCallback")
    @ApiOperation(value = "阿里支付授权回调")
    public Response authCallback(HttpServletRequest request) {
        getAllRequest(request);
        String appId = request.getParameter("appId");
        String appAuthCode = request.getParameter("app_auth_code");
        try{
            alipayAuthHandler.onAuthorization(appId,appAuthCode);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.ok();
    }

    private void getAllRequest(HttpServletRequest request){
        log.info("收到支付宝授权回调：{}", JSON.toJSONString(request.getParameterMap().toString()));
        // 获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();

        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        log.info("收到支付宝授权回调 params=={}",JSON.toJSONString(params));

    }



    @PostMapping(value = "/relation/bind")
    public Boolean bindRelation(@RequestBody AliRelationBindReq req) {
        return alipayPayHandler.bindRelation(req.getAccount(), req.getType(),req.getAppId(),req.getMerchantNo(),null);
    }

    @PostMapping(value = "/readyClaimProfit")
    public void readyClaimProfit(String orderId) {
        PayTransaction payTransaction = payTransactionService.getByOrderId(orderId);
        alipayPayHandler.readyClaimProfit("202308BB8687463402634e0ea08305cece0d2X97",payTransaction);
    }



    private String getRequestParameter(HttpServletRequest request, String name) {
        String value = request.getParameter(name);
        if (value != null) {
            return new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        }
        return "";
    }
}
