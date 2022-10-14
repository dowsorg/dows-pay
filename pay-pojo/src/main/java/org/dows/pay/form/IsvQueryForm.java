package org.dows.pay.form;

import lombok.Data;
import org.dows.pay.api.BizForm;

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
public class IsvQueryForm implements BizForm {

    private String appId;

    // 通道code
    private String channel;

    // 账号
    private String account;


    // 应用名称
    private String appName;


    // 营业执照
    private String certName;

    // 联系人
    private String contactName;

    // 联系电话
    private String contactPhone;

    // 法人名
    private String legalPersonalName;

    // 外部申请单号
    private String outOrderNo;

}
