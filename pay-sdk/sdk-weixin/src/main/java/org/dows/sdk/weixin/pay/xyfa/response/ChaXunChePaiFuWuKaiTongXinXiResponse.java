package org.dows.sdk.weixin.pay.xyfa.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_1.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:52
 */
@Data
@Schema(name = "查询车牌服务开通信息Response", title = "查询车牌服务开通信息Response")
public class ChaXunChePaiFuWuKaiTongXinXiResponse {
    @Schema(title = "车牌号，仅包括省份+车牌，不包括特殊字符。")
    private String plate_number;
    @Schema(title = "车牌颜色，枚举值：")
    private String plate_color;
    @Schema(title = "车牌服务开通时间，遵循")
    private String service_open_time;
    @Schema(title = "用户在商户对应appid下的唯一标识，此处返回商户请求中的openid")
    private String openid;
    @Schema(title = "车牌服务开通状态，")
    private String service_state;
}

