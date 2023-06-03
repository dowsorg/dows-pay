package org.dows.sdk.weixin.open.pldykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/staticstore-management/createStaticStore.html
 *
 * @author lait.zhang@gmail.com
 * @description 开通静态网站
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "开通静态网站Request", title = "开通静态网站Request")
public class KaiTongJingTaiWangZhanRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境ID")
    private String env;
}

