package org.dows.pay.weixin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 微信分账关系维护
 * <p>
 * TRADE_ROYALTY_RELATION_BIND("dows.trade.royalty.relation.bind", "", "分账关系绑定"),
 * TRADE_ROYALTY_RELATION_UNBIND("dows.trade.royalty.relation.unbind", "", "分账关系解绑"),
 * TRADE_ROYALTY_RELATION_QUERY("dows.trade.royalty.relation.query", "", "分账关系查询"),
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class WeixinRoyaltyRelationHandler extends AbstractWeixinHandler {


//    /**
//     * 分账关系绑定
//     *
//     * @param payRequest
//     * @return
//     */
//    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_BIND)
//    public void tradeRoyaltyRelationBind(PayRequest payRequest) {
//        AlipayTradeRoyaltyRelationBindModel alipayTradeRoyaltyRelationBindModel = BeanUtil.toBean(payRequest.getParams(), AlipayTradeRoyaltyRelationBindModel.class);
//        AlipayTradeRoyaltyRelationBindRequest request = new AlipayTradeRoyaltyRelationBindRequest();
//        request.setChannelBizModel(alipayTradeRoyaltyRelationBindModel);
//        AlipayTradeRoyaltyRelationBindResponse response = null;
//        try {
//            response = getAlipayClient(payRequest.getAppId()).execute(request);
//        } catch (AlipayApiException e) {
//            throw new RuntimeException(e);
//        }
//
//        if (response.isSuccess()) {
//            System.out.println("调用成功");
//        } else {
//            //todo 失败逻辑
//            throw new RuntimeException("调用失败");
//        }
//    }
//
//
//    /**
//     * 分账关系解绑
//     *
//     * @param payRequest
//     * @return
//     */
//    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_UNBIND)
//    public void tradeRoyaltyRelationUnbind(PayRequest payRequest) {
//        AlipayTradeRoyaltyRelationUnbindModel alipayTradeRoyaltyRelationUnbindModel =
//                BeanUtil.toBean(payRequest.getParams(), AlipayTradeRoyaltyRelationUnbindModel.class);
//        AlipayTradeRoyaltyRelationUnbindRequest request = new AlipayTradeRoyaltyRelationUnbindRequest();
//        request.setChannelBizModel(alipayTradeRoyaltyRelationUnbindModel);
//        AlipayTradeRoyaltyRelationUnbindResponse response = null;
//        try {
//            response = getAlipayClient(payRequest.getAppId()).execute(request);
//        } catch (AlipayApiException e) {
//            throw new RuntimeException(e);
//        }
//
//        if (response.isSuccess()) {
//            System.out.println("调用成功");
//        } else {
//            //todo 失败逻辑
//            throw new RuntimeException("调用失败");
//        }
//    }
//
//
//    /**
//     * 分账关系查询
//     *
//     * @param payRequest
//     * @return
//     */
//    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_QUERY)
//    public void tradeRoyaltyRelationQuery(PayRequest payRequest) {
//        AlipayTradeRoyaltyRelationBatchqueryModel alipayTradeRoyaltyRelationBatchqueryModel =
//                BeanUtil.toBean(payRequest.getParams(), AlipayTradeRoyaltyRelationBatchqueryModel.class);
//        AlipayTradeRoyaltyRelationBatchqueryRequest request = new AlipayTradeRoyaltyRelationBatchqueryRequest();
//        request.setChannelBizModel(alipayTradeRoyaltyRelationBatchqueryModel);
//        AlipayTradeRoyaltyRelationBatchqueryResponse response = null;
//        try {
//            response = getAlipayClient(payRequest.getAppId()).execute(request);
//        } catch (AlipayApiException e) {
//            throw new RuntimeException(e);
//        }
//
//        if (response.isSuccess()) {
//            System.out.println("调用成功");
//        } else {
//            //todo 失败逻辑
//            throw new RuntimeException("调用失败");
//        }
//    }

}
