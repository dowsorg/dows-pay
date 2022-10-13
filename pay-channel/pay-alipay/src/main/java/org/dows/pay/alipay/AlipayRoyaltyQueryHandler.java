package org.dows.pay.alipay;

import cn.hutool.core.bean.BeanUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayOpenMiniIsvQueryModel;
import com.alipay.api.domain.AlipayTradeOrderSettleModel;
import com.alipay.api.domain.AlipayTradeOrderSettleQueryModel;
import com.alipay.api.domain.AlipayTradeRoyaltyRateQueryModel;
import com.alipay.api.request.AlipayTradeOrderSettleQueryRequest;
import com.alipay.api.request.AlipayTradeRoyaltyRateQueryRequest;
import com.alipay.api.response.AlipayTradeOrderSettleQueryResponse;
import com.alipay.api.response.AlipayTradeRoyaltyRateQueryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.PayLedgersResponse;
import org.springframework.stereotype.Service;

/**
 * 分账查询
 * TRADE_ORDER_SETTLE_QUERY("dows.trade.order.settle.query", "", "交易分账查询接口"),
 * TRADE_ROYALTY_RATE_QUERY("dows.trade.royalty.rate.query", "", "分账比例查询"),
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AlipayRoyaltyQueryHandler extends AbstractAlipayHandler {


    /**
     * 交易分账查询接口
     * https://opendocs.alipay.com/open/02pj6l
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ORDER_SETTLE_QUERY)
    public void tradeRoyaltyRateQuery(PayRequest payRequest) {
        AlipayTradeOrderSettleQueryModel alipayTradeOrderSettleQueryModel =new AlipayTradeOrderSettleQueryModel();
        // 自动映射
        autoMappingValue(payRequest, alipayTradeOrderSettleQueryModel);

        AlipayTradeOrderSettleQueryRequest request = new AlipayTradeOrderSettleQueryRequest();
        request.setBizModel(alipayTradeOrderSettleQueryModel);
        AlipayTradeOrderSettleQueryResponse response = null;
        try {
            response = getAlipayClient(payRequest.getAppId()).execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }

        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            //todo 失败逻辑
            throw new RuntimeException("调用失败");
        }
    }


    /**
     * 分账比例查询
     * https://opendocs.alipay.com/open/04nm3j
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RATE_QUERY)
    public void tradeOrderSettleQuery(PayRequest payRequest) {
        AlipayTradeRoyaltyRateQueryModel alipayTradeOrderSettleQueryModel = new AlipayTradeRoyaltyRateQueryModel();
        // 自动映射
        autoMappingValue(payRequest, alipayTradeOrderSettleQueryModel);
        AlipayTradeRoyaltyRateQueryRequest request = new AlipayTradeRoyaltyRateQueryRequest();
        request.setBizModel(alipayTradeOrderSettleQueryModel);
        AlipayTradeRoyaltyRateQueryResponse response = null;
        try {
            response = getAlipayClient(payRequest.getAppId()).execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }

        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            //todo 失败逻辑
            throw new RuntimeException("调用失败");
        }
       ///return  PayLedgersResponse
    }

}
