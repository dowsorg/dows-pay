package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/invokeCloudFunction.html
 *
 * @author lait.zhang@gmail.com
 * @description 触发云函数
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "触发云函数Response", title = "触发云函数Response")
public class ChuFaYunHanShuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "云函数返回的buffer")
    private String resp_data;
}

