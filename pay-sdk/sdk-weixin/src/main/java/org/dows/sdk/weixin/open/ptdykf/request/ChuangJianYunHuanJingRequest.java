package org.dows.sdk.weixin.open.ptdykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/env-management/createEnv.html
 *
 * @author lait.zhang@gmail.com
 * @description 创建云环境
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "创建云环境Request", title = "创建云环境Request")
public class ChuangJianYunHuanJingRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "参数值CreatePostpayPackage")
    private String type;
    @Schema(title = "环境别名")
    private String alias;
}

