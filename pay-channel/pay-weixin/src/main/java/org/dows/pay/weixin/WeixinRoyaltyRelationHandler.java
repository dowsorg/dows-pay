package org.dows.pay.weixin;

import com.github.binarywang.wxpay.bean.ecommerce.*;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.EcommerceService;
import com.github.binarywang.wxpay.v3.util.RsaCryptoUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    private static final Gson GSON = new GsonBuilder().create();

    /**
     * 分账完成
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_FINISH)
    public void tradeRoyaltyFinish(PayRequest payRequest) {
        FinishOrderRequest finishOrderRequest = GSON.fromJson(GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), FinishOrderRequest.class);
        String url = String.format("%s/v3/ecommerce/profitsharing/finish-order", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        try {
            String response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(finishOrderRequest));
            ProfitSharingResult profitSharingResult = GSON.fromJson(response, ProfitSharingResult.class);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 分账申请
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_APPLY)
    public void tradeRoyaltyApply(PayRequest payRequest) {
        ProfitSharingRequest profitSharingRequest = GSON.fromJson(GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), ProfitSharingRequest.class);
        String url = String.format("%s/v3/ecommerce/profitsharing/orders", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        try {
            RsaCryptoUtil.encryptFields(profitSharingRequest, this.getWeixinClient(payRequest.getAppId()).getConfig().getVerifier().getValidCertificate());
            String response = this.getWeixinClient(payRequest.getAppId()).postV3WithWechatpaySerial(url, GSON.toJson(profitSharingRequest));
            ProfitSharingResult profitSharingResult = GSON.fromJson(response, ProfitSharingResult.class);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 分账查询
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_QUERY)
    public void tradeRoyaltyQuery(PayRequest payRequest) {
        ProfitSharingQueryRequest profitSharingQueryRequest = GSON.fromJson(GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), ProfitSharingQueryRequest.class);
        String url = String.format("%s/v3/ecommerce/profitsharing/orders?sub_mchid=%s&transaction_id=%s&out_order_no=%s"
                , this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl()
                , profitSharingQueryRequest.getSubMchid()
                , profitSharingQueryRequest.getTransactionId()
                , profitSharingQueryRequest.getOutOrderNo());
        try {
            String response = this.getWeixinClient(payRequest.getAppId()).getV3(url);
            ProfitSharingResult profitSharingResult = GSON.fromJson(response, ProfitSharingResult.class);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 分账关系绑定
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_BIND)
    public void tradeRoyaltyRelationBind(PayRequest payRequest) {
        ProfitSharingReceiverRequest profitSharingReceiverRequest = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), ProfitSharingReceiverRequest.class);
        String url =String.format("%s/v3/ecommerce/profitsharing/receivers/add",this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        try {
            String response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(profitSharingReceiverRequest));
            ProfitSharingReceiverResult profitSharingReceiverResult = GSON.fromJson(response, ProfitSharingReceiverResult.class);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 分账关系删除
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_UNBIND)
    public void tradeRoyaltyRelationUnbind(PayRequest payRequest) {
        ProfitSharingReceiverRequest profitSharingReceiverRequest = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), ProfitSharingReceiverRequest.class);
        String url =String.format("%s/v3/ecommerce/profitsharing/receivers/delete",this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        try {
            String response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(profitSharingReceiverRequest));
            ProfitSharingReceiverResult profitSharingReceiverResult = GSON.fromJson(response, ProfitSharingReceiverResult.class);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
    }


}
