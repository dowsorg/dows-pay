package org.dows.pay.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.response.PayIsvResponse;

/**
 *
 */
@Data
@ToString
@Accessors(chain = true)
@NoArgsConstructor
public class PayCreateIsvRequest extends AbstractPayRequest<PayIsvResponse> {

    @ApiModelProperty("支付宝账号")
    private String account;
    @ApiModelProperty("账号类型，0个人，1企业")
    private int isPerson;
    @ApiModelProperty("营业执照图片，账号类型为个人0填写")
    private String business_license_pic;
    @ApiModelProperty("联系人名称")
    private String contact_name;
    @ApiModelProperty("联系人手机号码")
    private String contact_mobile;
    @ApiModelProperty("联系人邮箱")
    private String contact_email;
    @ApiModelProperty("类目，A0001_B0199")
    private String mcc_code;
    @ApiModelProperty("应用ID")
    private String appid;
    @ApiModelProperty("店铺内景图片")
    private String shop_scene_pic;
    @ApiModelProperty("店铺门头照图片")
    private String shop_sign_board_pic;
    @ApiModelProperty("店铺名称")
    private String shop_name;
    @ApiModelProperty("营业执照法人手机号码，上传非同人营业执照时必填")
    private String business_license_mobile;
}
