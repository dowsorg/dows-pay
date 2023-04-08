package org.dows.pay.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.ChannelBizModel;
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
public class IsvCreateForm implements BizForm {

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
    // 企业代码
    @ApiModelProperty("企业代码")
    @NotBlank(message = "企业代码不能为空")
    private String certNo;
    // 营业执照类型
    @NotBlank(message = "营业执照类型不能为空")
    @ApiModelProperty("营业执照类型")
    private String certType;
    // 法人微信号
    @ApiModelProperty("法人微信号")
    private String legalPersonalWechat;
    @ApiModelProperty("营业执照图片")
    private String licensePic;
    @ApiModelProperty("法人身份证正面")
    private String legalPicFront;
    @ApiModelProperty("法人身份证反面")
    private String legalPicBack;
    @NotBlank(message = "业务申请编号不能为空")
    @ApiModelProperty("业务申请编号")
    private String outRequestNo;
    @NotBlank(message = "主体类型不能为空")
    @ApiModelProperty("主体类型")
    /**
     *数据域参数说明：
     *2401：小微商户，指无营业执照的个人商家。
     *2500：个人卖家，指无营业执照，已持续从事电子商务经营活动满6个月，且期间经营收入累计超过20万元的个人商家。（若选择该主体，请在“补充说明”填写相关描述）。
     *4：个体工商户，营业执照上的主体类型一般为个体户、个体工商户、个体经营。
     *2：企业，营业执照上的主体类型一般为有限公司、有限责任公司。
     *3：事业单位，包括国内各类事业单位，如：医疗、教育、学校等单位。
     *2502：政府机关，包括各级、各类政府机关，如机关党委、税务、民政、人社、工商、商务、市监等。
     *1708：社会组织，包括社会团体、民办非企业、基金会、基层群众性自治组织、农村集体经济组织等组织。
     **/
    private String organizationType;
    @NotNull(message = "是否金融机构不能为空")
    @ApiModelProperty("是否金融机构")
    private Boolean financeInstitution;
    @ApiModelProperty( "营业执照/登记证书信息")
    @NotNull(message = "营业执照/登记证书信息不能为")
    private ApplymentsBo.BusinessLicenseInfo businessLicenseInfo;
    @ApiModelProperty( "金融机构许可证信息")
    private ApplymentsBo.FinanceInstitutionInfo financeInstitutionInfo;
    @ApiModelProperty(  "证件持有人类型")
    private String idHolderType;
    @NotBlank(message = "经营者/法人证件类型不能为空")
    @ApiModelProperty(  "经营者/法人证件类型")
    private String idDocType;
    @ApiModelProperty(  "法定代表人说明函")
    private String authorizeLetterCopy;
    @ApiModelProperty(  "经营者/法人身份证信息")
    private ApplymentsBo.IdCardInfo idCardInfo;
    @ApiModelProperty( "经营者/法人其他类型证件信息")
    private ApplymentsBo.IdDocInfo idDocInfo;
    @ApiModelProperty( "经营者/法人是否为受益人")
    @NotNull(message = "经营者/法人是否为受益人不能为空")
    private Boolean owner;
    @ApiModelProperty( "最终受益人信息列表")
    private List<ApplymentsBo.UboInfo> uboInfoList;
    @NotNull(message = "结算账户信息不能为空")
    @ApiModelProperty( "结算账户信息")
    private ApplymentsBo.AccountInfo accountInfo;
    @NotNull(message = "超级管理员信息不能为空")
    @ApiModelProperty( "超级管理员信息")
    private ApplymentsBo.ContactInfo contactInfo;
    @NotNull(message = "店铺信息不能为空")
    @ApiModelProperty( "店铺信息")
    private ApplymentsBo.SalesSceneInfo salesSceneInfo;
    @ApiModelProperty( "结算规则")
    private ApplymentsBo.SettlementInfo settlementInfo;
    @NotBlank(message = "商户简称不能为空")
    @ApiModelProperty( "商户简称")
    private String merchantShortname;
    @ApiModelProperty( "特殊资质")
    private String qualifications;
    @ApiModelProperty( "补充材料")
    private String businessAdditionPics;
    @ApiModelProperty( "补充说明")
    private String businessAdditionDesc;
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
