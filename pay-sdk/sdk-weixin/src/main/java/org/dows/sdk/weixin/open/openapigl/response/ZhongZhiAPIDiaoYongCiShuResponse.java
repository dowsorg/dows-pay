package org.dows.sdk.weixin.open.openapigl.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/clearQuota.html
 *
 * @author lait.zhang@gmail.com
 * @description 重置API调用次数
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "重置API调用次数Response", title = "重置API调用次数Response")
public class ZhongZhiAPIDiaoYongCiShuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

