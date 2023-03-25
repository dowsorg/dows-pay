package org.dows.pay.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.ChannelBizModel;

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
    private String certNo;
    // 营业执照类型
    @ApiModelProperty("营业执照类型")
    private String certType;
    // 法人微信号
    @ApiModelProperty("法人微信号")
    private String legalPersonalWechat;

    /*********************************微信创建小程序END*************************/

}
