package org.dows.pay.api.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.binarywang.wxpay.bean.applyment.enums.IdTypeEnum;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
public class AppApplyRequest implements Serializable {

    private static final long serialVersionUID = 910895302256785608L;
    @JsonIgnore
    private Long id;

    @ApiModelProperty("申请类型--ALL 支付宝：ALIPAY  微信：WEIXIN")
    private String applyType;

    @ApiModelProperty("门店id")
    private String storeId;

    @ApiModelProperty("商家小程序appid")
    private String merchantAppid;

    @ApiModelProperty("应用类型")
    private String categId;

    @ApiModelProperty("应用或小程序申请订单编号(全局唯一)")
    private String applyOrderNo;

    @ApiModelProperty("应用ID(申请审核通过后回填)")
    private String appId;

    @ApiModelProperty("应用名称")
    private String appName;

    @ApiModelProperty("申请类型(不需要填)--ALL 支付宝：ALIPAY  微信：WEIXIN")
    private String platform;

    @ApiModelProperty("第三方平台申请单号（第三放平台审核通过后回填）")
    private String platformOrderNo;

    @ApiModelProperty("第三方平台关联应用ID（第三放平台审核通过后回填）")
    private String platformAppId;

    @ApiModelProperty("第三方平台关联应用名(可以统一用appName)")
    private String platformAppName;

    @ApiModelProperty("申请人")
    private String applicant;

    @ApiModelProperty("支付宝登录账号 商家登录支付宝的邮箱帐号或手机号。（1）默认只支持企业账号类型；（2）将is_individual设置为true，支持个体工商户类型的账号（同时也兼容企业账号）（3）将is_individual设置为true且上传营业执照照片，将同时对具备个体工商户营业执照的商家个人账号认证成为个体工商户账号（同时也兼容企业账号、个体工商户账号）")
    private String platformAccount;

    @ApiModelProperty("超级管理员类型 ：LEGAL：经营者/法人、SUPER：经办人 默认LEGAL")
    private String contactType;
    @ApiModelProperty("超级管理员姓名")
    private String superAdminName;

    @ApiModelProperty("超级管理员证件类型 IDENTIFICATION_TYPE_MACAO_PASSPORT：中国澳门居民-来往内地通行证\n" +
            "IDENTIFICATION_TYPE_TAIWAN_PASSPORT：中国台湾居民-来往大陆通行证\n" +
            "IDENTIFICATION_TYPE_FOREIGN_RESIDENT：外国人居留证\n" +
            "IDENTIFICATION_TYPE_HONGKONG_MACAO_RESIDENT：港澳居民证\n" +
            "IDENTIFICATION_TYPE_TAIWAN_RESIDENT：台湾居民证   默认IDENTIFICATION_TYPE_IDCARD")
    private String contactIdDocType;
    @ApiModelProperty("超级管理员身份证件号")
    private String superAdminId;
    @ApiModelProperty("超级管理员身份证正面")//不同类型的证件照片存储字段
    private String superAdminIdPictureFront;
    @ApiModelProperty("超级管理员身份证反面")
    private String superAdminIdPictureBack;
    @ApiModelProperty("超级管理员身份证有效期开始时间")
    private String superAdminValidityPeriodBegin;
    @ApiModelProperty("超级管理员身份证有效期结束时间")
    private String superAdminValidityPeriodEnd;
    @ApiModelProperty("其他证明(为经办人时此处用作 业务办理授权函)")
    private String otherCert;
    @ApiModelProperty("联系人手机(用于接收微信支付的重要管理信息及日常操作验证码) 默认为超级管理员手机号")
    private String contactPhone;
    @ApiModelProperty("联系人邮箱(用于接收微信支付的开户邮件及日常业务通知) 默认为超级管理员邮箱")
    private String contactEmail;
    @ApiModelProperty("主体类型 SUBJECT_TYPE_INDIVIDUAL（个体户）：营业执照上的主体类型一般为个体户、个体工商户、个体经营；\n" +
            "SUBJECT_TYPE_ENTERPRISE（企业）：营业执照上的主体类型一般为有限公司、有限责任公司；\n" +
            "SUBJECT_TYPE_GOVERNMENT （政府机关）：包括各级、各类政府机关，如机关党委、税务、民政、人社、工商、商务、市监等；\n" +
            "SUBJECT_TYPE_INSTITUTIONS（事业单位）：包括国内各类事业单位，如：医疗、教育、学校等单位；\n" +
            "SUBJECT_TYPE_OTHERS（社会组织）： 包括社会团体、民办非企业、基金会、基层群众性自治组织、农村集体经济组织等组织。" +
            "默认SUBJECT_TYPE_ENTERPRISE")
    private String subjectType;
    @ApiModelProperty("营业执照照片")
    private String certPicture;
    @ApiModelProperty("营业执照编号注册号/统一社会信用代码")
    private String certNo;
    @ApiModelProperty("商户名称")
    private String tenantName;
    @ApiModelProperty("个体户经营者/法人姓名")
    private String legalName;
    @ApiModelProperty("店铺地址(注册地址)")
    private String tenantAddress;
    // 上一版certValidityPeriod
    @ApiModelProperty("营业执照证照有效期开始时间")
    private String certValidityPeriodBegin;
    @ApiModelProperty("营业执照证照有效期结束时间")
    private String certValidityPeriodEnd;

    @ApiModelProperty("证件持有人类型 1. 主体类型为政府机关、事业单位时选传：\n" +
            "（1）若上传的是法人证件，则不需要上传该字段\n" +
            "（2）若因特殊情况，无法提供法人证件时，可上传经办人。 （经办人：经商户授权办理微信支付业务的人员，授权范围包括但不限于签约，入驻过程需完成账户验证）。\n" +
            "2. 主体类型为企业、个体户、社会组织时，默认为经营者/法人，不需要上传该字段。\n" +
            "LEGAL：法人\n" +
            "SUPER：经办人\n" +
            "示例值：LEGAL 默认 LEGAL")
    private String idHolderType;

    @ApiModelProperty("证件类型 1、当证件持有人类型为法人时，填写。其他情况，无需上传。\n" +
            "2、个体户/企业/事业单位/社会组织：可选择任一证件类型，政府机关仅支持中国大陆居民-身份证类型。\n" +
            "IDENTIFICATION_TYPE_IDCARD：中国大陆居民-身份证\n" +
            "IDENTIFICATION_TYPE_OVERSEA_PASSPORT：其他国家或地区居民-护照\n" +
            "IDENTIFICATION_TYPE_HONGKONG_PASSPORT：中国香港居民-来往内地通行证\n" +
            "IDENTIFICATION_TYPE_MACAO_PASSPORT：中国澳门居民-来往内地通行证\n" +
            "IDENTIFICATION_TYPE_TAIWAN_PASSPORT：中国台湾居民-来往大陆通行证\n" +
            "IDENTIFICATION_TYPE_FOREIGN_RESIDENT：外国人居留证\n" +
            "IDENTIFICATION_TYPE_HONGKONG_MACAO_RESIDENT：港澳居民证\n" +
            "IDENTIFICATION_TYPE_TAIWAN_RESIDENT：台湾居民证\n" +
            "示例值：IDENTIFICATION_TYPE_IDCARD 默认IDENTIFICATION_TYPE_IDCARD")
    private String idDocType;

    @ApiModelProperty("法定代表人说明函1、当证件持有人类型为经办人时，必须上传。其他情况，无需上传。\n" +
            "2、若因特殊情况，无法提供法定代表人证件时，请参照示例图打印法定代表人说明函，全部信息需打印，不支持手写商户信息，并加盖公章。\n" +
            "3、可上传1张图片，请填写通过图片上传APIAPI预先上传图片生成好的MediaID。")
    private String authorizeLetterCopy;
    @ApiModelProperty("上传个体经营者/法人证件正面照")
    private String proprietorIdPictureFront;
    @ApiModelProperty("上传个体经营者/法人证件正面照")
    private String proprietorIdPictureBack;
    // 上一版proprietorIdValidityPeriod
    @ApiModelProperty("身份证有效期-开始")
    private String proprietorIdValidityPeriodBegin;
    @ApiModelProperty("身份证有效期-结束")
    private String proprietorIdValidityPeriodEnd;
    @ApiModelProperty("身份证姓名")
    private String idCardName;
    @ApiModelProperty("身份证件号码")
    private String proprietorId;
    @ApiModelProperty("身份证件地址")
    private String proprietorIdAddress;
    @ApiModelProperty("经营者/法人是否受益人 true是")
    private String owner;
//    @ApiModelProperty("受益所有人证件类型 后端已默认")//枚举？
//    private String beneficiaryIdType;
//    @ApiModelProperty("受益所有人身份证正面")//不同类型的证件照片存储字段
//    private String beneficiaryIdPictureFront;
//    @ApiModelProperty("受益所有人身份证反面")
//    private String beneficiaryIdPictureBack;
    // 上一版beneficiaryIdValidityPeriod
//    @ApiModelProperty("受益所有人证件有效期-开始")
//    private String beneficiaryIdValidityPeriodBegin;
//    @ApiModelProperty("受益所有人证件有效期-结束")
//    private String beneficiaryIdValidityPeriodEnd;
//    @ApiModelProperty("受益所有人姓名")
//    private String beneficiaryName;
//    @ApiModelProperty("受益所有人证件号")//枚举？身份证
//    private String beneficiaryNo;
//    @ApiModelProperty("收益人地址")
//    private String beneficiaryAddress;

    @ApiModelProperty("最终受益人信息列表")
    private List<uboInfoListRequest> uboInfoList;

    @ApiModelProperty("商户简称")
    private String tenantShortName;
    @ApiModelProperty("客服电话 将在交易记录中向买家展示，请确保电话畅通以便平台回拨确认")
    private String servicePhone;

    @ApiModelProperty("经营类型，实际上是array类型，此处SALES_SCENES_STORE：线下场所\n" +
            "SALES_SCENES_MP：公众号\n" +
            "SALES_SCENES_MINI_PROGRAM：小程序\n" +
            "SALES_SCENES_WEB：互联网网站\n" +
            "SALES_SCENES_APP：APP\n" +
            "SALES_SCENES_WEWORK：企业微信 默认SALES_SCENES_MINI_PROGRAM")
    private String salesScenesType;
    @ApiModelProperty("线下场所名称")
    private String bizStoreName;
    @ApiModelProperty("线下场所省市编码")
    private String bizAddressCode;
    @ApiModelProperty("线下场所地址")
    private String bizStoreAddress;
    @ApiModelProperty("线下场所商户门头照片")
    private String tenantDoorPicture;
    @ApiModelProperty("线下场所店铺内景照片")
    private String tenantIndoorPicture;
    @ApiModelProperty("小程序截图 选填")
    private String miniProgramPic;
    @ApiModelProperty("商家小程序APPID 选填")
    private String miniProgramSubAppid;
    @ApiModelProperty("账户类型 1、若主体为企业/政府机关/事业单位/社会组织，可填写：对公银行账户。\n" +
            "2、若主体为个体户，可选择填写：对公银行账户或经营者个人银行卡。\n" +
            "BANK_ACCOUNT_TYPE_CORPORATE：对公银行账户\n" +
            "BANK_ACCOUNT_TYPE_PERSONAL：经营者个人银行卡\n" +
            "默认：BANK_ACCOUNT_TYPE_CORPORATE")
    private String proprietorAccountType;

    @ApiModelProperty("开户名称")
    private String bankAccountName;

    @ApiModelProperty("开户银行")
    private String bankName;

    @ApiModelProperty("开户行名称")
    private String bankFullName;

    @ApiModelProperty("开户行省市编码")
    private String bankPostalNo;

    @ApiModelProperty("银行账号")
    private String bankNo;

    @ApiModelProperty("法人微信号")
    private String legalWechatNo;

    @ApiModelProperty("注册地区")//是否需要新建表
    private String registrationArea;

    @ApiModelProperty("营业执照名称")
    private String certName;

    @ApiModelProperty("联系人")
    private String contactName;

    @ApiModelProperty("企业类型")
    private String enterpriseType;

    @ApiModelProperty("租户Id")
    private String tenantId;

    @ApiModelProperty("经营范围")
    private String businessScope;

    @ApiModelProperty("经营类目")//是否需要新建表
    private String businessCategory;

    @ApiModelProperty("经营场景")//是否需要新建表
    private String businessScenario;

    @ApiModelProperty("受益所有人微信")
    private String beneficiaryWechatNo;

    @ApiModelProperty("受益所有人电话")
    private String beneficiaryPhone;

    @ApiModelProperty("受益所有人邮箱")
    private String beneficiaryEmail;

    @ApiModelProperty("资质照片")
    private String qualificationPicture;

    @ApiModelProperty("小程序头像")
    private String appPicture;

    @ApiModelProperty("小程序介绍")
    private String appDesc;

    /*****************************新增修改字段*****************************/

    // 以下后端默认
    @ApiModelProperty("营业执照类型 默认2")
    private String certType;

    @ApiModelProperty("平台商户号")
    private String merchantNo;
    @ApiModelProperty("申请状态 0未申请 1-申请中 2-已申请 3.申请失败")
    private String appStatus;

    private String baseMsg;
}
