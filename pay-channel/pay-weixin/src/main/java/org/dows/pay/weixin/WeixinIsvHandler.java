package org.dows.pay.weixin;

import cn.hutool.json.JSONUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayOpenMiniIsvCreateModel;
import com.alipay.api.domain.CreateMiniRequest;
import com.alipay.api.request.AlipayOpenMiniIsvCreateRequest;
import com.alipay.api.response.AlipayOpenMiniIsvCreateResponse;
import com.alipay.service.schema.util.StringUtil;
import com.github.binarywang.wxpay.bean.applyment.WxPayApplyment4SubCreateRequest;
import com.github.binarywang.wxpay.bean.applyment.WxPayApplymentCreateResult;
import com.github.binarywang.wxpay.bean.request.BaseWxPayRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.v3.util.RsaCryptoUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.app.api.AppApplyRequest;
import org.dows.app.biz.AppApplyBiz;
import org.dows.app.entity.AppApply;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayMessage;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.message.AlipayMessage;
import org.dows.pay.bo.IsvCreateBo;
import org.dows.user.biz.UserCompanyBiz;
import org.dows.user.biz.UserCompanyRequest;
import org.dows.user.entity.UserCompany;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;
import org.springframework.util.StringUtils;

import java.security.cert.X509Certificate;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeixinIsvHandler extends AbstractWeixinHandler {
    private static final Gson GSON = new GsonBuilder().create();
    private final AppApplyBiz appApplyBiz;

    private final UserCompanyBiz userCompanyBiz;


    private final IdGenerator idGenerator = new SimpleIdGenerator();

    /**
     * 申请/创建小程序
     *
     * @param
     */
    @PayMapping(method = PayMethods.ISV_CREATE)
    public void createIsvMini(PayRequest payRequest) {
        UUID uuid = idGenerator.generateId();
        IsvCreateBo isvCreateBo = (IsvCreateBo)payRequest.getBizModel();
        // todo 先查询该营业执照有没有申请过，如果没有就保存，如果有直接查询比对是否是相同的申请（orderNo为空 其他字段值全部相同通道+应用名）
        AppApplyRequest appApply = AppApplyRequest.builder()
                .appName(isvCreateBo.getAppName())
                .platform(PayChannels.WEIXIN.name())
                .contactName(isvCreateBo.getContactName())
                .contactPhone(isvCreateBo.getContactPhone())
                .build();
        Response responseAppApply = appApplyBiz.getOneAppApply(appApply);
        if (responseAppApply == null || responseAppApply.getData() == null || ((AppApply)responseAppApply.getData()).getPlatformOrderNo() == null) {
            // todo 保存请求
            appApply.setApplyOrderNo(uuid.toString());
            appApplyBiz.saveApply(appApply);
        }else{
            appApply.setApplyOrderNo(((AppApply)responseAppApply.getData()).getApplyOrderNo());
        }
        //todo 调用微信接口创建商户小程序
        String url = String.format("%s/v3/applyment4sub/applyment/", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        String requestParamStr = GSON.toJson(payRequest.getBizModel().getWeixinFeilds());
        WxPayApplyment4SubCreateRequest request = GSON.fromJson(requestParamStr,WxPayApplyment4SubCreateRequest.class);
        request.setBusinessCode(appApply.getApplyOrderNo());
        WxPayApplymentCreateResult response =null;
        try {
            encryptFiled(request,payRequest);
            String result = getWeixinClient(payRequest.getAppId()).postV3WithWechatpaySerial(url,GSON.toJson(request));
            response = GSON.fromJson(result, WxPayApplymentCreateResult.class);
        } catch ( WxPayException e) {
            throw new RuntimeException(e);
        }
        /**
         * todo 提前保存该对象 createMiniRequest 到用户实体字典域UserCompany表，留后期场景使用
         * todo 保存公司信息到用户实体字典域
         */
        UserCompanyRequest userCompanyRequest = UserCompanyRequest.builder()
                .certNo(request.getSubjectInfo().getCertificateInfo().getCertNumber())
                .build();
        UserCompany responseUserCompany = userCompanyBiz.getOneUserCompany(userCompanyRequest);
        if (responseUserCompany == null) {
            userCompanyRequest.setCertNo(request.getSubjectInfo().getCertificateInfo().getCertNumber());
            userCompanyRequest.setCompanyName(request.getSubjectInfo().getCertificateInfo().getMerchantName());
            userCompanyRequest.setLegalPerson(request.getSubjectInfo().getCertificateInfo().getLegalPerson());
            userCompanyBiz.saveUserCompany(userCompanyRequest);
        }

        if (!StringUtil.isEmpty(response.getApplymentId())) {
            // todo 保存订单号 及对应申请的营业执照 和联系人 信息，返回申请小程序记录表ID 后续通过ID查询
            String orderNo = response.getApplymentId();
            log.info("创建微信小程序成功，返回订单号为:{}", orderNo);
            /**
             * todo 建立关联关系（小程序申请对象） [小程序与营业执照的关系],通过营业执照来关联 小程序名 及对应的orderNo
             */
            AppApplyRequest appApplyUpdateRequest = AppApplyRequest.builder()
                    .applyOrderNo(appApply.getApplyOrderNo())
                    .platformOrderNo(orderNo)
                    .build();
            appApplyBiz.updateApplyPlatformOrderNo(appApplyUpdateRequest);
            log.info("调用成功,响应信息:{}", JSONUtil.toJsonStr(response));
        } else {
            log.error("调用失败,响应信息:{}", JSONUtil.toJsonStr(response));
        }

    }
    /**
     * 查询该订单协助创建小程序的情况
     */
    @PayMapping(method = PayMethods.ISV_QUERY)
    public String queryIsvMini(PayRequest payRequest) {
        //todo 逻辑待实现
        return null;

    }

    /**
     * 商户确认服务商代创建小程序结果通知
     */
    @EventListener(value = {PayEvent.class})
    public void onIsvMerchantConfirmed(PayEvent<AlipayMessage> payEvent) {
        //todo 逻辑待实现
    }

    @Override
    public void onMessage(PayMessage payMessage) {
        String bizContent = payMessage.getBizContent();
        log.info("业务响应:bizContent = {}", bizContent);
    }
    private void encryptFiled(WxPayApplyment4SubCreateRequest request,PayRequest payRequest) throws WxPayException {

        X509Certificate validCertificate = getWeixinClient(payRequest.getAppId()).getConfig().getVerifier().getValidCertificate();

        RsaCryptoUtil.encryptFields(request, validCertificate);
    }
}
