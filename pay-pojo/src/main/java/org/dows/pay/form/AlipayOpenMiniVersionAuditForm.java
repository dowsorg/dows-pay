package org.dows.pay.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.annotation.AlipayApiField;

@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = " 表单对象", description = " 支付宝小程序审核信息")
@Data
public class AlipayOpenMiniVersionAuditForm implements BizForm {
    /**
     * 小程序客服邮箱，如果不填默认采用当前小程序的应用客服邮箱，小程序客服电话和邮箱至少输入一个。如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。
     * 注意：2021年7月1日后，该字段将逐步灰度为可选字段，请按可选开发。
     */
    @AlipayApiField(name = "service_email")
    private String serviceEmail;

    /**
     * 小程序版本描述，30-500个字符。
     */
    @AlipayApiField(name = "version_desc")
    private String versionDesc;

    /**
     * 小程序备注，小程序备注最多500字符。
     */
    @AlipayApiField(name = "memo")
    private String memo;

    /**
     * 小程序服务区域类型，支持：
     * GLOBAL-全球
     * CHINA-中国
     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填。
     * LOCATION-指定区域
     */
    @AlipayApiField(name = "region_type")
    private String regionType;
    /**
     * 省市区信息。当region_type为LOCATION或传入city_code时，province_code不能为空；填写area_code时，province_code和city_code不能为空。只填province_code则全选该省；填写province_code和city_code则全选该市，以此类推。省市区code参见https://gw.alipayobjects.com/os/bmw-prod/0aab0319-13de-42b9-85cf-13877a5f78ed.xlsx
     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填。
     */
    @AlipayApiField(name = "service_region_info")
    private AlipayOpenMiniVersionAuditRegionForm serviceRegionInfo;
    /**
     * 小程序第一张应用截图，模板实例化的小程序可不传应用截图。
     * 截图大小不能超过 4MB，最大宽度 2160px，最大高度 3840px。图片格式仅支持 png,jpg,PNG,JPG 格式。小程序截图数量最小为2，最大为5。
     */
    @AlipayApiField(name = "first_screen_shot")
    private String firstScreenShot;
    /**
     * 小程序第二张应用截图，模板实例化的小程序可不传应用截图。
     * 截图大小不能超过 4MB，最大宽度 2160px，最大高度3840px。图片格式仅支持 png,jpg,PNG,JPG 格式。小程序截图数量最小为2，最大为5
     */
    @AlipayApiField(name = "second_screen_shot")
    private String secondScreenShot;
    /**
     * 小程序第三张应用截图，模板实例化的小程序可不传应用截图。
     * 截图大小不能超过 4MB，最大宽度 2160px，最大高度 3840px。图片格式仅支持 png,jpg,PNG,JPG 格式。小程序截图数量最小为2，最大为5。
     */
    @AlipayApiField(name = "third_screen_shot")
    private String thirdScreenShot;
    /**
     * 小程序第四张应用截图，模板实例化的小程序可不传应用截图。
     * 截图大小不能超过 4MB，最大宽度 2160px，最大高度3840px。图片格式仅支持 png,jpg,PNG,JPG 格式。小程序截图数量最小为2，最大为5。
     */
    @AlipayApiField(name = "fourth_screen_shot")
    private String fourthScreenShot;
    /**
     *
     */
    @AlipayApiField(name = "fifth_screen_shot")
    private String fifthScreenShot;
    /**
     * 营业执照证件号，部分小程序类目需要提交，可通过https://opendocs.alipay.com/mini/03l8c8 查询类目是否需要上传营业执照信息。参照https://opendocs.alipay.com/mini/operation/material 要求填写营业执照信息。
     * 如果选择的类目不需要该信息，则可不填。如果选择的类目需要该信息，如果商户之前在平台上传过该信息，也允许不填
     */
    @AlipayApiField(name = "license_no")
    private String licenseNo;
    /**
     * 新小程序前台类目，格式为 第一个一级类目_第一个二级类目;第二个一级类目_第二个二级类目_第二个三级类目，详细类目可以通过 https://docs.open.alipay.com/api_49/alipay.open.mini.category.query
     * 接口查询mini_category_list。
     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填。可通过https://opendocs.alipay.com/mini/03l21r查询当前小程序信息
     * 注意：个人开发者不得使用企业类目。
     */
    @AlipayApiField(name = "mini_category_ids")
    private String miniCategoryIds;
    /**
     * 营业执照名称，部分小程序类目需要提交，可通过https://opendocs.alipay.com/mini/03l8c8 查询类目是否需要上传营业执照信息。参照https://opendocs.alipay.com/mini/operation/material 要求填写营业执照信息。
     * 如果选择的类目不需要该信息，则可不填。如果选择的类目需要该信息，如果商户之前在平台上传过该信息，也允许不填
     */
    @AlipayApiField(name = "license_name")
    private String licenseName;
    /**
     * 第一张营业执照照片，不能超过 4MB，最大宽度 2160 px，最大高度 3840 px。图片格式仅支持 png,jpg,PNG,JPG 格式。
     * 部分小程序类目需要提交，可通过https://opendocs.alipay.com/mini/03l8c8 查询类目是否需要上传营业执照信息。参照https://opendocs.alipay.com/mini/operation/material 要求填写营业执照信息。
     * 如果选择的类目不需要该信息，则可不填。如果选择的类目需要该信息，如果商户之前在平台上传过该信息，也允许不填
     */
    @AlipayApiField(name = "first_license_pic")
    private String firstLicensePic;
    /**
     * 第二张营业执照照片，不能超过 4MB，最大宽度 2160 px，最大高度 3840 px。图片格式仅支持 png,jpg,PNG,JPG 格式。
     * 部分小程序类目需要提交，可通过https://opendocs.alipay.com/mini/03l8c8 查询类目是否需要上传营业执照信息。参照https://opendocs.alipay.com/mini/operation/material 要求填写营业执照信息。
     * 如果选择的类目不需要该信息，则可不填。如果选择的类目需要该信息，如果商户之前在平台上传过该信息，也允许不填
     */
    @AlipayApiField(name = "second_license_pic")
    private String secondLicensePic;
    /**
     * 第三张营业执照照片，不能超过 4MB，最大宽度 2160 px，最大高度 3840 px。图片格式仅支持 png,jpg,PNG,JPG 格式。
     * 部分小程序类目需要提交，可通过https://opendocs.alipay.com/mini/03l8c8 查询类目是否需要上传营业执照信息。参照https://opendocs.alipay.com/mini/operation/material 要求填写营业执照信息。
     * 如果选择的类目不需要该信息，则可不填。如果选择的类目需要该信息，如果商户之前在平台上传过该信息，也允许不填
     */
    @AlipayApiField(name = "third_license_pic")
    private String thirdLicensePic;
    /**
     * 第四张营业执照照片，不能超过 4MB，最大宽度 2160 px，最大高度 3840 px。图片格式仅支持 png,jpg,PNG,JPG 格式。
     * 部分小程序类目需要提交，可通过https://opendocs.alipay.com/mini/03l8c8 查询类目是否需要上传营业执照信息。参照https://opendocs.alipay.com/mini/operation/material 要求填写营业执照信息。
     * 如果选择的类目不需要该信息，则可不填。如果选择的类目需要该信息，如果商户之前在平台上传过该信息，也允许不填
     */
    @AlipayApiField(name = "fourth_license_pic")
    private String fourthLicensePic;
    /**
     * 第五张营业执照照片，不能超过 4MB，最大宽度 2160 px，最大高度 3840 px。图片格式仅支持 png,jpg,PNG,JPG 格式。
     * 部分小程序类目需要提交，可通过https://opendocs.alipay.com/mini/03l8c8 查询类目是否需要上传营业执照信息。参照https://opendocs.alipay.com/mini/operation/material 要求填写营业执照信息。
     * 如果选择的类目不需要该信息，则可不填。如果选择的类目需要该信息，如果商户之前在平台上传过该信息，也允许不填
     */
    @AlipayApiField(name = "fifth_license_pic")
    private String fifthLicensePic;
    /**
     * 营业执照有效期，格式为 yyyy-MM-dd，9999-12-31表示长期有效。
     * 部分小程序类目需要提交，可通过https://opendocs.alipay.com/mini/03l8c8 查询类目是否需要上传营业执照信息。参照https://opendocs.alipay.com/mini/operation/material 要求填写营业执照信息。
     * 如果选择的类目不需要该信息，则可不填。如果选择的类目需要该信息，如果商户之前在平台上传过该信息，也允许不填
     */
    @AlipayApiField(name = "license_valid_date")
    private String licenseValidDate;
    /**
     * 门头照，不能超过 4MB，最大宽度 2160 px，最大高度 3840 px。图片格式仅支持 png,jpg,PNG,JPG 格式。
     * 部分小程序类目需要提交，可通过https://opendocs.alipay.com/mini/03l8c8 查询类目是否需要上传门头照信息。参照https://opendocs.alipay.com/mini/operation/material 要求填写门头照信息。
     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填。
     */
    @AlipayApiField(name = "out_door_pic")
    private String outDoorPic;
    /**
     * 小程序版本号，请选择开发版本执行提交审核操作。
     */
    @AlipayApiField(name = "app_version")
    private String appVersion;
    /**
     * 小程序名称。长度限制 3~30 个字符，仅支持包含中文、数字、英文、下划线、+、-。
     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填。可通过alipay.open.mini.baseinfo.query查询当前小程序信息.
     */
    @AlipayApiField(name = "app_name")
    private String appName;
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
     * 第一张特殊资质图片，不能超过4MB，最大宽度 2160px，最大高度3840px。图片格式仅支持 png,jpg,PNG,JPG 格式。
     * 部分小程序类目需要提交，可通过https://opendocs.alipay.com/mini/03l8c8 查询类目是否需要上传营业执照信息。参照https://opendocs.alipay.com/mini/operation/material 要求填写营业执照信息。
     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填。
     */
    @AlipayApiField(name = "first_special_license_pic")
    private String firstSpecialLicensePic;
    /**
     * 第二张特殊资质图片文件，不能超过4MB，最大宽度 2160px，最大高度3840px。图片格式仅支持 png,jpg,PNG,JPG 格式。
     * 部分小程序类目需要提交，可通过https://opendocs.alipay.com/mini/03l8c8 查询类目是否需要上传营业执照信息。参照https://opendocs.alipay.com/mini/operation/material 要求填写营业执照信息。
     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填。
     */
    @AlipayApiField(name = "second_special_license_pic")
    private String secondSpecialLicensePic;
    /**
     * 第三张特殊资质图片文件，不能超过4MB，最大宽度 2160px，最大高度3840px。图片格式仅支持 png,jpg,PNG,JPG 格式。
     * 部分小程序类目需要提交，可通过https://opendocs.alipay.com/mini/03l8c8 查询类目是否需要上传营业执照信息。参照https://opendocs.alipay.com/mini/operation/material 要求填写营业执照信息。
     * 如果前期已经设置过该信息，本次可不填，平台将会为你默认上传该信息。如果前期没有设置过该信息，则本次为必填
     */
    @AlipayApiField(name = "third_special_license_pic")
    private String thirdSpecialLicensePic;
    /**
     * 测试账号，是否需要填写请参见https://opendocs.alipay.com/mini/operation/standard/case/akxg6r#3.%20%E6%B5%8B%E8%AF%95%E5%86%85%E5%AE%B9%E6%8F%90%E4%BA%A4%E4%B8%8D%E5%AE%8C%E6%95%B4
     */
    @AlipayApiField(name = "test_accout")
    private String testAccount;
    /**
     * 测试账号密码
     */
    @AlipayApiField(name = "test_password")
    private String testPassword;
    /**
     * 测试附件，用于上传测试报告和测试录屏，请上传10M以内附件，支持格式zip，rar。是否需要填写请参见:https://opendocs.alipay.com/mini/operation/standard/case/akxg6r#3.%20%E6%B5%8B%E8%AF%95%E5%86%85%E5%AE%B9%E6%8F%90%E4%BA%A4%E4%B8%8D%E5%AE%8C%E6%95%B4
     */
    @AlipayApiField(name = "test_file_name")
    private String testFileName;
    /**
     * 小程序投放的端参数。例如投放到支付宝钱包是支付宝端。默认支付宝端。支持：
     * com.alipay.alipaywallet:支付宝端；
     * com.alipay.iot.xpaas：支付宝IoT端。
     */
    @AlipayApiField(name = "bundle_id")
    private String bundleId;
    /**
     * 审核类型：
     * NONE： 不拆分准入、营销（默认）
     * BASE_PROMOTE：准入、营销拆分审核
     * 建议设置成“BASE_PROMOTE”，小程序将会更容易上架。将小程序发布审核拆分成“准入”、“营销”。原
     * 先小程序需要两个环节都审核通过才能上架，现在小程序只需要准入通过即可上架，但是无法在营销场
     * 景（支付宝泛搜、支付宝首页推荐等）展现给用户，小程序可通过精搜或者扫码等方式使用
     * 。如果小程序需要进行营销，可发布新版本，当准入&营销都通过后，小程
     * 序也可被营销。点击查看支付宝小程序营销规范：https://opendocs.alipay.com/b/03al2q
     */
    @AlipayApiField(name = "audit_rule")
    private String auditRule;
    /**
     * 如果有审核加急权益，是否使用审核加急权益加速审核：
     * 加速（默认）：true
     * 不加速：false
     */
    @AlipayApiField(name = "speedUp")
    private String speed_up;
    /**
     * 审核通过后是否自动上架，
     * 自动上架：true；不自动上架（默认）：false。
     * 如果小程序上架前无需特殊处理，建议设置成true，平台将会在小程序审核通过时自动将其上架
     */
    @AlipayApiField(name = "auto_online")
    private String autoOnline;

    @ApiModelProperty("接口调用凭证，该参数为 URL 参数，非 Body 参数。使用authorizer_access_token")
    private String authorizerAccessToken;
    @ApiModelProperty("商家应用ID")
    private String merchantAppId;
}
