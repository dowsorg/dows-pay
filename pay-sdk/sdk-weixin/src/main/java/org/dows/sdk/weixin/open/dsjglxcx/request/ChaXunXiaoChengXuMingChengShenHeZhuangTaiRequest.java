package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getNickNameStatus.html
 *
 * @author lait.zhang@gmail.com
 * @description 查询小程序名称审核状态
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查询小程序名称审核状态Request", title = "查询小程序名称审核状态Request")
public class ChaXunXiaoChengXuMingChengShenHeZhuangTaiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "审核单 id，由")
    private Integer audit_id;
}

