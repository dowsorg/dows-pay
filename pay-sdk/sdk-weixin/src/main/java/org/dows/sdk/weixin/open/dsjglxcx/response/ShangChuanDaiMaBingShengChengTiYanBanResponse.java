package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/commit.html
 *
 * @author lait.zhang@gmail.com
 * @description 上传代码并生成体验版
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "上传代码并生成体验版Response", title = "上传代码并生成体验版Response")
public class ShangChuanDaiMaBingShengChengTiYanBanResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "返回信息")
    private String errmsg;
}

