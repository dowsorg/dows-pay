package org.dows.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeRoyaltyRelationBatchqueryModel;
import com.alipay.api.domain.AlipayTradeRoyaltyRelationBindModel;
import com.alipay.api.domain.AlipayTradeRoyaltyRelationUnbindModel;
import com.alipay.api.request.AlipayTradeRoyaltyRelationBatchqueryRequest;
import com.alipay.api.request.AlipayTradeRoyaltyRelationBindRequest;
import com.alipay.api.request.AlipayTradeRoyaltyRelationUnbindRequest;
import com.alipay.api.response.AlipayTradeRoyaltyRelationBatchqueryResponse;
import com.alipay.api.response.AlipayTradeRoyaltyRelationBindResponse;
import com.alipay.api.response.AlipayTradeRoyaltyRelationUnbindResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.springframework.stereotype.Service;

/**
 * 分账关系维护
 * <p>
 * TRADE_ROYALTY_RELATION_BIND("dows.trade.royalty.relation.bind", "", "分账关系绑定"),
 * TRADE_ROYALTY_RELATION_UNBIND("dows.trade.royalty.relation.unbind", "", "分账关系解绑"),
 * TRADE_ROYALTY_RELATION_QUERY("dows.trade.royalty.relation.query", "", "分账关系查询"),
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AlipayRoyaltyRelationHandler extends AbstractAlipayHandler {


    /**
     * 分账关系绑定
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_BIND)
    public void tradeRoyaltyRelationBind(PayRequest payRequest) {

        AlipayTradeRoyaltyRelationBindModel alipayTradeRoyaltyRelationBindModel = new AlipayTradeRoyaltyRelationBindModel();
        // 自动
        autoMappingValue(payRequest, alipayTradeRoyaltyRelationBindModel);
        AlipayTradeRoyaltyRelationBindRequest request = new AlipayTradeRoyaltyRelationBindRequest();
        request.setBizModel(alipayTradeRoyaltyRelationBindModel);
        AlipayTradeRoyaltyRelationBindResponse response = null;
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
     * 分账关系解绑
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_UNBIND)
    public void tradeRoyaltyRelationUnbind(PayRequest payRequest) {
        AlipayTradeRoyaltyRelationUnbindModel alipayTradeRoyaltyRelationUnbindModel =
                new AlipayTradeRoyaltyRelationUnbindModel();
        // 自动
        autoMappingValue(payRequest, alipayTradeRoyaltyRelationUnbindModel);

        AlipayTradeRoyaltyRelationUnbindRequest request = new AlipayTradeRoyaltyRelationUnbindRequest();
        request.setBizModel(alipayTradeRoyaltyRelationUnbindModel);
        AlipayTradeRoyaltyRelationUnbindResponse response = null;
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
     * 分账关系查询
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_QUERY)
    public void tradeRoyaltyRelationQuery(PayRequest payRequest) {
        AlipayTradeRoyaltyRelationBatchqueryModel alipayTradeRoyaltyRelationBatchqueryModel =
                new AlipayTradeRoyaltyRelationBatchqueryModel();
        // 自动
        autoMappingValue(payRequest, alipayTradeRoyaltyRelationBatchqueryModel);

        AlipayTradeRoyaltyRelationBatchqueryRequest request = new AlipayTradeRoyaltyRelationBatchqueryRequest();
        request.setBizModel(alipayTradeRoyaltyRelationBatchqueryModel);
        AlipayTradeRoyaltyRelationBatchqueryResponse response = null;
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

}
