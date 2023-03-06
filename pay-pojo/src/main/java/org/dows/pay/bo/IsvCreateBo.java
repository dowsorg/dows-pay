package org.dows.pay.bo;

import lombok.Data;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.annotation.AlipayApiField;
import org.dows.pay.api.annotation.WeixinApiField;

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
    @WeixinApiField(name = "wxaccount")
    @AlipayApiField(name = "alipay_account")
    private String account;


    // 应用名称
    @WeixinApiField(name = "")
    @AlipayApiField(name = "app_name")
    private String appName;


    // 营业执照
    @WeixinApiField(name = "")
    @AlipayApiField(name = "cert_name")
    private String certName;

    // 联系人
    @WeixinApiField(name = "")
    @AlipayApiField(name = "contact_name")
    private String contactName;

    // 联系电话
    @WeixinApiField(name = "")
    @AlipayApiField(name = "contact_phone")
    private String contactPhone;

    // 法人名
    @WeixinApiField(name = "")
    @AlipayApiField(name = "legal_personal_name")
    private String legalPersonalName;

    // 外部申请单号
    @WeixinApiField(name = "")
    @AlipayApiField(name = "out_order_no")
    private String outOrderNo;

}
