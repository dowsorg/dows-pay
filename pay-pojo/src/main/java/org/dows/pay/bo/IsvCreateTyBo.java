package org.dows.pay.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.binarywang.wxpay.bean.applyment.WxPayApplyment4SubCreateRequest;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.annotation.AlipayApiField;
import org.dows.pay.api.annotation.WeixinApiField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * "alipayAccount":"keweijr@163.com ",
 * "appName":"aaa",
 * "certName":"上海好金网络科技有限公司",
 * "certNo":"13000000202007220438",
 * "contactName":"王冠军",
 * "contactPhone":"",
 * "legalPersonalName":"王冠军",
 * "outOrderNo":"202324353454545"
 * <p>
 * 支付宝/微信/其他等共用
 */
@Data
public class IsvCreateTyBo implements ChannelBizModel {

    // 账号
    @WeixinApiField(name = "wx_account")
    @AlipayApiField(name = "alipay_account")
    private String account;


    // 应用名称
    @WeixinApiField(name = "app_name")
    @AlipayApiField(name = "app_name")
    private String appName;


    // 营业执照
    @WeixinApiField(name = "name")
    @AlipayApiField(name = "cert_name")
    private String certName;
    // 营业执照类型
    @WeixinApiField(name = "code_type")
    @AlipayApiField(name = "code_type")
    private String certType;

    // 联系人
    @WeixinApiField(name = "contact_name")
    @AlipayApiField(name = "contact_name")
    private String contactName;

    // 联系电话
    @WeixinApiField(name = "component_phone")
    @AlipayApiField(name = "contact_phone")
    private String contactPhone;

    // 法人名
    @WeixinApiField(name = "legal_persona_name")
    @AlipayApiField(name = "legal_personal_name")
    private String legalPersonalName;

    // 外部申请单号
    @WeixinApiField(name = "business_code")
    @AlipayApiField(name = "out_order_no")
    private String outOrderNo;

    // 法人微信号
    @WeixinApiField(name = "legal_persona_wechat")
    @AlipayApiField(name = "legal_persona_wechat")
    private String legalPersonalWechat;

    // 证件类型
    @WeixinApiField(name = "code")
    @AlipayApiField(name = "cert_no")
    private String certNo;

    /***************微信申请参数封装START*****************/
    @WeixinApiField(name = "contact_info")
    private WxPayApplyment4SubCreateRequest.ContactInfo contactInfo;
    @WeixinApiField(name = "subject_info")
    private WxPayApplyment4SubCreateRequest.SubjectInfo subjectInfo;
    @WeixinApiField(name = "business_info")
    private WxPayApplyment4SubCreateRequest.BusinessInfo businessInfo;
    @WeixinApiField(name = "settlement_info")
    private WxPayApplyment4SubCreateRequest.SettlementInfo settlementInfo;
    @WeixinApiField(name = "bank_account_info")
    private WxPayApplyment4SubCreateRequest.BankAccountInfo bankAccountInfo;
    @WeixinApiField(name = "addition_info")
    private WxPayApplyment4SubCreateRequest.AdditionInfo additionInfo;
    /***************微信申请参数封装END*****************/
    /***************新增门店参数封装START*****************/
    @ApiModelProperty("业态ID")
    private String ecoId;
    @ApiModelProperty("业态")
    private String ecoBiz;
    @ApiModelProperty("父ID(pid空时为总店)")
    private String storePid;
    @ApiModelProperty("门店ID标识")
    private String storeId;
    @ApiModelProperty("门店名称 ")
    private String name;
    @ApiModelProperty("门面照")
    private String profile;
    @ApiModelProperty("国家 ")
    private String country;
    @ApiModelProperty("门店区域")
    private String district;
    @ApiModelProperty("门店类型 1正餐 2快餐")
    private Integer storeType;
    @ApiModelProperty("门店类型 1正餐 2快餐")
    private String storeTypeShow;
    @ApiModelProperty("门店模式 1直营 2加盟")
    private Integer storePattern;
    @ApiModelProperty("门店模式 1直营 2加盟")
    private String storePatternShow;
    @ApiModelProperty("所属品牌")
    private Integer storeBrand;
    @ApiModelProperty("所属品牌")
    private String storeBrandShow;
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    @ApiModelProperty("开业日期")
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date openDate;
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    @ApiModelProperty("开业日期")
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private String openDateShow;
    @ApiModelProperty("营业状态 1休息 2营业中")
    private Integer state;
    @ApiModelProperty("营业状态 1休息 2营业中")
    private String stateShow;
    @ApiModelProperty("账号名")
    private String accountName;
    @ApiModelProperty("门店地址")
    private String address;
    @ApiModelProperty("分成比例")
    private Double commissionRatio;
    @ApiModelProperty("联系人")
    private String contacts;
    /***************新增门店参数封装END*****************/

    // 证件类型
    @WeixinApiField(name = "authorization_code")
    private String authorizationCode;

}
