package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/uploadShippingInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description 上传物流信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "上传物流信息Request", title = "上传物流信息Request")
public class ShangChuanWuLiuXinXiRequest {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误原因")
    private String errmsg;
}

