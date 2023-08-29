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
public class SetWxBaseInfoForm extends SetWxBaseInfoExtForm  implements BizForm{
//    @ApiModelProperty("平台应用ID")
//    private String appId;

//    @ApiModelProperty("商家应用ID")
//    private String merchantAppId;

//    // 通道code
//    @ApiModelProperty("通道code")
//    private String channel;

    // 账号
    @ApiModelProperty("账号")
    private String account;

//    // 应用名称
//    @ApiModelProperty("申请应用名称")
//    private String appName;

    // 小程序应用英文名称
    @ApiModelProperty("小程序应用英文名称")
    private String appEnglishName;

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
    @ApiModelProperty(name = "小程序介绍")
    private String signature;
//
//    /**
//     * 小程序介绍
//     */
//    @ApiModelProperty(name = "小程序描述")
//    private String appDesc;
//
//    /**
//     * 小程序logo图标
//     */
//    @ApiModelProperty(name = "小程序logo图标")
//    private String appLogo;
//    /**
//     * 小程序客服电话，
//     */
//    @ApiModelProperty(name = "小程序客服电话，")
//    private String servicePhone;
//
//    /**
//     * 小程序客服电话，
//     */
//    @ApiModelProperty(name = "小程序客服邮箱，")
//    private String serviceEmail;

//    /**
//     * 新小程序前台类目，格式为 第一个一级类目_第一个二级类目;第二个一级类目_第二个二级类目_第二个三级类目，详细类目可以通过 https://docs.open.alipay.com/api_49/alipay.open.mini.category.query
//     * 接口查询mini_category_list。
//     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填。可通过https://opendocs.alipay.com/mini/03l21r查询当前小程序信息
//     * 注意：个人开发者不得使用企业类目。
//     */
//    @ApiModelProperty(name = "mini_category_ids")
//    private String miniCategoryIds;

    /**
     * 身份证照片 mediaid. 个人号必填
     */
    @ApiModelProperty(name = "id_card")
    private String idCard;

    /**
     * 组织机构代码证或营业执照 mediaid，组织号必填.
     */
    @ApiModelProperty(name = "license")
    private String certPicture;

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
        private String code;
    }

}
