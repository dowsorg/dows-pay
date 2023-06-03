package org.dows.sdk.weixin.open.ptdykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getFuntionList.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取云函数列表
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取云函数列表Request", title = "获取云函数列表Request")
public class HuoQuYunHanShuLieBiaoRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境id")
    private String env;
    @Schema(title = "获取数量限制")
    private Integer limit;
    @Schema(title = "偏移量")
    private Integer offset;
}

