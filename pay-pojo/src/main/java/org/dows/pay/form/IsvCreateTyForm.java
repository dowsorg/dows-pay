package org.dows.pay.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.binarywang.wxpay.bean.applyment.WxPayApplyment4SubCreateRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.annotation.WeixinApiField;
import org.dows.pay.bo.ApplymentsBo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "IsvCreateForm 表单对象", description = " 支付宝/微信ISV代创建小程序")
@Data
public class IsvCreateTyForm implements BizForm {

    @ApiModelProperty("平台应用ID")
    private String appId;

    // 通道code
    @ApiModelProperty("通道code")
    private String channel;

    // 账号
    @ApiModelProperty("账号")
    private String account;


    // 应用名称
    @ApiModelProperty("申请应用名称")
    private String appName;


    // 营业执照
    @ApiModelProperty("营业执照")
    private String certName;

    // 联系人
    @ApiModelProperty("联系人")
    private String contactName;

    // 联系电话
    @ApiModelProperty("联系电话")
    private String contactPhone;

    // 法人名
    @ApiModelProperty("法人名")
    private String legalPersonalName;

    // 外部申请单号
    @ApiModelProperty("外部申请单号")
    private String outOrderNo;

    /********************************微信创建小程序START**********************************/
    @NotNull(message = "超级管理员信息不能为空")
    @ApiModelProperty("超级管理员信息")
    private WxPayApplyment4SubCreateRequest.ContactInfo contactInfo;
    @NotNull(message = "主体资料不能为空")
    @ApiModelProperty("主体资料信息")
    private WxPayApplyment4SubCreateRequest.SubjectInfo subjectInfo;
    @NotNull(message = "经营资料不能为空")
    @ApiModelProperty("经营资料信息")
    private WxPayApplyment4SubCreateRequest.BusinessInfo businessInfo;
    @NotNull(message = "结算银行账户不能为空")
    @ApiModelProperty("结算银行账户信息")
    private WxPayApplyment4SubCreateRequest.SettlementInfo settlementInfo;
    @NotNull(message = "结算银行账户不能为空")
    @ApiModelProperty("结算银行账户信息")
    private WxPayApplyment4SubCreateRequest.BankAccountInfo bankAccountInfo;
    @ApiModelProperty("补充材料信息")
    private WxPayApplyment4SubCreateRequest.AdditionInfo additionInfo;
    /*********************************微信创建小程序END*************************/
    /*********************************新增门店参数封装START*********************/
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
    /***********************************新增门店参数封装END*************************/
}
