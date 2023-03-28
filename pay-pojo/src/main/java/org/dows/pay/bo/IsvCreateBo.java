package org.dows.pay.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.annotation.AlipayApiField;
import org.dows.pay.api.annotation.WeixinApiField;

import javax.validation.constraints.NotBlank;
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
public class IsvCreateBo implements ChannelBizModel {

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
    @WeixinApiField(name = "out_order_no")
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
    @WeixinApiField(name = "license_pic")
    private String licensePic;
    @WeixinApiField(name = "legal_pic_front")
    private String legalPicFront;
    @WeixinApiField(name = "legal_pic_back")
    private String legalPicBack;
    @WeixinApiField(name = "out_request_no")
    private String outRequestNo;
    @WeixinApiField(name = "organization_type")
    private String organizationType;
    @WeixinApiField(name = "finance_institution")
    private Boolean financeInstitution;
    @WeixinApiField(name = "business_license_info")
    private ApplymentsBo.BusinessLicenseInfo businessLicenseInfo;
    @WeixinApiField(name = "finance_institution_info")
    private ApplymentsBo.FinanceInstitutionInfo financeInstitutionInfo;
    @WeixinApiField(name =  "id_holder_type")
    private String idHolderType;
    @WeixinApiField(name =  "id_doc_type")
    private String idDocType;
    @WeixinApiField(name =  "authorize_letter_copy")
    private String authorizeLetterCopy;
    @WeixinApiField(name =  "id_card_info")
    private ApplymentsBo.IdCardInfo idCardInfo;
    @WeixinApiField(name = "id_doc_info")
    private ApplymentsBo.IdDocInfo idDocInfo;
    @WeixinApiField(name = "owner")
    private Boolean owner;
    @WeixinApiField(name = "ubo_info_list")
    private List<ApplymentsBo.UboInfo> uboInfoList;
    @WeixinApiField(name = "account_info")
    private ApplymentsBo.AccountInfo accountInfo;
    @WeixinApiField(name = "contact_info")
    private ApplymentsBo.ContactInfo contactInfo;
    @WeixinApiField(name = "sales_scene_info")
    private ApplymentsBo.SalesSceneInfo salesSceneInfo;
    @WeixinApiField(name = "settlement_info")
    private ApplymentsBo.SettlementInfo settlementInfo;
    @WeixinApiField(name = "merchant_shortname")
    private String merchantShortname;
    @WeixinApiField(name = "qualifications")
    private String qualifications;
    @WeixinApiField(name = "business_addition_pics")
    private String businessAdditionPics;
    @WeixinApiField(name = "business_addition_desc")
    private String businessAdditionDesc;
    /***************微信申请参数封装END*****************/


}
