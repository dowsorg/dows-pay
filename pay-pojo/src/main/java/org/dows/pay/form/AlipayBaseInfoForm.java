package org.dows.pay.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.annotation.AlipayApiField;

@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "AlipayBaseInfoForm 表单对象", description = " 支付宝小程序基本信息")
@Data
public class AlipayBaseInfoForm implements BizForm {

    /**
     * 小程序名称。长度限制 3~30 个字符，仅支持包含中文、数字、英文、下划线、+、-。
     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填。可通过alipay.open.mini.baseinfo.query查询当前小程序信息.
     */
    @AlipayApiField(name = "app_name")
    private String appName;

    /**
     * 小程序应用英文名称。长度限制 3~30 个字符，仅支持包含中文、数字、英文、下划线、+、-。
     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填。可通过alipay.open.mini.baseinfo.query查询当前小程序信息.
     */
    @AlipayApiField(name = "app_english_name")
    private String appEnglishName;

    /**
     * 小程序简介，一句话描述小程序功能，长度限制 10~32个字符。
     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填。可通过alipay.open.mini.baseinfo.query查询当前小程序信息.
     */
    @AlipayApiField(name = "app_slogan")
    private String appSlogan;
    /**
     * 小程序logo图标
     */
    @AlipayApiField(name = "app_logo")
    private String appLogo;

    /**
     * 小程序描述，长度限制 20~400 个字符。
     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填。可通过https://opendocs.alipay.com/mini/03l21r查询当前小程序信息
     */
    @AlipayApiField(name = "app_desc")
    private String appDesc;

    /**
     * 小程序客服电话，
     */
    @AlipayApiField(name = "service_phone")
    private String servicePhone;

    /**
     * 小程序客服电话，
     */
    @AlipayApiField(name = "service_email")
    private String serviceEmail;

    /**
     * 新小程序前台类目，格式为 第一个一级类目_第一个二级类目;第二个一级类目_第二个二级类目_第二个三级类目，详细类目可以通过，
     */
    @AlipayApiField(name = "mini_category_ids")
    private String miniCategoryIds;

    // 通道code
    @ApiModelProperty("通道code")
    private String channel;

    @ApiModelProperty("平台应用ID")
    private String appId;

    @ApiModelProperty("商家应用ID")
    private String merchantAppId;
}
