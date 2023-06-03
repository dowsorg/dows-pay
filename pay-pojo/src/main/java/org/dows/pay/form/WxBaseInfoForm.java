package org.dows.pay.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.annotation.WeixinApiField;


@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "WxBaseInfoForm 表单对象", description = " 支付宝/微信小程序基本信息")
@Data
public class WxBaseInfoForm implements BizForm {
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

   /**
     * 昵称.
     */
    @ApiModelProperty(name = "nick_name")
    private String nickName;

    /**
     * 身份证照片 mediaid. 个人号必填
     */
    @ApiModelProperty(name = "id_card")
    private String idCard;

    /**
     * 组织机构代码证或营业执照 mediaid，组织号必填.
     */
    @ApiModelProperty(name = "license")
    private String license;

    /**
     * 其他证明材料 mediaid.
     */
    @ApiModelProperty(name = "naming_other_stuff_1")
    private String namingOtherStuff1;

    /**
     * 其他证明材料 mediaid.
     */
    @ApiModelProperty(name = "naming_other_stuff_2")
    private String namingOtherStuff2;

    /**
     * 申请id
     */
    @ApiModelProperty(name = "audit_id")
    private String auditId;
    /**
     * 小程序介绍
    */
    @ApiModelProperty(name = "signature")
    private String signature;


    /**
     * 小程序头像
     */
    @ApiModelProperty(name = "head_img_media_id")
    private String headImgMediaId;

    /**
     * x1 .
     */
    @ApiModelProperty(name = "x1")
    private float x1;

    /**
     * y1 .
     */
    @ApiModelProperty(name = "y1")
    private float y1;

    /**
     * x2
     */
    @ApiModelProperty(name = "x2")
    private float x2;
    /**
     * y2
     */
    @ApiModelProperty(name = "y2")
    private float y2;



}
