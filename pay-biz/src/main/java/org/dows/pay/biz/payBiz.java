package org.dows.pay.biz;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alipay.api.response.AlipayOpenMiniIsvCreateResponse;
import com.alipay.service.schema.util.StringUtil;
import com.github.binarywang.wxpay.bean.applyment.WxPayApplyment4SubCreateRequest;
import com.github.binarywang.wxpay.bean.applyment.WxPayApplymentCreateResult;
import com.github.binarywang.wxpay.bean.applyment.enums.BankAccountTypeEnum;
import com.github.binarywang.wxpay.bean.applyment.enums.IdTypeEnum;
import com.github.binarywang.wxpay.bean.applyment.enums.SalesScenesTypeEnum;
import com.github.binarywang.wxpay.bean.applyment.enums.SubjectTypeEnum;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsRequest;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsStatusResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.open.bean.result.WxOpenQueryAuthResult;
import me.chanjar.weixin.open.bean.result.WxOpenResult;
import org.dows.app.api.mini.request.AppApplyRequest;
import org.dows.app.api.mini.request.PayApplyStatusReq;
import org.dows.app.api.mini.request.WechatMiniUploadRequest;
import org.dows.app.entity.AppApply;
import org.dows.app.service.AppApplyService;
import org.dows.auth.api.weixin.WeixinTokenApi;
import org.dows.framework.api.Response;
import org.dows.framework.api.exceptions.BizException;
import org.dows.pay.alipay.AlipayIsvHandler;
import org.dows.pay.api.PayApi;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.request.MiniUploadRequest;
import org.dows.pay.api.request.PayIsvRequest;
import org.dows.pay.bo.IsvCreateBo;
import org.dows.pay.bo.IsvCreateTyBo;
import org.dows.pay.boot.PayClientConfig;
import org.dows.pay.entity.PayAccount;
import org.dows.pay.entity.PayApply;
import org.dows.pay.form.WxBaseInfoForm;
import org.dows.pay.service.PayAccountService;
import org.dows.pay.service.PayApplyService;
import org.dows.pay.weixin.WeixinIsvHandler;
import org.dows.pay.weixin.WeixinMiniHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * ISV 代理商业务
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class payBiz implements PayApi {
    @Lazy
    private final WeixinIsvHandler weixinIsvHandler;
    @Lazy
    private final AlipayIsvHandler alipayIsvHandler;
    @Lazy
    private final WeixinMiniHandler weixinMiniHandler;
    @Lazy
    private final PayApplyService payApplyService;
    @Lazy
    private final PayClientConfig payClientConfig;
    @Lazy
    private final PayAccountService payAccountService;
    @Lazy
    private final AppApplyService appApplyService;
    @Lazy
    private final MiniBiz miniBiz;

    private final WeixinTokenApi weixinTokenApi;

    @Override
    public Response isvApply(AppApplyRequest appApplyRequest) {
        PayRequest payRequest = new PayIsvRequest();
        log.info("生成appApplyRequest参数{}", appApplyRequest);
        if ("WEIXIN".equals(appApplyRequest.getApplyType())) {
            IsvCreateTyBo isvCreateTyBo = convertTy(appApplyRequest);
            log.info("生成payRequest.setBizModel参数{}", isvCreateTyBo);
            payRequest.setBizModel(isvCreateTyBo);
            payRequest.setChannel("weixin");
            payRequest.setAppId("wxdb8634feb22a5ab9");
            try {
                WxOpenResult wxOpenResult = weixinIsvHandler.fastRegisterApp(payRequest);
                log.info("生成WxOpenResult参数{}", wxOpenResult);
                // 小程序申请支付权限
                WxPayApplymentCreateResult isvMini = weixinIsvHandler.createIsvTyMini(payRequest);
                log.info("生成WxPayApplymentCreateResult参数{}", isvMini);
                if (wxOpenResult.isSuccess() && !StringUtil.isEmpty(isvMini.getApplymentId())) {
                    return Response.ok(true, "申请微信小程序成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
                //创建小程序
                return Response.fail(e.getMessage());
            }
        } else if ("ALIPAY".equals(appApplyRequest.getApplyType())) {
            IsvCreateBo isvCreateBo = convert(appApplyRequest);
            log.info("生成payRequest.setBizModel参数{}", isvCreateBo);
            payRequest.setBizModel(isvCreateBo);
            payRequest.setChannel("alipay");
            payRequest.setAppId("2021003129694075");
            try {
                //创建支付宝小程序
                AlipayOpenMiniIsvCreateResponse alipayResponse = alipayIsvHandler.createIsvMini(payRequest);
                log.info("生成AlipayOpenMiniIsvCreateResponse参数{}", alipayResponse);
                if (alipayResponse.isSuccess()) {
                    return Response.ok(true, "申请支付宝小程序成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
                //创建小程序
                return Response.fail(e.getMessage());
            }
        } else {
            IsvCreateTyBo isvCreateTyBo = convertTy(appApplyRequest);
            log.info("全部申请微信生成payRequest.setBizModel参数{}", isvCreateTyBo);
            payRequest.setBizModel(isvCreateTyBo);
            payRequest.setChannel("weixin");
            payRequest.setAppId("wxdb8634feb22a5ab9");
            try {
                WxOpenResult wxOpenResult = weixinIsvHandler.fastRegisterApp(payRequest);
                log.info("全部申请微信生成WxOpenResult参数{}", wxOpenResult);
                //创建支付小程序
                WxPayApplymentCreateResult isvMini = weixinIsvHandler.createIsvTyMini(payRequest);
                log.info("全部申请微信生成WxPayApplymentCreateResult参数{}", isvMini);
                if (wxOpenResult.isSuccess() && !StringUtil.isEmpty(isvMini.getApplymentId())) {
                    return Response.ok(true, "申请微信小程序成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
                //创建小程序
                return Response.fail(e.getMessage());
            }
            IsvCreateBo isvCreateBo = convert(appApplyRequest);
            log.info("全部申请支付宝生成payRequest.setBizModel参数{}", isvCreateBo);
            payRequest.setBizModel(isvCreateBo);
            payRequest.setChannel("alipay");
            payRequest.setAppId("2021003129694075");
            try {
                //创建支付宝小程序
                AlipayOpenMiniIsvCreateResponse alipayResponse = alipayIsvHandler.createIsvMini(payRequest);
                log.info("全部申请支付宝生成AlipayOpenMiniIsvCreateResponse参数{}", alipayResponse);
                if (alipayResponse.isSuccess()) {
                    return Response.ok(true, "申请支付宝小程序成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
                //创建小程序
                return Response.fail(e.getMessage());
            }
        }
        return Response.fail("系统异常，请联系管理员！");
    }

    @Override
    public Response miniBaseInfo(AppApplyRequest appApplyRequest) {
        //todo 维护小程序基本信息接口
        return null;
    }

    @Override
    public Response fastRegisterApp(AppApplyRequest appApplyRequest) {
        PayRequest payRequest = new PayIsvRequest();
        log.info("生成appApplyRequest参数{}", appApplyRequest);
        if ("WEIXIN".equals(appApplyRequest.getApplyType())) {
            IsvCreateTyBo isvCreateTyBo = convertTy(appApplyRequest);
            log.info("生成payRequest.setBizModel参数{}", isvCreateTyBo);
            payRequest.setBizModel(isvCreateTyBo);
            payRequest.setChannel("weixin");
            payRequest.setAppId("wxdb8634feb22a5ab9");
            try {
                // 申请小程序
                WxOpenResult wxOpenResult = weixinIsvHandler.fastRegisterApp(payRequest);
                log.info("生成WxOpenResult参数{}", wxOpenResult);
                if (wxOpenResult.isSuccess()) {
                    // todo 成功后的操作
                    return Response.ok(true, "提交申请微信小程序成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return Response.fail(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Response applyForPaymentAuth(AppApplyRequest appApplyRequest) {
        AppApply appApply = appApplyService.getByMerchantNo(appApplyRequest.getMerchantNo());
        if (appApply == null) {
            throw new BizException("未申请注册小程序不可申请支付能力");
        }
        PayRequest payRequest = new PayIsvRequest();
        log.info("生成appApplyRequest参数{}", appApplyRequest);
        if ("WEIXIN".equals(appApplyRequest.getApplyType())) {
            IsvCreateTyBo isvCreateTyBo = convertTy(appApplyRequest);
            log.info("生成payRequest.setBizModel参数{}", isvCreateTyBo);
            payRequest.setBizModel(isvCreateTyBo);
            payRequest.setChannel("weixin");
            payRequest.setAppId("wxdb8634feb22a5ab9");
            try {
                // 小程序申请支付权限
                log.info("生成WxPayApplymentCreateResult参数payRequest：{}", payRequest);
                WxPayApplymentCreateResult isvMini = weixinIsvHandler.createIsvTyMini(payRequest);
                log.info("生成WxPayApplymentCreateResult返回结果：{}", isvMini);
                if (!StringUtil.isEmpty(isvMini.getApplymentId())) {
                    // 申请支付权限并保存payAppl表
                    PayApply byMerchantNoAndType = payApplyService.getByMerchantNoAndType(appApplyRequest.getMerchantNo(), 1);
                    if (byMerchantNoAndType != null) {
                        byMerchantNoAndType.setApplyNo(isvMini.getApplymentId());
                        byMerchantNoAndType.setUpdateTime(new Date());
                        payApplyService.updateById(byMerchantNoAndType);
                    } else {
                        payApplyService.createPayApply(appApplyRequest.getMerchantNo(), appApply.getAppId(), isvMini.getApplymentId());
                    }
                    // todo 申请成功的操作
                    return Response.ok(true, "申请微信小程序支付权限成功");
                }
            } catch (Exception e) {
                log.warn("applyForPaymentAuth fail :", e);
                return Response.fail(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Response uploadWeChatMini(WechatMiniUploadRequest request) {
        try {

            MiniUploadRequest miniUploadRequest = convertUploadReq(request);
            WxOpenResult wxOpenResult = weixinMiniHandler.uploadMini(miniUploadRequest);
            return Response.ok(wxOpenResult);
        } catch (Exception e) {
            log.warn("uploadWeChatMini fail:", e);
            return Response.fail(e.getMessage());
        }
    }

    @Override
    public Response getNickNameStatus(PayApplyStatusReq res) {
        String authorizerAccessToken = weixinTokenApi.getAuthorizerAccessToken(res.getAppId());
        WxBaseInfoForm wxBaseInfoForm = new WxBaseInfoForm();
        wxBaseInfoForm.setAppId("wxdb8634feb22a5ab9");
        wxBaseInfoForm.setAuditId(res.getAuditId());
        wxBaseInfoForm.setAuthorizerAccessToken(authorizerAccessToken);
        Response nickNameStatus = miniBiz.getNickNameStatus(wxBaseInfoForm);
        return nickNameStatus;
    }

    @Override
    public WxOpenQueryAuthResult apiQueryAuth(String authorizationCode) {
        PayRequest payRequest = new PayIsvRequest();
        payRequest.setChannel("weixin");
        payRequest.setAppId("wxdb8634feb22a5ab9");
        IsvCreateTyBo isvCreateTyBo = new IsvCreateTyBo();
        isvCreateTyBo.setAuthorizationCode(authorizationCode);
        payRequest.setBizModel(isvCreateTyBo);
        WxOpenQueryAuthResult queryAuth = weixinIsvHandler.getQueryAuth(payRequest);
        return queryAuth;
    }

    private MiniUploadRequest convertUploadReq(WechatMiniUploadRequest request) {
        MiniUploadRequest miniUploadRequest = new MiniUploadRequest();
        String appId = Optional.ofNullable(payClientConfig.getClientConfigs().get(1).getAppId()).orElse("wxdb8634feb22a5ab9");
        miniUploadRequest.setAppId(appId);
        miniUploadRequest.setAuthorizerAppid(request.getAppId());
        miniUploadRequest.setTemplateId(request.getTemplateId());
        miniUploadRequest.setUserVersion("V1.0");
        miniUploadRequest.setUserDesc("normal");
        miniUploadRequest.setExtJsonObject(getExtJsonObject(request.getAppId()));
        return miniUploadRequest;
    }

    private String getExtJsonObject(String appId) {
        String str = "{\"extEnable\":true,\"extAppid\":\"" +
                appId +
                "\",\"directCommit\":true,\"ext\":{\"name\":\"wechat\",\"attr\":{\"host\":\"open.weixin.qq.com\",\"users\":[\"test\"]}}}";
        return str;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response queryPayApplyStatus(PayApplyStatusReq res) {
        PayApply payApply = payApplyService.getByMerchantNoAndType(res.getMerchantNo(), res.getApplyType());
        return Optional.ofNullable(payApply).map(p -> {
            Response response;
            if (p.getChecked()) {
                ApplymentsStatusResult statusResult = new ApplymentsStatusResult();
                statusResult.setApplymentState(payApply.getApplymentState());
                statusResult.setApplymentStateDesc(payApply.getApplymentStateDesc());
                statusResult.setSignUrl(payApply.getAppUrl());
                return Response.ok(statusResult);
            }
            response = queryApplymentStatus(payApply.getApplyNo());
            ApplymentsStatusResult result = (ApplymentsStatusResult) response.getData();
            if (!Objects.nonNull(payApply.getAppUrl())) {
                payApply.setAppUrl(result.getSignUrl());
            }
            payApply.setApplymentState(result.getApplymentState());
            if (Objects.equals("APPLYMENT_STATE_FINISHED", payApply.getApplymentState())) {
                payApply.setChecked(true);
            }
            payApply.setApplymentStateDesc(result.getApplymentStateDesc());
            payApply.setUpdateTime(new Date());
            payApply.setSubMchid(result.getSubMchid());
            payApplyService.updateById(payApply);
            if (payApply.getChecked()) {
                log.info("start checkAndSavePayAccount......");
                // 插入支付账号通道
                checkAndSavePayAccount(payApply);
            }
            return response;
        }).orElseGet(() -> {
            ApplymentsStatusResult statusResult = new ApplymentsStatusResult();
            statusResult.setApplymentState("NOT_APPLYMENT");
            statusResult.setApplymentStateDesc("未申请");
            return Response.ok(statusResult);
        });
    }

    private void checkAndSavePayAccount(PayApply payApply) {
        PayAccount payAccount = payAccountService.getByMerchantNo(payApply.getMerchantNo());
        Optional.ofNullable(payAccount).map(p -> {
            if (StrUtil.isNotEmpty(p.getChannelMerchantNo())) {
                return p;
            }
            payAccount.setChannelMerchantNo(payApply.getSubMchid());
            payAccount.setChannelAccount(payApply.getAppId());
            payAccountService.updateById(payAccount);
            return payAccount;

        }).orElseGet(() -> {
            PayAccount createPayAccount = new PayAccount();
            createPayAccount.setMerchantNo(payApply.getMerchantNo());
            createPayAccount.setChannelAccount(payApply.getAppId());
            createPayAccount.setChannelMerchantNo(payApply.getSubMchid());
            payAccountService.save(createPayAccount);
            return createPayAccount;
        });
    }

    @Override
    public Response queryApplymentStatus(String applymentId) {
        PayRequest payRequest = new PayIsvRequest();
        payRequest.setChannel("weixin");
        payRequest.setAppId("wxdb8634feb22a5ab9");
        IsvCreateBo isvCreateBo = new IsvCreateBo();
        isvCreateBo.setOutOrderNo(applymentId);
        payRequest.setBizModel(isvCreateBo);
        ApplymentsStatusResult applymentsStatusResult = weixinIsvHandler.queryIsvMini(payRequest);
        return Response.ok(applymentsStatusResult);
    }

    public IsvCreateBo convert(AppApplyRequest appApplyRequest) {
        log.info("开始转换参数appApplyRequest{}", appApplyRequest);
        IsvCreateBo isvCreateBo = new IsvCreateBo();
        isvCreateBo.setAccount(appApplyRequest.getPlatformAccount());
        //账户信息
        ApplymentsRequest.AccountInfo accountInfo = new ApplymentsRequest.AccountInfo();
        accountInfo.setAccountBank(appApplyRequest.getBankName());
        accountInfo.setAccountName(appApplyRequest.getBankAccountName());
        accountInfo.setAccountNumber(appApplyRequest.getBankNo());
        accountInfo.setBankAccountType("75");
        isvCreateBo.setAccountInfo(accountInfo);
        //法人信息
        isvCreateBo.setLegalPersonalName(appApplyRequest.getLegalName());
        isvCreateBo.setLegalPersonalWechat(appApplyRequest.getLegalWechatNo());
        isvCreateBo.setLegalPicBack(appApplyRequest.getProprietorIdPictureBack());
        isvCreateBo.setLegalPicFront(appApplyRequest.getProprietorIdPictureFront());
        isvCreateBo.setContactPhone(appApplyRequest.getContactPhone());
        //营业执照信息
        isvCreateBo.setCertNo(appApplyRequest.getCertNo());
        isvCreateBo.setCertType(appApplyRequest.getCertType());
        isvCreateBo.setCertName(appApplyRequest.getCertName());
        ApplymentsRequest.BusinessLicenseInfo businessLicenseInfo = new ApplymentsRequest.BusinessLicenseInfo();
        businessLicenseInfo.setBusinessLicenseCopy(appApplyRequest.getCertPicture());
        businessLicenseInfo.setBusinessLicenseNumber(appApplyRequest.getCertNo());
        businessLicenseInfo.setCertType("CERTIFICATE_TYPE_2388");
        businessLicenseInfo.setMerchantName(appApplyRequest.getTenantShortName());
        businessLicenseInfo.setLegalPerson(appApplyRequest.getLegalName());
        businessLicenseInfo.setBusinessTime(appApplyRequest.getCertValidityPeriodBegin());
        businessLicenseInfo.setCompanyAddress(appApplyRequest.getTenantAddress());
        isvCreateBo.setBusinessLicenseInfo(businessLicenseInfo);
        //经营信息
        ApplymentsRequest.IdCardInfo idCardInfo = new ApplymentsRequest.IdCardInfo();
        idCardInfo.setIdCardCopy(appApplyRequest.getProprietorIdPictureFront());
        idCardInfo.setIdCardNational(appApplyRequest.getProprietorIdPictureBack());
        idCardInfo.setIdCardName(appApplyRequest.getLegalName());
        idCardInfo.setIdCardNumber(appApplyRequest.getProprietorId());
        isvCreateBo.setIdCardInfo(idCardInfo);
        //超级管理员信息
        ApplymentsRequest.ContactInfo contactInfo = new ApplymentsRequest.ContactInfo();
        contactInfo.setContactName(appApplyRequest.getSuperAdminName());
        contactInfo.setMobilePhone(appApplyRequest.getContactPhone());
        contactInfo.setContactEmail(appApplyRequest.getContactEmail());
        contactInfo.setContactIdDocType("IDENTIFICATION_TYPE_IDCARD");
        contactInfo.setContactIdCardNumber(appApplyRequest.getSuperAdminId());
        contactInfo.setContactType(appApplyRequest.getContactType());
        contactInfo.setContactIdDocCopy(appApplyRequest.getProprietorIdPictureFront());
        contactInfo.setContactIdDocCopyBack(appApplyRequest.getProprietorIdPictureBack());
        isvCreateBo.setContactInfo(contactInfo);
        //受益人
        isvCreateBo.setOwner(false);
        isvCreateBo.setMerchantShortname(appApplyRequest.getTenantShortName());
        ApplymentsRequest.UboInfo uboInfo = new ApplymentsRequest.UboInfo();
        uboInfo.setUboIdDocName(appApplyRequest.getBeneficiaryName());
        uboInfo.setUboIdDocNumber(appApplyRequest.getBeneficiaryNo());
        uboInfo.setUboIdDocCopy(appApplyRequest.getBeneficiaryIdPictureFront());
        uboInfo.setUboIdDocCopyBack(appApplyRequest.getBeneficiaryIdPictureBack());
        uboInfo.setUboIdDocType(appApplyRequest.getBeneficiaryIdType());
        uboInfo.setUboIdDocPeriodBegin(appApplyRequest.getBeneficiaryIdValidityPeriodBegin());
        uboInfo.setUboIdDocPeriodEnd(appApplyRequest.getProprietorIdValidityPeriodEnd());
        uboInfo.setUboIdDocAddress(appApplyRequest.getProprietorIdAddress());
        List<ApplymentsRequest.UboInfo> list = new ArrayList<>();
        list.add(uboInfo);
        isvCreateBo.setUboInfoList(list);
        //资质证明
        isvCreateBo.setQualifications(appApplyRequest.getQualificationPicture());
        log.info("结束转换参数appApplyRequest{}", isvCreateBo);
        return isvCreateBo;
    }

    public IsvCreateTyBo convertTy(AppApplyRequest appApplyRequest) {
        log.info("开始转换参数appApplyRequest{}", appApplyRequest);
        IsvCreateTyBo isvCreateBo = new IsvCreateTyBo();
        isvCreateBo.setOutOrderNo(IdUtil.fastUUID().replace("-", ""));
        isvCreateBo.setAccount(appApplyRequest.getPlatformAccount());
        // 账户信息
        WxPayApplyment4SubCreateRequest.BankAccountInfo accountInfo = new WxPayApplyment4SubCreateRequest.BankAccountInfo();
        accountInfo.setAccountBank(appApplyRequest.getBankName());
        accountInfo.setAccountName(appApplyRequest.getBankAccountName());
        accountInfo.setAccountNumber(appApplyRequest.getBankNo());
        if (appApplyRequest.getProprietorAccountType().equals("BANK_ACCOUNT_TYPE_CORPORATE")) {
            accountInfo.setBankAccountType(BankAccountTypeEnum.BANK_ACCOUNT_TYPE_CORPORATE);
        } else if (appApplyRequest.getProprietorAccountType().equals("BANK_ACCOUNT_TYPE_PERSONAL")) {
            accountInfo.setBankAccountType(BankAccountTypeEnum.BANK_ACCOUNT_TYPE_PERSONAL);
        }
        accountInfo.setBankAddressCode(appApplyRequest.getBankPostalNo());
        isvCreateBo.setBankAccountInfo(accountInfo);
        // 主体资料
        isvCreateBo.setLegalPersonalName(appApplyRequest.getLegalName());
        isvCreateBo.setLegalPersonalWechat(appApplyRequest.getLegalWechatNo());
        isvCreateBo.setContactPhone(appApplyRequest.getContactPhone());
        WxPayApplyment4SubCreateRequest.SubjectInfo subjectInfo = new WxPayApplyment4SubCreateRequest.SubjectInfo();
        subjectInfo.setFinanceInstitution(false);
        switch (appApplyRequest.getSubjectType()) {
            case "SUBJECT_TYPE_ENTERPRISE":
                subjectInfo.setSubjectType(SubjectTypeEnum.SUBJECT_TYPE_ENTERPRISE);
                break;
            case "SUBJECT_TYPE_INDIVIDUAL":
                subjectInfo.setSubjectType(SubjectTypeEnum.SUBJECT_TYPE_INDIVIDUAL);
                break;
            case "SUBJECT_TYPE_INSTITUTIONS":
                subjectInfo.setSubjectType(SubjectTypeEnum.SUBJECT_TYPE_INSTITUTIONS);
                break;
            case "SUBJECT_TYPE_OTHERS":
                subjectInfo.setSubjectType(SubjectTypeEnum.SUBJECT_TYPE_OTHERS);
                break;
            case "SUBJECT_TYPE_MICRO":
                subjectInfo.setSubjectType(SubjectTypeEnum.SUBJECT_TYPE_MICRO);
                break;
        }
        WxPayApplyment4SubCreateRequest.SubjectInfo.BusinessLicenseInfo businessLicenseInfo
                = new WxPayApplyment4SubCreateRequest.SubjectInfo.BusinessLicenseInfo();
        businessLicenseInfo.setLicenseCopy(appApplyRequest.getCertPicture());
        businessLicenseInfo.setLicenseAddress(appApplyRequest.getTenantAddress());
        businessLicenseInfo.setLicenseNumber(appApplyRequest.getCertNo());
        businessLicenseInfo.setMerchantName(appApplyRequest.getTenantName());
        businessLicenseInfo.setLegalPerson(appApplyRequest.getLegalName());
        businessLicenseInfo.setPeriodBegin(appApplyRequest.getCertValidityPeriodBegin());
        businessLicenseInfo.setPeriodEnd(appApplyRequest.getCertValidityPeriodEnd());
        subjectInfo.setBusinessLicenseInfo(businessLicenseInfo);
        WxPayApplyment4SubCreateRequest.SubjectInfo.IdentityInfo identityInfo
                = new WxPayApplyment4SubCreateRequest.SubjectInfo.IdentityInfo();
        WxPayApplyment4SubCreateRequest.SubjectInfo.IdentityInfo.IdCardInfo idCardInfo
                = new WxPayApplyment4SubCreateRequest.SubjectInfo.IdentityInfo.IdCardInfo();
        // 经营信息
        idCardInfo.setIdCardCopy(appApplyRequest.getProprietorIdPictureFront());
        idCardInfo.setIdCardNational(appApplyRequest.getProprietorIdPictureBack());
        idCardInfo.setIdCardName(appApplyRequest.getIdCardName());
        idCardInfo.setIdCardNumber(appApplyRequest.getProprietorId());
        idCardInfo.setCardPeriodBegin(appApplyRequest.getProprietorIdValidityPeriodBegin());
        idCardInfo.setCardPeriodEnd(appApplyRequest.getProprietorIdValidityPeriodEnd());
        idCardInfo.setIdCardAddress(appApplyRequest.getProprietorIdAddress());
        identityInfo.setIdCardInfo(idCardInfo);
        if (!StringUtil.isEmpty(appApplyRequest.getOwner())
                && appApplyRequest.getOwner().equals("true")) {
            identityInfo.setOwner(true);
        } else {
            identityInfo.setOwner(false);
        }
//        if (subjectInfo.getSubjectType().equals("SUBJECT_TYPE_GOVERNMENT")
//                || subjectInfo.getSubjectType().equals("SUBJECT_TYPE_INSTITUTIONS")) {
//            if (appApplyRequest.getIdHolderType() != null) {
//                identityInfo.setIdHolderType(appApplyRequest.getIdHolderType());
//            }
//        }
        // 1、当证件持有人类型为法人时，填写。其他情况，无需上传。
        //2、个体户/企业/事业单位/社会组织：可选择任一证件类型，政府机关仅支持中国大陆居民-身份证类型。
        //IDENTIFICATION_TYPE_IDCARD：中国大陆居民-身份证
        //IDENTIFICATION_TYPE_OVERSEA_PASSPORT：其他国家或地区居民-护照
        //IDENTIFICATION_TYPE_HONGKONG_PASSPORT：中国香港居民-来往内地通行证
        //IDENTIFICATION_TYPE_MACAO_PASSPORT：中国澳门居民-来往内地通行证
        //IDENTIFICATION_TYPE_TAIWAN_PASSPORT：中国台湾居民-来往大陆通行证
        //IDENTIFICATION_TYPE_FOREIGN_RESIDENT：外国人居留证
        //IDENTIFICATION_TYPE_HONGKONG_MACAO_RESIDENT：港澳居民证
        //IDENTIFICATION_TYPE_TAIWAN_RESIDENT：台湾居民证
        //示例值：IDENTIFICATION_TYPE_IDCARD
        switch (appApplyRequest.getIdDocType()) {
            case "IDENTIFICATION_TYPE_IDCARD":
                identityInfo.setIdDocType(IdTypeEnum.IDENTIFICATION_TYPE_IDCARD);
                break;
            case "IDENTIFICATION_TYPE_OVERSEA_PASSPORT":
                identityInfo.setIdDocType(IdTypeEnum.IDENTIFICATION_TYPE_OVERSEA_PASSPORT);
                break;
            case "IDENTIFICATION_TYPE_MACAO_PASSPORT":
                identityInfo.setIdDocType(IdTypeEnum.IDENTIFICATION_TYPE_MACAO_PASSPORT);
                break;
            case "IDENTIFICATION_TYPE_TAIWAN_PASSPORT":
                identityInfo.setIdDocType(IdTypeEnum.IDENTIFICATION_TYPE_TAIWAN_PASSPORT);
                break;
            case "IDENTIFICATION_TYPE_FOREIGN_RESIDENT":
                identityInfo.setIdDocType(IdTypeEnum.IDENTIFICATION_TYPE_FOREIGN_RESIDENT);
                break;
            case "IDENTIFICATION_TYPE_HONGKONG_MACAO_RESIDENT":
                identityInfo.setIdDocType(IdTypeEnum.IDENTIFICATION_TYPE_HONGKONG_MACAO_RESIDENT);
                break;
            case "IDENTIFICATION_TYPE_TAIWAN_RESIDENT":
                identityInfo.setIdDocType(IdTypeEnum.IDENTIFICATION_TYPE_TAIWAN_RESIDENT);
                break;
        }
        //法定代表人说明函1、当证件持有人类型为经办人时，必须上传。其他情况，无需上传。\n" +
        //            "2、若因特殊情况，无法提供法定代表人证件时，请参照示例图打印法定代表人说明函，全部信息需打印，不支持手写商户信息，并加盖公章。\n" +
        //            "3、可上传1张图片，请填写通过图片上传APIAPI预先上传图片生成好的MediaID。
//        if(appApplyRequest.getIdHolderType().equals("SUPER")){
//            identityInfo.setAuthorizeLetterCopy()
//        }
        subjectInfo.setIdentityInfo(identityInfo);
        // 受益人
        if (identityInfo.getOwner()) {
            WxPayApplyment4SubCreateRequest.SubjectInfo.UboInfo uboInfo = new WxPayApplyment4SubCreateRequest.SubjectInfo.UboInfo();
            uboInfo.setUboIdDocName(appApplyRequest.getBeneficiaryName());
            uboInfo.setUboIdDocNumber(appApplyRequest.getBeneficiaryNo());
            uboInfo.setUboIdDocCopy(appApplyRequest.getBeneficiaryIdPictureFront());
            uboInfo.setUboIdDocCopyBack(appApplyRequest.getBeneficiaryIdPictureBack());
            uboInfo.setUboIdDocType(IdTypeEnum.IDENTIFICATION_TYPE_IDCARD);
            uboInfo.setUboPeriodBegin(appApplyRequest.getBeneficiaryIdValidityPeriodBegin());
            uboInfo.setUboPeriodEnd(appApplyRequest.getBeneficiaryIdValidityPeriodEnd());
            uboInfo.setUboIdDocAddress(appApplyRequest.getBeneficiaryAddress());
            List<WxPayApplyment4SubCreateRequest.SubjectInfo.UboInfo> list = new ArrayList<>();
            list.add(uboInfo);
            subjectInfo.setUboInfoList(list);
        }
        isvCreateBo.setSubjectInfo(subjectInfo);
        // 经营资料信息
        isvCreateBo.setCertNo(appApplyRequest.getCertNo());
        isvCreateBo.setCertType(appApplyRequest.getCertType());
        isvCreateBo.setCertName(appApplyRequest.getCertName());
        WxPayApplyment4SubCreateRequest.BusinessInfo businessInfo = new WxPayApplyment4SubCreateRequest.BusinessInfo();
        WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo salesInfo = new WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo();

        // 经营场景类型
        List<SalesScenesTypeEnum> salesScenesTypeList = new ArrayList<>();
        List<String> salesScenesTypes = Arrays.asList(appApplyRequest.getSalesScenesType().split(","));
        for (String salesScenesType : salesScenesTypes) {
            switch (salesScenesType) {
                case "SALES_SCENES_MINI_PROGRAM":
                    salesScenesTypeList.add(SalesScenesTypeEnum.SALES_SCENES_MINI_PROGRAM);
                    break;
                case "SALES_SCENES_STORE":
                    salesScenesTypeList.add(SalesScenesTypeEnum.SALES_SCENES_STORE);
                    break;
                case "SALES_SCENES_MP":
                    salesScenesTypeList.add(SalesScenesTypeEnum.SALES_SCENES_MP);
                    break;
                case "SALES_SCENES_WEB":
                    salesScenesTypeList.add(SalesScenesTypeEnum.SALES_SCENES_WEB);
                    break;
                case "SALES_SCENES_APP":
                    salesScenesTypeList.add(SalesScenesTypeEnum.SALES_SCENES_APP);
                    break;
                case "SALES_SCENES_WEWORK":
                    salesScenesTypeList.add(SalesScenesTypeEnum.SALES_SCENES_WEWORK);
                    break;
            }
        }
        salesInfo.setSalesScenesType(salesScenesTypeList);
        // 线下场景
        if (salesInfo.getSalesScenesType().contains(SalesScenesTypeEnum.SALES_SCENES_STORE)) {
            WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo.BizStoreInfo bizStoreInfo
                    = new WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo.BizStoreInfo();
            bizStoreInfo.setBizStoreName(appApplyRequest.getBizStoreName());
            bizStoreInfo.setBizAddressCode(appApplyRequest.getBizAddressCode());
            bizStoreInfo.setBizStoreAddress(appApplyRequest.getBizStoreAddress());
            // 线下场所门头照片
            List<String> storeEntrancePicList = new ArrayList<>();
            if (appApplyRequest.getTenantDoorPicture() != null) {
                storeEntrancePicList.add(appApplyRequest.getTenantDoorPicture());
            }
            bizStoreInfo.setStoreEntrancePic(storeEntrancePicList);
            // 线下场所内部照片
            List<String> indoorPicList = new ArrayList<>();
            if (appApplyRequest.getTenantIndoorPicture() != null) {
                indoorPicList.add(appApplyRequest.getTenantIndoorPicture());
            }
            bizStoreInfo.setIndoorPic(indoorPicList);
            salesInfo.setBizStoreInfo(bizStoreInfo);
        } else if (salesInfo.getSalesScenesType().contains(SalesScenesTypeEnum.SALES_SCENES_MINI_PROGRAM)) {
            // 小程序
            WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo.MiniProgramInfo miniProgramInfo
                    = new WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo.MiniProgramInfo();
            if (appApplyRequest.getMiniProgramPic() != null) {
                List<String> miniProgramPics = new ArrayList<>();
                miniProgramPics.add(appApplyRequest.getMiniProgramPic());
                miniProgramInfo.setMiniProgramPics(miniProgramPics);
            }
            // 服务商小程序APPID 商家小程序APPID 二选一
            if (!StringUtil.isEmpty(appApplyRequest.getMiniProgramSubAppid())) {
                miniProgramInfo.setMiniProgramSubAppid(appApplyRequest.getMiniProgramSubAppid());
            } else {
                miniProgramInfo.setMiniProgramAppid(appApplyRequest.getAppId() == null ? "wx1f2863eb6cdee6a1" :
                        appApplyRequest.getAppId());
            }
            salesInfo.setMiniProgramInfo(miniProgramInfo);
        }
        businessInfo.setSalesInfo(salesInfo);
        businessInfo.setMerchantShortname(appApplyRequest.getTenantShortName());
        businessInfo.setServicePhone(appApplyRequest.getServicePhone());
        isvCreateBo.setBusinessInfo(businessInfo);
        // 超级管理员信息
        WxPayApplyment4SubCreateRequest.ContactInfo contactInfo = new WxPayApplyment4SubCreateRequest.ContactInfo();
        contactInfo.setContactName(appApplyRequest.getSuperAdminName());
        // 用于接收微信支付的重要管理信息及日常操作验证码 为空默认管理员的手机
        contactInfo.setMobilePhone(appApplyRequest.getContactPhone());
        // 用于接收微信支付的开户邮件及日常业务通知 为空默认管理员邮箱
        contactInfo.setContactEmail(appApplyRequest.getContactEmail());

        // 如果为1、主体为“个体工商户/企业/政府机关/事业单位/社会组织”，可选择：LEGAL：经营者/法人，SUPER：经办人
        // 。（经办人：经商户授权办理微信支付业务的人员）。
        //枚举值：LEGAL：经营者/法人、SUPER：经办人
        contactInfo.setContactType(appApplyRequest.getContactType() == null ? null : appApplyRequest.getContactType());
        if (contactInfo.getContactType() != null && contactInfo.getContactType().equals("SUPER")) {
            // 如类型为LEGAL则以下不需要传参
            contactInfo.setContactIdDocType(appApplyRequest.getContactIdDocType() == null ? "IDENTIFICATION_TYPE_IDCARD"
                    : appApplyRequest.getContactIdDocType());
            contactInfo.setContactIdNumber(appApplyRequest.getSuperAdminId());
            contactInfo.setContactIdDocCopy(appApplyRequest.getSuperAdminIdPictureFront());
            contactInfo.setContactIdDocCopyBack(appApplyRequest.getSuperAdminIdPictureBack());
            contactInfo.setContactPeriodBegin(appApplyRequest.getSuperAdminValidityPeriodBegin());
            contactInfo.setContactPeriodEnd(appApplyRequest.getSuperAdminValidityPeriodEnd());
            contactInfo.setBusinessAuthorizationLetter(appApplyRequest.getOtherCert());
        }

        isvCreateBo.setContactInfo(contactInfo);
        // 结算规则
        WxPayApplyment4SubCreateRequest.SettlementInfo settlementInfo =
                new WxPayApplyment4SubCreateRequest.SettlementInfo();
        // todo 按照餐饮去送微信
        settlementInfo.setSettlementId("716");
        settlementInfo.setQualificationType(appApplyRequest.getBusinessScope());
        isvCreateBo.setSettlementInfo(settlementInfo);
        // 补充材料
        if (appApplyRequest.getQualificationPicture() != null) {
            WxPayApplyment4SubCreateRequest.AdditionInfo additionInfo =
                    new WxPayApplyment4SubCreateRequest.AdditionInfo();
            List<String> businessAdditionPics = new ArrayList<>();
            businessAdditionPics.add(appApplyRequest.getQualificationPicture());
            additionInfo.setBusinessAdditionPics(businessAdditionPics);
            isvCreateBo.setAdditionInfo(additionInfo);
        }
        log.info("结束转换参数appApplyRequest{}", isvCreateBo);
        return isvCreateBo;
    }
}
