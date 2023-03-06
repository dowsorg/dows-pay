package org.dows.pay.weixin;

import com.alipay.api.request.AlipayOpenMiniVersionAuditApplyRequest;
import com.github.binarywang.wxpay.bean.ecommerce.FinishOrderRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.open.bean.message.WxOpenMaSubmitAuditMessage;
import me.chanjar.weixin.open.bean.result.WxOpenMaSubmitAuditResult;
import me.chanjar.weixin.open.bean.result.WxOpenResult;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.springframework.stereotype.Service;

/**
 * 小程序相关业务功能
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class WeixinMiniHandler extends AbstractWeixinHandler {


    private static final Gson GSON = new GsonBuilder().create();
    /**
     * 上传小程序模板
     * https://opendocs.alipay.com/mini/03l8bz
     * alipay.open.mini.version.upload(小程序基于模板上传版本)
     */
    @PayMapping(method = PayMethods.MINI_UPLOAD)
    public WxOpenResult uploadMini(PayRequest payRequest) {
        //todo 待实现业务逻辑
        WxOpenResult response = null;
        try {
            response = this.getWxOpenMaClient(payRequest.getAppId()).codeCommit(
                    Long.valueOf(payRequest.getBizModel().getWeixinFeilds().get("templateId").toString())
                    ,payRequest.getBizModel().getWeixinFeilds().get("userVersion").toString()
                    ,payRequest.getBizModel().getWeixinFeilds().get("userDesc").toString()
                    ,GSON.toJson(payRequest.getBizModel().getWeixinFeilds().get("extJsonObject").toString())
            );
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
    }


    /**
     * 小程序提交审核
     * https://opendocs.alipay.com/mini/03l9bq
     * alipay.open.mini.version.audit.apply(小程序提交审核)
     */
    public WxOpenMaSubmitAuditResult  auditMini(PayRequest payRequest) {
        WxOpenMaSubmitAuditResult response = null;
        WxOpenMaSubmitAuditMessage wxOpenMaSubmitAuditMessage = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), WxOpenMaSubmitAuditMessage.class);
        try {
            response = this.getWxOpenMaClient(payRequest.getAppId()).submitAudit(
                    wxOpenMaSubmitAuditMessage);
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;

    }


    /**
     * 小程序上架
     * https://opendocs.alipay.com/mini/03l21p
     * alipay.open.mini.version.online(小程序上架)
     */
    public WxOpenResult onlineMini(PayRequest payRequest) {
        //todo 待实现业务逻辑
        WxOpenResult response = null;
        try {
            response = this.getWxOpenMaClient(payRequest.getAppId()).releaseAudited();
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
    }


}
