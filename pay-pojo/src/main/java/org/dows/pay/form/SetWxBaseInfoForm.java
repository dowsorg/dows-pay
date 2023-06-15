package org.dows.pay.form;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.bo.WxFastMaCategoryBo;

import java.util.List;

/**
 * @Author longhui.shi
 * @Date 2023/6/5 14:47
 * @PackageName:org.dows.pay.form
 * @ClassName: SetWxBaseInfoForm
 * @Description: TODO
 * @Version 1.0
 */
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "WxBaseInfoForm 表单对象", description = " 支付宝/微信小程序基本信息")
@Data
public class SetWxBaseInfoForm implements BizForm{
    @ApiModelProperty("平台应用ID")
    private String appId;

    @ApiModelProperty("商家应用ID")
    private String merchantAppId;

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

    /**
     * 一级类目ID.
     */
    @ApiModelProperty("一级类目ID")
    private Integer first;
    @ApiModelProperty("一级类目名称")
    private String firstName;
    /**
     * 二级类目ID.
     */
    @ApiModelProperty("二级类目ID")
    private Integer second;
    @ApiModelProperty("二级类目名称")
    private String secondName;

    @ApiModelProperty("资质信息")
    private String certicate;

    /**
     * 资质信息.
     */
    @ApiModelProperty("资质信息后端用于转换")
    private List<WxFastMaCategoryBo.Certificate> certicates;

    @Data
    public static class Certificate {
        @ApiModelProperty("key")
        private String key;
        @ApiModelProperty("value")
        private String value;
    }

}
