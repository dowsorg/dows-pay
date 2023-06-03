package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getVisitStatus.html
 *
 * @author lait.zhang@gmail.com
 * @description 查询小程序服务状态
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查询小程序服务状态Response", title = "查询小程序服务状态Response")
public class ChaXunXiaoChengXuFuWuZhuangTaiResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "服务状态。0表示已暂停服务（包含主动暂停服务违规被暂停服务）。1表示未暂停服务。")
    private Integer status;
}

