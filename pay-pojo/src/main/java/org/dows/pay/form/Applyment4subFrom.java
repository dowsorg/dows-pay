package org.dows.pay.form;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class Applyment4subFrom {

    @ApiModelProperty("超级管理员信息")
    private ContactInfo contactInfo;
    @ApiModelProperty("主体资料")
    private SubjectInfo subjectInfo;
    @ApiModelProperty("经营资料")
    private BusinessInfo businessInfo;
    @ApiModelProperty("结算规则")
    private SettlementInfo settlementInfo;
    @ApiModelProperty("结算银行账户")
    private BankAccountInfo bankAccountInfo;

    @Data
    static class ContactInfo {

        @ApiModelProperty("超级管理员类型 LEGAL：经营者/法人 SUPER：经办人")
        private String contactType;
        @ApiModelProperty("超级管理员姓名")
        private String contactName;
        @ApiModelProperty("联系手机")
        private String mobilePhone;
        @ApiModelProperty("联系邮箱")
        private String contactEmail;

        //contactType = SUPER：经办人 填写
        @ApiModelProperty("超级管理员证件类型") // IDENTIFICATION_TYPE_IDCARD: 中国大陆居民-身份证 .....看文档和有很多
        private String contactIdDocType;
        @ApiModelProperty("超级管理员身份证件号码")
        private String contactIdNumber;
        @ApiModelProperty("超级管理员证件正面照片")
        private String contactIdDocCopy;
        @ApiModelProperty("业务办理授权函")
        private String businessAuthorizationLetter;
        @ApiModelProperty("超级管理员证件反面照片")
        private String contactIdDocCopyBack;
        @ApiModelProperty("超级管理员证件有效期开始时间")
        private String contactPeriodBegin;
        @ApiModelProperty("超级管理员证件有效期结束时间")
        private String contactPeriodEnd;

    }


    @Data
    static class SubjectInfo {
        @ApiModelProperty("主体类型") //SUBJECT_TYPE_INDIVIDUAL：营业执照上的主体类型一般为个体户、个体工商户、个体经营；SUBJECT_TYPE_ENTERPRISE：营业执照上的主体类型一般为有限公司、有限责任公司；
        private String subjectType;
        @ApiModelProperty("营业执照 主体为个体户/企业，必填")
        private BusinessLicenseInfo businessLicenseInfo;
        @ApiModelProperty("主体为政府机关/事业单位/其他组织时，必填")
        private CertificateInfo certificateInfo;
        @ApiModelProperty("单位证明函照片") // 主体类型为政府机关、事业单位选传 --> 主体为个体户、企业、其他组织等，不需要上传本字段
        private String certificateLetterCopy;
        @ApiModelProperty("经营者/法人身份证件 必填")
        private IdentityInfo IdentityInfo;
        @ApiModelProperty("最终受益人信息列表(UBO)仅企业需要填写")
        private List<Object> uboInfoList;


        @Data
        static class BusinessLicenseInfo {
            @ApiModelProperty("营业执照照片")
            private String licenseCopy;
            @ApiModelProperty("注册号/统一社会信用代码")
            private String licenseNumber;
            @ApiModelProperty("商户名称")
            private String merchantName;
            @ApiModelProperty("个体户经营者/法人姓名")
            private String legalPerson;
            //以下选填
            @ApiModelProperty("建议填写营业执照的注册地址")
            private String licenseAddress;
            @ApiModelProperty("建议填写营业执照的有效期限开始时间")
            private String periodBegin;
            @ApiModelProperty("建议填写营业执照的有效期限结束时间")
            private String periodEnd;

        }


        @Data
        static class CertificateInfo {
            @ApiModelProperty("登记证书照片")
            private String certCopy;
            @ApiModelProperty("登记证书类型") // CERTIFICATE_TYPE_2388 看文档 有很多类型
            private String certType;
            @ApiModelProperty("证书号")
            private String certNumber;
            @ApiModelProperty("商户名称")
            private String merchantName;
            @ApiModelProperty("注册地址")
            private String companyAddress;
            @ApiModelProperty("法定代表人")
            private String legalPerson;
            @ApiModelProperty("有效期限开始日期")
            private String periodBegin;
            @ApiModelProperty("有效期限结束日期")
            private String periodEnd;

        }

        @Data
        static class IdentityInfo {
            @ApiModelProperty("证件持有人类型 ") //主体类型为企业/个体户/社会组织时，默认为经营者/法人，不需要上传该字段
            private String idHolderType;
            @ApiModelProperty("证件类型") //IDENTIFICATION_TYPE_IDCARD: 中国大陆居民-身份证
            private String idDocType;
            @ApiModelProperty("法定代表人说明函")
            private String authorizeLetterCopy;
            @ApiModelProperty("身份证信息") //当证件持有人类型为经营者/法人且证件类型为“身份证”时填写
            private IdCardInfo idCardInfo;
            @ApiModelProperty("其他类型证件信息") //当证件持有人类型为经营者/法人且证件类型不为“身份证”时填写。其他情况，无需上传
            private IdDocInfo idDocInfo;

            private boolean owner = false;


            @Data
            static class IdCardInfo {
                //以下 必填
                @ApiModelProperty("身份证人像面照片")
                private String idCardCopy;
                @ApiModelProperty("身份证国徽面照片")
                private String idCardNational;
                @ApiModelProperty("身份证姓名")
                private String idCardName;
                @ApiModelProperty("身份证号码")
                private String idCardNumber;
                @ApiModelProperty("身份证居住地址") //选填
                private String idCardAddress;
                @ApiModelProperty("身份证有效期开始时间")
                private String cardPeriodBegin;
                @ApiModelProperty("身份证有效期结束时间")
                private String cardPeriodEnd;
            }

            @Data
            static class IdDocInfo {
                @ApiModelProperty("证件正面照片")
                private String idDocCopy;
                @ApiModelProperty("证件反面照片")
                private String idDocCopyBack;
                @ApiModelProperty("证件姓名")
                private String idDocName;
                @ApiModelProperty("证件号码")
                private String idDocNumber;
                @ApiModelProperty("证件居住地址")
                private String idCardAddress;
                @ApiModelProperty("证件有效期开始时间")
                private String docPeriodBegin;
                @ApiModelProperty("证件有效期结束时间")
                private String docPeriodEnd;
            }
        }
    }

    @Data
    static class BusinessInfo{
        @ApiModelProperty("商户简称")
        private String merchantShortname;
        @ApiModelProperty("客服电话")
        private String servicePhone;
        @ApiModelProperty("经营场景")
        private SalesInfo salesInfo;

        @Data
        static class SalesInfo {
            @ApiModelProperty("经营场景类型")
            private List<String> salesScenesType; //SALES_SCENES_MINI_PROGRAM：小程序
            @ApiModelProperty("线下场所场景")
            private BizStoreInfo bizStoreInfo;
            @ApiModelProperty("小程序场景")
            private MiniProgramInfo miniProgramInfo;

            @Data
            static class MiniProgramInfo {
                @ApiModelProperty("服务商小程序AppID")
                private String miniProgramAppid;
                @ApiModelProperty("商家小程序AppID")
                private String miniProgramSubAppid;
                @ApiModelProperty("小程序截图")
                private String miniProgramPics;
            }

            @Data
            static class BizStoreInfo{
                @ApiModelProperty("线下场所名称")
                private String bizStoreName;
                @ApiModelProperty("线下场所省市编码")
                private String bizAddressCode;
                @ApiModelProperty("线下场所地址")
                private String bizStoreAddress;
                @ApiModelProperty("线下场所门头照片")
                private String storeEntrancePic;
                @ApiModelProperty("线下场所内部照片")
                private List<String> indoorPic;
                @ApiModelProperty("线下场所对应的商家AppID 选填")
                private String bizSubAppid;

            }
        }

    }
    @Data
    static class SettlementInfo {

        @ApiModelProperty("入驻结算规则ID") //看文档 很多
        private String settlementId;
        @ApiModelProperty("所属行业") //看文档很多
        private String qualificationType;
    }

    @Data
    static class BankAccountInfo {
        @ApiModelProperty("账户类型") //BANK_ACCOUNT_TYPE_CORPORATE：对公银行账户 BANK_ACCOUNT_TYPE_PERSONAL：经营者个人银行卡
        private String bankAccountType;
        @ApiModelProperty("开户名称")
        private String accountName;
        @ApiModelProperty("开户银行")
        private String accountBank;
        @ApiModelProperty("开户银行省市编码")
        private String bankAddressCode;
        @ApiModelProperty("银行账号")
        private String accountNumber;
    }
}



