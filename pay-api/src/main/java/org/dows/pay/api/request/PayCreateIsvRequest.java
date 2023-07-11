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
    @ApiModelProperty("联系人名称")
    private String contact_name;
    @ApiModelProperty("联系人手机号码")
    private String contact_mobile;
    @ApiModelProperty("类目，A0001_B0199")
    private String mcc_code;
    @ApiModelProperty("应用ID")
    private String appid;
    @ApiModelProperty("店铺内景图片")
    private String shop_scene_pic;
    @ApiModelProperty("店铺门头照图片")
    private String shop_sign_board_pic;

}
