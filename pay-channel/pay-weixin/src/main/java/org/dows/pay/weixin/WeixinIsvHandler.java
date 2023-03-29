package org.dows.pay.weixin;

import cn.hutool.json.JSONUtil;
import com.alipay.service.schema.util.StringUtil;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsRequest;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsResult;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsStatusResult;
import com.github.binarywang.wxpay.bean.media.ImageUploadResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.v3.WechatPayUploadHttpPost;
import com.github.binarywang.wxpay.v3.util.RsaCryptoUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.open.bean.result.WxOpenResult;
import me.chanjar.weixin.open.util.json.WxOpenGsonBuilder;
import org.apache.http.client.ResponseHandler;
import org.dows.app.api.mini.request.AppApplyRequest;
import org.dows.app.biz.AppApplyBiz;
import org.apache.commons.codec.digest.DigestUtils;
import org.dows.account.api.AccountTenantApi;
import org.dows.account.api.AccountUserApi;
import org.dows.account.bo.AccountTenantBo;
import org.dows.account.bo.AccountUserBo;
import org.dows.app.api.mini.AppApplyApi;
import org.dows.app.api.mini.request.AppApplyRequest;
import org.dows.app.entity.AppApply;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.message.WeixinMessage;
import org.dows.pay.bo.IsvCreateBo;
import org.dows.user.api.api.UserCompanyApi;
import org.dows.user.api.dto.UserCompanyDTO;
import org.dows.user.api.vo.UserCompanyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeixinIsvHandler extends AbstractWeixinHandler {
    private static final Gson GSON = new GsonBuilder().create();
    private final AppApplyApi appApplyApi;
    private final UserCompanyApi userCompanyApi;
    private final AccountUserApi acountUserApi;
    private final AccountTenantApi acountTenantApi;
    private final IdGenerator idGenerator = new SimpleIdGenerator();
    @Autowired
    protected ApplicationContext applicationContext;

    /**
     * 申请/创建小程序
     *
     * @param
     */
    @PayMapping(method = PayMethods.ISV_CREATE)
    public void createIsvMini(PayRequest payRequest) {
        //上传证件信息
        List<ImageUploadResult> list = imageUploadV3(payRequest);
        UUID uuid = idGenerator.generateId();
        IsvCreateBo isvCreateBo = (IsvCreateBo)payRequest.getBizModel();
        // todo 先查询该营业执照有没有申请过，如果没有就保存，如果有直接查询比对是否是相同的申请（orderNo为空 其他字段值全部相同通道+应用名）
        AppApplyRequest appApply = AppApplyRequest.builder()
                .appName(isvCreateBo.getAppName())
                .platform(PayChannels.WEIXIN.name())
                .contactName(isvCreateBo.getContactName())
                .contactPhone(isvCreateBo.getContactPhone())
                .build();
        Response responseAppApply = appApplyApi.getOneAppApply(appApply);
        if (responseAppApply == null || responseAppApply.getData() == null || ((AppApply)responseAppApply.getData()).getPlatformOrderNo() == null) {
            // todo 保存请求
            appApply.setApplyOrderNo(uuid.toString());
            appApplyApi.saveApply(appApply);
        }else{
            appApply.setApplyOrderNo(((AppApply)responseAppApply.getData()).getApplyOrderNo());
        }
        //todo 调用微信接口创建商户小程序
        String url = String.format("%s/v3/ecommerce/applyments/", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        ApplymentsRequest request = new ApplymentsRequest();
        autoMappingValue(payRequest,request);
        ApplymentsResult response =null;
        try {
            RsaCryptoUtil.encryptFields(request,this.getWeixinClient(payRequest.getAppId()).getConfig().getVerifier().getValidCertificate());
            String result = this.getWeixinClient(payRequest.getAppId()).postV3WithWechatpaySerial(url,GSON.toJson(request));
            response = GSON.fromJson(result, ApplymentsResult.class);
        } catch ( WxPayException e) {
            throw new RuntimeException(e);
        }
        /**
         * todo 提前保存该对象 createMiniRequest 到用户实体字典域UserCompany表，留后期场景使用
         * todo 保存公司信息到用户实体字典域
         */
        UserCompanyDTO userCompanyRequest = UserCompanyDTO.builder()
                .certNo(request.getIdCardInfo().getIdCardNumber())
                .build();
        Response<UserCompanyVo> userCompany = userCompanyApi.getUserCompany(userCompanyRequest);
        UserCompanyVo responseUserCompany = userCompany.getData();
        if (responseUserCompany == null) {
            userCompanyRequest.setCertNo(request.getIdCardInfo().getIdCardNumber());
            userCompanyRequest.setCompanyName(request.getMerchantShortname());
            userCompanyRequest.setLegalPerson(request.getIdCardInfo().getIdCardName());
            userCompanyRequest.setUserId(uuid.toString());
            userCompanyRequest.setCompanyCode(request.getIdCardInfo().getIdCardNumber());
            userCompanyRequest.setDt(new Date());
            userCompanyApi.insertUserCompany(userCompanyRequest);
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
            appApplyApi.updateApplyPlatformOrderNo(appApplyUpdateRequest);
            //建立账户与商户关联关系
            AccountUserBo accountUserBo = new AccountUserBo();
            accountUserBo.setAccountId(isvCreateBo.getAccount());
            accountUserBo.setUserId(userCompanyRequest.getUserId());
            acountUserApi.updateAccountUser(accountUserBo);
            //建立租户与账户关联关系
            AccountTenantBo accountTenantBo = new AccountTenantBo();
            accountTenantBo.setAccountId(isvCreateBo.getAccount());
            accountTenantBo.setUserId(userCompanyRequest.getUserId());
            acountTenantApi.updateAccountTenant(accountTenantBo);
            log.info("调用成功,响应信息:{}", JSONUtil.toJsonStr(response));
        } else {
            log.error("调用失败,响应信息:{}", JSONUtil.toJsonStr(response));
        }

    }
    /**
     * 查询该订单协助创建小程序的情况
     */
    @PayMapping(method = PayMethods.ISV_QUERY)
    public ApplymentsStatusResult queryIsvMini(PayRequest payRequest) {
        //todo 逻辑待实现
        ApplymentsRequest request = new ApplymentsRequest();
        autoMappingValue(payRequest,request);
        String url = String.format("%s/v3/ecommerce/applyments/out-request-no/%s", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl(), request.getOutRequestNo());
        String result = null;
        try {
            result = getWeixinClient(payRequest.getAppId()).getV3(url);
        } catch (WxPayException e) {
            e.printStackTrace();
        }
        return GSON.fromJson(result, ApplymentsStatusResult.class);

    }

    /**
     * 商户确认服务商代创建小程序结果通知
     */
    @EventListener(value = {PayEvent.class})
    public void onIsvMerchantConfirmed(PayEvent<WeixinMessage> payEvent) {
        //todo 逻辑待实现
        WeixinMessage payMessage = payEvent.getPayMessage();
        log.info("处理 alipay.open.mini.merchant.confirmed 事件消息:{}", payMessage);
        // todo 业务处理
        String appId = payMessage.getAppId();
        String msgApi = payMessage.getMsgApi();
        String msgId = payMessage.getMsgId();
        PayHandler handler = applicationContext.getBean(payEvent.getHandlerClass());
        handler.onMessage(payMessage);

    }
    /**
     * 服务商代商户申请小程序
     */
    @PayMapping(method = PayMethods.ISV_APPLY)
    public WxOpenResult fastRegisterApp(PayRequest payRequest) throws WxErrorException {
        IsvCreateBo isvCreateBo = (IsvCreateBo)payRequest.getBizModel();
         WxOpenResult response = this.getWxOpenClient(payRequest.getAppId()).getWxOpenComponentService().fastRegisterWeapp(
                 isvCreateBo.getCertName()
                ,isvCreateBo.getCertNo()
                ,isvCreateBo.getCertType()
                ,isvCreateBo.getLegalPersonalWechat()
                ,isvCreateBo.getLegalPersonalName()
                ,isvCreateBo.getContactPhone());

        return response;
    }

    /**
     * 服务商代商户申请小程序上传文件
     */
    public List<ImageUploadResult> imageUploadV3(PayRequest payRequest) {
        List<ImageUploadResult> list = new ArrayList<>();
        IsvCreateBo isvCreateBo = (IsvCreateBo)payRequest.getBizModel();
        File licenseFile=new File(isvCreateBo.getLicensePic());
        list.add(upload(licenseFile,payRequest));
        File legalPicBackFile=new File(isvCreateBo.getLegalPicBack());
        list.add(upload(legalPicBackFile,payRequest));
        File legalPicFrontFile=new File(isvCreateBo.getLegalPicFront());
        list.add(upload(legalPicFrontFile,payRequest));
        return list;
    }

    public ImageUploadResult upload(File file,PayRequest payRequest){
        String url = String.format("%s/v3/merchant/media/upload", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        String result = "";
        try{
            FileInputStream s1 = new FileInputStream(file);
            String sha256 = DigestUtils.sha256Hex(s1);
            InputStream s2 = new FileInputStream(file);
            WechatPayUploadHttpPost request = new WechatPayUploadHttpPost.Builder(URI.create(url))
                    .withImage(file.getName(), sha256, s2)
                    .build();
            result = this.getWeixinClient(payRequest.getAppId()).postV3(url, request);

        }catch ( Exception e){
            e.printStackTrace();
        }

        return ImageUploadResult.fromJson(result);
    }

}
