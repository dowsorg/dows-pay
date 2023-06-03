package org.dows.sdk.weixin.pay.xyfa.request;

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
@Schema(name = "查询车牌服务开通信息Request", title = "查询车牌服务开通信息Request")
public class ChaXunChePaiFuWuKaiTongXinXiRequest {
    @Schema(title = "")
    private String appid;
    @Schema(title = "")
    private String plate_number;
    @Schema(title = "")
    private String plate_color;
    @Schema(title = "")
    private String openid;
}

