package org.dows.sdk.weixin.open.xcxllzdyy.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/open/AgencyCreatePublisher.html
 *
 * @author lait.zhang@gmail.com
 * @description 开通流量主
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "开通流量主Response", title = "开通流量主Response")
public class KaiTongLiuLiangZhuResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
}

