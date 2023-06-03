package org.dows.sdk.weixin.open.pldykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/staticstore-management/getStaticStore.html
 *
 * @author lait.zhang@gmail.com
 * @description 查看静态网站状态
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查看静态网站状态Request", title = "查看静态网站状态Request")
public class ChaKanJingTaiWangZhanZhuangTaiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境id")
    private String env;
}

