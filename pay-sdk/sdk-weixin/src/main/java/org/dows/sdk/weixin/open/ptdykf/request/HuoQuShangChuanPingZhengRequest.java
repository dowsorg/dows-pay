package org.dows.sdk.weixin.open.ptdykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getYploadSignature.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取上传凭证
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取上传凭证Request", title = "获取上传凭证Request")
public class HuoQuShangChuanPingZhengRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "上传云函数POST数据的签名")
    private String hashed_payload;
}

