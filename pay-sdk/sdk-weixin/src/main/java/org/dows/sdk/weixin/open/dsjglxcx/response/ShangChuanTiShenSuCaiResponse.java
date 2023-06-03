package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.nio.Buffer;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/uploadMediaToCodeAudit.html
 *
 * @author lait.zhang@gmail.com
 * @description 上传提审素材
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "上传提审素材Response", title = "上传提审素材Response")
public class ShangChuanTiShenSuCaiResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "类型")
    private String type;
    @Schema(title = "媒体id")
    private Buffer mediaid;
}

