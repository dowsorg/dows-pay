package org.dows.pay.weixin;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayRequest;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.msg.AlipayMsgClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.service.schema.util.StringUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.github.binarywang.wxpay.bean.ecommerce.FinishOrderRequest;
import com.github.binarywang.wxpay.bean.ecommerce.PartnerTransactionsRequest;
import com.github.binarywang.wxpay.bean.ecommerce.TransactionsResult;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayException;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.event.OrderPaySuccessEvent;
import org.dows.pay.api.message.AlipayMessage;
import org.dows.pay.api.message.WeixinMessage;
import org.dows.pay.bo.PayTransactionBo;
import org.dows.pay.boot.PayClientFactory;
import org.dows.pay.boot.properties.PayClientProperties;
import org.dows.pay.entity.PayTransaction;
import org.dows.pay.service.PayTransactionService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.io.IOException;
import java.util.*;

/**
 * 支付相关业务功能,如：，
 * 当面付：https://open.alipay.com/api/detail?code=I1080300001000041016
 * app付款：https://open.alipay.com/api/detail?code=I1080300001000041313
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class WeixinPayHandler extends AbstractWeixinHandler {
    private final PayClientFactory payClientFactory;

    private final PayTransactionService payTransactionService;

    private final IdGenerator idGenerator = new SimpleIdGenerator();

    private static final Gson GSON = new GsonBuilder().create();

    /**
     * 去支付
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ORDER_PAY)
    public void toPay(PayRequest payRequest) {
        //先创建交易订单
        UUID uuid = idGenerator.generateId();
        PayTransactionBo payTransactionBo = (PayTransactionBo)payRequest.getBizModel();
        PayTransaction payTransaction = BeanUtil.copyProperties(payTransactionBo, PayTransaction.class);
        payTransaction.setPayChannel(payRequest.getChannel());
        payTransaction.setTransactionNo(uuid.toString());
        payTransaction.setAppId(payRequest.getAppId());
        payTransactionService.save(payTransaction);
        PartnerTransactionsRequest partnerTransactionsRequest =  GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), PartnerTransactionsRequest.class);

        TransactionsResult transactionsResult = new TransactionsResult();
        try {
            String url = this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl();//
            String response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(partnerTransactionsRequest));
            GSON.fromJson(response, TransactionsResult.class);
        } catch ( WxPayException e) {
            throw new RuntimeException(e);
        }
        if (!StringUtil.isEmpty(transactionsResult.getPrepayId())){
            System.out.println("调用成功");
            // todo 记录 pay_transaction表，可能有多次（失败），但只有一次是成功的
            //下单成功
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(1) //下单成功
                    .build();
            payTransactionService.updateById(updatePayTransaction);
        } else {
            //todo 失败逻辑
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(2) //下单失败
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            throw new RuntimeException("调用失败");
        }
    }





}
