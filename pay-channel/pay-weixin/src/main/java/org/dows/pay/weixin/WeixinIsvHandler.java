package org.dows.pay.weixin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjectUtil;
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
import org.apache.commons.codec.digest.DigestUtils;
import org.dows.account.api.AccountTenantApi;
import org.dows.account.api.AccountUserApi;
import org.dows.account.bo.AccountTenantBo;
import org.dows.account.bo.AccountUserBo;
import org.dows.app.api.mini.AppApplyApi;
import org.dows.app.api.mini.request.AppApplyRequest;
import org.dows.app.api.mini.response.AppApplyResponse;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.message.WeixinMessage;
import org.dows.pay.bo.ApplymentsBo;
import org.dows.pay.bo.IsvCreateBo;
import org.dows.store.api.StoreInstanceApi;
import org.dows.store.api.request.StoreInstanceRequest;
import org.dows.user.api.api.UserCompanyApi;
import org.dows.user.api.dto.UserCompanyDTO;
import org.dows.user.api.vo.UserCompanyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeixinIsvHandler extends AbstractWeixinHandler {
    private static final Gson GSON = new GsonBuilder().create();
    private final AppApplyApi appApplyApi;
    private final UserCompanyApi userCompanyApi;
    private final AccountUserApi acountUserApi;
    private final AccountTenantApi acountTenantApi;
    private final StoreInstanceApi storeInstanceApi;
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
        Map<String, ImageUploadResult> stringImageUploadResultMap = imageUploadV3(payRequest);
        UUID uuid = idGenerator.generateId();
        IsvCreateBo isvCreateBo = (IsvCreateBo)payRequest.getBizModel();
        // todo 先查询该营业执照有没有申请过，如果没有就保存，如果有直接查询比对是否是相同的申请（orderNo为空 其他字段值全部相同通道+应用名）
        AppApplyRequest appApply = AppApplyRequest.builder()
                .appName(isvCreateBo.getAppName())
                .platform(PayChannels.WEIXIN.name())
                .contactName(isvCreateBo.getContactName())
                .contactPhone(isvCreateBo.getContactPhone())
                .build();
        Response<AppApplyResponse> responseAppApply = appApplyApi.getOneAppApply(appApply);
        if (responseAppApply == null || responseAppApply.getData() == null || ((AppApplyResponse)responseAppApply.getData()).getPlatformOrderNo() == null) {
            // todo 保存请求
            appApply.setApplyOrderNo(uuid.toString());
            appApplyApi.saveApply(appApply);
        }else{
            appApply.setApplyOrderNo(((AppApplyResponse)responseAppApply.getData()).getApplyOrderNo());
        }
        //todo 调用微信接口创建商户小程序
        String url = String.format("%s/v3/ecommerce/applyments/", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        ApplymentsRequest request = new ApplymentsRequest();
        autoMappingValue(payRequest,request);
        //图片路径
        //金融机构许可证图片
        request.getBusinessLicenseInfo().setBusinessLicenseCopy(stringImageUploadResultMap.get("businessLicenseFile").getMediaId());
        //身份证人像面照片
        request.getIdCardInfo().setIdCardCopy(stringImageUploadResultMap.get("idCardCopyFile").getMediaId());
        //身份证国徽面照片
        request.getIdCardInfo().setIdCardNational(stringImageUploadResultMap.get("idCardNationalFile").getMediaId());
        //经营者/法人身份证信息 正面照片
        request.getIdDocInfo().setIdDocCopy(stringImageUploadResultMap.get("idDocCopyFile").getMediaId());
        //经营者/法人身份证信息 反面照片
        request.getIdDocInfo().setIdDocCopyBack(stringImageUploadResultMap.get("idDocCopyBackFile").getMediaId());
        //超级管理员身份证信息 正面照片
        request.getContactInfo().setContactIdDocCopy(stringImageUploadResultMap.get("contactIdDocCopyFile").getMediaId());
        //超级管理员身份证信息 反面照片
        request.getContactInfo().setContactIdDocCopyBack(stringImageUploadResultMap.get("contactIdDocCopyBackFile").getMediaId());
        //受益人列表 受益人正反面照片
        request.getUboInfoList().forEach(
                x->{
                    x.setUboIdDocCopy(stringImageUploadResultMap.get("uboIdDocCopyFile"+x.getUboIdDocNumber()).getMediaId());
                    x.setUboIdDocCopyBack(stringImageUploadResultMap.get("UboIdDocCopyBackFile"+x.getUboIdDocNumber()).getMediaId());
                });
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
            //保存门店信息
            StoreInstanceRequest storeInstanceRequest = new StoreInstanceRequest();
            BeanUtil.copyProperties(isvCreateBo,storeInstanceRequest);
            storeInstanceApi.saveStoreInstance(storeInstanceRequest);
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
        IsvCreateBo isvCreateBo = (IsvCreateBo)payRequest.getBizModel();
        String url = String.format("%s/v3/ecommerce/applyments/out-request-no/%s", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl(), request.getOutRequestNo());
        String result = null;
        try {
            result = getWeixinClient(payRequest.getAppId()).getV3(url);
        } catch (WxPayException e) {
            e.printStackTrace();
        }
        //更新商户号
        ApplymentsStatusResult applymentsStatusResult = GSON.fromJson(result, ApplymentsStatusResult.class);
        AccountTenantBo accountTenantBo = new AccountTenantBo();
        accountTenantBo.setMerchantNo(applymentsStatusResult.getSubMchid());
        accountTenantBo.setAccountId(isvCreateBo.getAccount());
        acountTenantApi.updateAccountTenant(accountTenantBo);
        return applymentsStatusResult;

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
    public Map<String,ImageUploadResult> imageUploadV3(PayRequest payRequest) {
        Map<String,ImageUploadResult> map = new HashMap<>();
        IsvCreateBo isvCreateBo = (IsvCreateBo)payRequest.getBizModel();
        //营业执照扫描件
        File businessLicenseFile=new File(isvCreateBo.getBusinessLicenseInfo().getBusinessLicenseCopy());
        map.put("businessLicenseFile",upload(businessLicenseFile,payRequest));
        //金融机构许可证图片
        if(!StringUtil.isEmpty(isvCreateBo.getFinanceInstitutionInfo().getFinanceLicensePics())){
            File financeLicensePicsFile=new File(isvCreateBo.getFinanceInstitutionInfo().getFinanceLicensePics());
            map.put("financeLicensePicsFile",upload(financeLicensePicsFile,payRequest));
        }
        //身份证人像面照片
        if(!StringUtil.isEmpty(isvCreateBo.getIdCardInfo().getIdCardCopy())){
            File idCardCopyFile=new File(isvCreateBo.getIdCardInfo().getIdCardCopy());
            map.put("idCardCopyFile",upload(idCardCopyFile,payRequest));
        }
        //身份证国徽面照片
        if(!StringUtil.isEmpty(isvCreateBo.getIdCardInfo().getIdCardNational())){
            File idCardNationalFile=new File(isvCreateBo.getIdCardInfo().getIdCardNational());
            map.put("idCardNationalFile",upload(idCardNationalFile,payRequest));
        }
        //经营者/法人身份证信息 正面照片
        if(!StringUtil.isEmpty(isvCreateBo.getIdDocInfo().getIdDocCopy())){
            File idDocCopyFile=new File(isvCreateBo.getIdDocInfo().getIdDocCopy());
            map.put("idDocCopyFile",upload(idDocCopyFile,payRequest));
        }
        //经营者/法人身份证信息 反面照片
        if(!StringUtil.isEmpty(isvCreateBo.getIdDocInfo().getIdDocCopyBack())){
            File idDocCopyBackFile=new File(isvCreateBo.getIdDocInfo().getIdDocCopyBack());
            map.put("idDocCopyBackFile",upload(idDocCopyBackFile,payRequest));
        }
        //超级管理员身份证信息 正面照片
        if(!StringUtil.isEmpty(isvCreateBo.getContactInfo().getContactIdDocCopy())){
            File contactIdDocCopyFile=new File(isvCreateBo.getContactInfo().getContactIdDocCopy());
            map.put("contactIdDocCopyFile",upload(contactIdDocCopyFile,payRequest));
        }
        //超级管理员身份证信息 反面照片
        if(!StringUtil.isEmpty(isvCreateBo.getContactInfo().getContactIdDocCopyBack())){
            File contactIdDocCopyBackFile=new File(isvCreateBo.getContactInfo().getContactIdDocCopyBack());
            map.put("contactIdDocCopyBackFile",upload(contactIdDocCopyBackFile,payRequest));
        }
        //受益人列表 受益人正反面照片
        List<ApplymentsBo.UboInfo> uboInfoList = isvCreateBo.getUboInfoList();
        if(!ObjectUtil.isEmpty(uboInfoList)){
            uboInfoList.forEach(x->{
                if(!x.getUboIdDocCopy().isEmpty()){
                    File uboIdDocCopyFile=new File(x.getUboIdDocCopy());
                    map.put("uboIdDocCopyFile"+x.getUboIdDocNumber(),upload(uboIdDocCopyFile,payRequest));
                }
                if(!x.getUboIdDocCopyBack().isEmpty()){
                    File UboIdDocCopyBackFile=new File(x.getUboIdDocCopyBack());
                    map.put("UboIdDocCopyBackFile"+x.getUboIdDocNumber(),upload(UboIdDocCopyBackFile,payRequest));
                }
            });
        }
        return map;
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
