package org.dows.pay.biz;

import com.alipay.service.schema.util.StringUtil;
import com.github.binarywang.wxpay.bean.applyment.WxPayApplyment4SubCreateRequest;
import com.github.binarywang.wxpay.bean.applyment.enums.BankAccountTypeEnum;
import com.github.binarywang.wxpay.bean.applyment.enums.IdTypeEnum;
import com.github.binarywang.wxpay.bean.applyment.enums.SalesScenesTypeEnum;
import com.github.binarywang.wxpay.bean.applyment.enums.SubjectTypeEnum;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsRequest;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.open.bean.result.WxOpenResult;
import org.dows.app.api.mini.request.AppApplyRequest;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayApi;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.request.PayIsvRequest;
import org.dows.pay.bo.IsvCreateBo;
import org.dows.pay.bo.IsvCreateTyBo;
import org.dows.pay.weixin.WeixinIsvHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ISV 代理商业务
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class payBiz implements PayApi {
    private final WeixinIsvHandler weixinIsvHandler;

    @Override
    public Response<Boolean> isvApply(AppApplyRequest appApplyRequest) {
        PayRequest payRequest = new PayIsvRequest();
        IsvCreateBo isvCreateBo = convert(appApplyRequest);
        if("ty".equals(appApplyRequest.getApplyType())){
            IsvCreateTyBo isvCreateTyBo = convertTy(appApplyRequest);
            payRequest.setBizModel(isvCreateTyBo);
        }else{
            payRequest.setBizModel(isvCreateBo);
        }

        Boolean boolen = false;
        //创建支付小程序
        WxOpenResult wxOpenResult = weixinIsvHandler.fastRegisterApp(payRequest);
        //创建支付小程序
        ApplymentsResult isvMini = weixinIsvHandler.createIsvMini(payRequest);

        if(wxOpenResult.isSuccess()&& !StringUtil.isEmpty(isvMini.getApplymentId())){
            boolen = true;
        }
        return Response.ok(boolen);
    }
    public IsvCreateBo convert(AppApplyRequest appApplyRequest){
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
        //营业执照信息
        isvCreateBo.setCertNo(appApplyRequest.getCertNo());
        isvCreateBo.setCertType("2");
        ApplymentsRequest.BusinessLicenseInfo businessLicenseInfo = new ApplymentsRequest.BusinessLicenseInfo();
        businessLicenseInfo.setBusinessLicenseCopy(appApplyRequest.getCertPicture());
        businessLicenseInfo.setBusinessLicenseNumber(appApplyRequest.getCertNo());
        businessLicenseInfo.setCertType("CERTIFICATE_TYPE_2388");
        businessLicenseInfo.setMerchantName(appApplyRequest.getTenantShortName());
        businessLicenseInfo.setLegalPerson(appApplyRequest.getLegalName());
        businessLicenseInfo.setBusinessTime(appApplyRequest.getCertValidityPeriod());
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
        contactInfo.setContactType("LEGAL");
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
        uboInfo.setUboIdDocPeriodBegin(appApplyRequest.getBeneficiaryIdValidityPeriod());
        uboInfo.setUboIdDocPeriodEnd(appApplyRequest.getProprietorIdValidityPeriod());
        uboInfo.setUboIdDocAddress(appApplyRequest.getProprietorIdAddress());
        List<ApplymentsRequest.UboInfo> list = new ArrayList<>();
        list.add(uboInfo);
        isvCreateBo.setUboInfoList(list);
        //资质证明
        isvCreateBo.setQualifications(appApplyRequest.getQualificationPicture());
        return  isvCreateBo;
    }
    public IsvCreateTyBo convertTy(AppApplyRequest appApplyRequest){
        IsvCreateTyBo isvCreateBo = new IsvCreateTyBo();
        isvCreateBo.setAccount(appApplyRequest.getPlatformAccount());
        //账户信息
        WxPayApplyment4SubCreateRequest.BankAccountInfo accountInfo = new WxPayApplyment4SubCreateRequest.BankAccountInfo();
        accountInfo.setAccountBank(appApplyRequest.getBankName());
        accountInfo.setAccountName(appApplyRequest.getBankAccountName());
        accountInfo.setAccountNumber(appApplyRequest.getBankNo());
        accountInfo.setBankAccountType(BankAccountTypeEnum.BANK_ACCOUNT_TYPE_CORPORATE);
        isvCreateBo.setBankAccountInfo(accountInfo);
        //主体资料
        isvCreateBo.setLegalPersonalName(appApplyRequest.getLegalName());
        isvCreateBo.setLegalPersonalWechat(appApplyRequest.getLegalWechatNo());
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
        businessLicenseInfo.setPeriodBegin(appApplyRequest.getCertValidityPeriod());
        businessLicenseInfo.setPeriodEnd(appApplyRequest.getCertValidityPeriod());
        subjectInfo.setBusinessLicenseInfo(businessLicenseInfo);
        WxPayApplyment4SubCreateRequest.SubjectInfo.IdentityInfo identityInfo
                = new WxPayApplyment4SubCreateRequest.SubjectInfo.IdentityInfo();
        WxPayApplyment4SubCreateRequest.SubjectInfo.IdentityInfo.IdCardInfo idCardInfo
                = new WxPayApplyment4SubCreateRequest.SubjectInfo.IdentityInfo.IdCardInfo();
        //经营信息
        idCardInfo.setIdCardCopy(appApplyRequest.getProprietorIdPictureFront());
        idCardInfo.setIdCardNational(appApplyRequest.getProprietorIdPictureBack());
        idCardInfo.setIdCardName(appApplyRequest.getLegalName());
        idCardInfo.setIdCardNumber(appApplyRequest.getProprietorId());
        identityInfo.setIdCardInfo(idCardInfo);
        identityInfo.setOwner(true);
        identityInfo.setIdDocType(IdTypeEnum.IDENTIFICATION_TYPE_IDCARD);
        subjectInfo.setIdentityInfo(identityInfo);
        //受益人
        WxPayApplyment4SubCreateRequest.SubjectInfo.UboInfo uboInfo = new WxPayApplyment4SubCreateRequest.SubjectInfo.UboInfo();
        uboInfo.setUboIdDocName(appApplyRequest.getBeneficiaryName());
        uboInfo.setUboIdDocNumber(appApplyRequest.getBeneficiary());
        uboInfo.setUboIdDocCopy(appApplyRequest.getBeneficiaryIdPictureFront());
        uboInfo.setUboIdDocCopyBack(appApplyRequest.getBeneficiaryIdPictureBack());
        uboInfo.setUboIdDocType(IdTypeEnum.IDENTIFICATION_TYPE_IDCARD);
        List<WxPayApplyment4SubCreateRequest.SubjectInfo.UboInfo> list = new ArrayList<>();
        list.add(uboInfo);
        subjectInfo.setUboInfoList(list);
        isvCreateBo.setSubjectInfo(subjectInfo);

        //经营资料信息
        isvCreateBo.setCertNo(appApplyRequest.getCertNo());
        isvCreateBo.setCertType("2");
        WxPayApplyment4SubCreateRequest.BusinessInfo businessInfo = new WxPayApplyment4SubCreateRequest.BusinessInfo();
        WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo salesInfo = new WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo();
        WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo.MiniProgramInfo miniProgramInfo
                = new WxPayApplyment4SubCreateRequest.BusinessInfo.SalesInfo.MiniProgramInfo();
        List<String> miniProgramPics = new ArrayList<>();
        miniProgramPics.add(appApplyRequest.getAppPicture());
        miniProgramInfo.setMiniProgramPics(miniProgramPics);
        miniProgramInfo.setMiniProgramAppid(appApplyRequest.getAppId());
        salesInfo.setMiniProgramInfo(miniProgramInfo);
        List<SalesScenesTypeEnum> salesScenesType = new ArrayList<>();
        salesScenesType.add(SalesScenesTypeEnum.SALES_SCENES_MINI_PROGRAM);
        salesInfo.setSalesScenesType(salesScenesType);
        businessInfo.setSalesInfo(salesInfo);
        businessInfo.setMerchantShortname(appApplyRequest.getTenantShortName());
        businessInfo.setServicePhone(appApplyRequest.getContactPhone());
        isvCreateBo.setBusinessInfo(businessInfo);

        //超级管理员信息
        WxPayApplyment4SubCreateRequest.ContactInfo contactInfo = new WxPayApplyment4SubCreateRequest.ContactInfo();
        contactInfo.setContactName(appApplyRequest.getSuperAdminName());
        contactInfo.setMobilePhone(appApplyRequest.getSuperAdminPhone());
        contactInfo.setContactEmail(appApplyRequest.getSuperAdminEmail());
        contactInfo.setContactIdDocType("IDENTIFICATION_TYPE_IDCARD");
        contactInfo.setContactIdNumber(appApplyRequest.getSuperAdminId());
        contactInfo.setContactType("LEGAL");
        contactInfo.setContactIdDocCopy(appApplyRequest.getProprietorIdPictureFront());
        contactInfo.setContactIdDocCopyBack(appApplyRequest.getProprietorIdPictureBack());

        //结算规则
        WxPayApplyment4SubCreateRequest.SettlementInfo settlementInfo =
                new WxPayApplyment4SubCreateRequest.SettlementInfo();
        //todo 按照餐饮去送微信
        settlementInfo.setSettlementId("716");
        settlementInfo.setActivitiesRate("0");
        settlementInfo.setQualificationType(appApplyRequest.getBusinessScope());
        isvCreateBo.setSettlementInfo(settlementInfo);
        return  isvCreateBo;
    }
}
