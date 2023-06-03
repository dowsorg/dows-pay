package org.dows.sdk.weixin.open.xcxllzdyy.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/open/AgencyCheckCanOpenPublisher.html
 *
 * @author lait.zhang@gmail.com
 * @description 检测是否能开通流量主
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "检测是否能开通流量主Response", title = "检测是否能开通流量主Response")
public class JianCeShiFouNengKaiTongLiuLiangZhuResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
    @Schema(title = "返回能否开通状态：0否，1能")
    private Integer status;
}

