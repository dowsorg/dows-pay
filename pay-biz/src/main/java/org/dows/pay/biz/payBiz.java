package org.dows.pay.biz;

import cn.hutool.core.util.IdUtil;
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
import me.chanjar.weixin.open.bean.result.WxOpenResult;
import org.dows.app.api.mini.request.AppApplyRequest;
import org.dows.app.api.mini.request.PayApplyStatusReq;
import org.dows.app.api.mini.request.WechatMiniUploadRequest;
import org.dows.framework.api.Response;
import org.dows.framework.api.exceptions.BizException;
import org.dows.pay.alipay.AlipayIsvHandler;
import org.dows.pay.api.PayApi;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.request.MiniUploadRequest;
import org.dows.pay.api.request.MiniUploadTemplateIdBO;
import org.dows.pay.api.request.PayIsvRequest;
import org.dows.pay.bo.IsvCreateBo;
import org.dows.pay.bo.IsvCreateTyBo;
import org.dows.pay.boot.PayClientConfig;
import org.dows.pay.entity.PayApply;
import org.dows.pay.service.PayApplyService;
import org.dows.pay.weixin.WeixinIsvHandler;
import org.dows.pay.weixin.WeixinMiniHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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
                    return Response.ok(true, "申请微信小程序成功");
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
        Long payApplyId = payApplyService.createPayApply(appApplyRequest.getMerchantNo());
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
                WxPayApplymentCreateResult isvMini = weixinIsvHandler.createIsvTyMini(payRequest);
                log.info("生成WxPayApplymentCreateResult参数{}", isvMini);
                // 回填申请单号
                payApplyService.updateApplyNoById(payApplyId, isvMini.getApplymentId());
                if (!StringUtil.isEmpty(isvMini.getApplymentId())) {
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

    private MiniUploadRequest convertUploadReq(WechatMiniUploadRequest request) {
        MiniUploadRequest miniUploadRequest = new MiniUploadRequest();
        String appId = Optional.ofNullable(payClientConfig.getClientConfigs().get(1).getAppId()).orElse("wxdb8634feb22a5ab9");
        miniUploadRequest.setAppId(appId);
        miniUploadRequest.setTemplateId(request.getTemplateId());
        miniUploadRequest.setUserVersion("V1.0");
        miniUploadRequest.setUserDesc("normal");
        miniUploadRequest.setExtJsonObject(getExtJsonObject(request.getAppId()));
        return miniUploadRequest;
    }

    private String getExtJsonObject(String appId) {
        String str = "{\"extEnable\":true,\"extAppid\":\"" +
                appId +
                "\",\"directCommit\":false,\"ext\":{\"name\":\"wechat\",\"attr\":{\"host\":\"open.weixin.qq.com\",\"users\":[\"user_1\"]}}}";
        return str;
    }

    @Override
    public Response queryPayApplyStatus(PayApplyStatusReq res) {
        PayApply payApply = payApplyService.getByMerchantNoAndType(res.getMerchantNo(), res.getApplyType());
        return Optional.ofNullable(payApply).map(p -> {
            Response response = queryApplymentStatus(payApply.getApplyNo());
            ApplymentsStatusResult result = (ApplymentsStatusResult) response.getData();
            if (!Objects.nonNull(payApply.getAppUrl())) {
                payApply.setAppUrl(result.getSignUrl());
            }
            payApply.setApplymentState(result.getApplymentState());
            if (Objects.equals("APPLYMENT_STATE_FINISHED", payApply.getApplymentState())) {
                payApply.setChecked(true);
            }
            payApply.setUpdateTime(new Date());
            payApplyService.updateById(payApply);
            return response;
        }).orElseThrow(() -> new BizException(String.format("payApply query is null and merchantNo:[%s]", res.getMerchantNo())));
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
        contactInfo.setMobilePhone(appApplyRequest.getSuperAdminPhone());
        contactInfo.setContactEmail(appApplyRequest.getSuperAdminEmail());
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
        uboInfo.setUboIdDocNumber(appApplyRequest.getBeneficiary());
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
        accountInfo.setBankAccountType(BankAccountTypeEnum.BANK_ACCOUNT_TYPE_CORPORATE);
        accountInfo.setBankAddressCode(appApplyRequest.getBankPostalNo());
        isvCreateBo.setBankAccountInfo(accountInfo);
        // 主体资料
        isvCreateBo.setLegalPersonalName(appApplyRequest.getLegalName());
        isvCreateBo.setLegalPersonalWechat(appApplyRequest.getLegalWechatNo());
        isvCreateBo.setContactPhone(appApplyRequest.getContactPhone());
        WxPayApplyment4SubCreateRequest.SubjectInfo subjectInfo = new WxPayApplyment4SubCreateRequest.SubjectInfo();
        subjectInfo.setFinanceInstitution(false);
        subjectInfo.setSubjectType(SubjectTypeEnum.SUBJECT_TYPE_ENTERPRISE);
        WxPayApplyment4SubCreateRequest.SubjectInfo.BusinessLicenseInfo businessLicenseInfo
                = new WxPayApplyment4SubCreateRequest.SubjectInfo.BusinessLicenseInfo();
        businessLicenseInfo.setLicenseCopy(appApplyRequest.getCertPicture());
        businessLicenseInfo.setLicenseAddress(appApplyRequest.getTenantAddress());
        businessLicenseInfo.setLicenseNumber(appApplyRequest.getCertNo());
        businessLicenseInfo.setMerchantName(appApplyRequest.getTenantShortName());
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
        idCardInfo.setIdCardName(appApplyRequest.getLegalName());
        idCardInfo.setIdCardNumber(appApplyRequest.getProprietorId());
        idCardInfo.setCardPeriodBegin(appApplyRequest.getProprietorIdValidityPeriodBegin());
        idCardInfo.setCardPeriodEnd(appApplyRequest.getProprietorIdValidityPeriodEnd());
        idCardInfo.setIdCardAddress(appApplyRequest.getProprietorIdAddress());
        identityInfo.setIdCardInfo(idCardInfo);
        identityInfo.setOwner(true);
        identityInfo.setIdDocType(IdTypeEnum.IDENTIFICATION_TYPE_IDCARD);
        subjectInfo.setIdentityInfo(identityInfo);
        // 受益人
        WxPayApplyment4SubCreateRequest.SubjectInfo.UboInfo uboInfo = new WxPayApplyment4SubCreateRequest.SubjectInfo.UboInfo();
        uboInfo.setUboIdDocName(appApplyRequest.getBeneficiaryName());
        uboInfo.setUboIdDocNumber(appApplyRequest.getBeneficiary());
        uboInfo.setUboIdDocCopy(appApplyRequest.getBeneficiaryIdPictureFront());
        uboInfo.setUboIdDocCopyBack(appApplyRequest.getBeneficiaryIdPictureBack());
        uboInfo.setUboIdDocType(IdTypeEnum.IDENTIFICATION_TYPE_IDCARD);
        uboInfo.setUboPeriodBegin(appApplyRequest.getBeneficiaryIdValidityPeriodBegin());
        uboInfo.setUboPeriodEnd(appApplyRequest.getBeneficiaryIdValidityPeriodEnd());
        uboInfo.setUboIdDocAddress(appApplyRequest.getBeneficiaryAddress());
        List<WxPayApplyment4SubCreateRequest.SubjectInfo.UboInfo> list = new ArrayList<>();
        list.add(uboInfo);
        subjectInfo.setUboInfoList(list);
        isvCreateBo.setSubjectInfo(subjectInfo);

        // 经营资料信息
        isvCreateBo.setCertNo(appApplyRequest.getCertNo());
        isvCreateBo.setCertType(appApplyRequest.getCertType());
//        isvCreateBo.setCertName(appApplyRequest.getBankAccountName());
        isvCreateBo.setCertName(appApplyRequest.getCertName());
        WxPayApplyment4SubCreateRequest.BusinessInfo businessInfo = new WxPayApplyment4SubCreateRequest.BusinessInfo();
        WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo salesInfo = new WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo();
        WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo.MiniProgramInfo miniProgramInfo
                = new WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo.MiniProgramInfo();
        List<String> miniProgramPics = new ArrayList<>();
        miniProgramPics.add(appApplyRequest.getAppPicture());
        miniProgramInfo.setMiniProgramPics(miniProgramPics);
        miniProgramInfo.setMiniProgramAppid(appApplyRequest.getAppId() == null ? "wx1f2863eb6cdee6a1" :
                appApplyRequest.getAppId());
        salesInfo.setMiniProgramInfo(miniProgramInfo);
        List<SalesScenesTypeEnum> salesScenesType = new ArrayList<>();
        salesScenesType.add(SalesScenesTypeEnum.SALES_SCENES_MINI_PROGRAM);
        salesInfo.setSalesScenesType(salesScenesType);
        businessInfo.setSalesInfo(salesInfo);
        businessInfo.setMerchantShortname(appApplyRequest.getTenantShortName());
        businessInfo.setServicePhone(appApplyRequest.getContactPhone());
        isvCreateBo.setBusinessInfo(businessInfo);

        // 超级管理员信息
        WxPayApplyment4SubCreateRequest.ContactInfo contactInfo = new WxPayApplyment4SubCreateRequest.ContactInfo();
        contactInfo.setContactName(appApplyRequest.getSuperAdminName());
        contactInfo.setMobilePhone(appApplyRequest.getSuperAdminPhone());
        contactInfo.setContactEmail(appApplyRequest.getSuperAdminEmail());

        // 如果为1、主体为“个体工商户/企业/政府机关/事业单位/社会组织”，可选择：LEGAL：经营者/法人，SUPER：经办人
        // 。（经办人：经商户授权办理微信支付业务的人员）。
        //枚举值：LEGAL：经营者/法人、SUPER：经办人
        contactInfo.setContactType(appApplyRequest.getContactType());
        // 如类型为LEGAL则以下不需要传参
//        contactInfo.setContactIdDocType("IDENTIFICATION_TYPE_IDCARD");
//        contactInfo.setContactIdNumber(appApplyRequest.getSuperAdminId());
//        contactInfo.setContactIdDocCopy(appApplyRequest.getProprietorIdPictureFront());
//        contactInfo.setContactIdDocCopyBack(appApplyRequest.getProprietorIdPictureBack());
//        contactInfo.setContactPeriodBegin(appApplyRequest.getProprietorIdValidityPeriod());
//        contactInfo.setContactPeriodEnd(appApplyRequest.getProprietorIdValidityPeriod());
        contactInfo.setBusinessAuthorizationLetter(appApplyRequest.getOtherCert());
        isvCreateBo.setContactInfo(contactInfo);
        // 结算规则
        WxPayApplyment4SubCreateRequest.SettlementInfo settlementInfo =
                new WxPayApplyment4SubCreateRequest.SettlementInfo();
        // todo 按照餐饮去送微信
        settlementInfo.setSettlementId("716");
//        settlementInfo.setActivitiesRate("0");
        settlementInfo.setQualificationType(appApplyRequest.getBusinessScope());
        isvCreateBo.setSettlementInfo(settlementInfo);

        // 补充材料
        WxPayApplyment4SubCreateRequest.AdditionInfo additionInfo =
                new WxPayApplyment4SubCreateRequest.AdditionInfo();
        List<String> businessAdditionPics = new ArrayList<>();
        businessAdditionPics.add(appApplyRequest.getQualificationPicture());
        additionInfo.setBusinessAdditionPics(businessAdditionPics);
        isvCreateBo.setAdditionInfo(additionInfo);
        log.info("结束转换参数appApplyRequest{}", isvCreateBo);
        return isvCreateBo;
    }
}
