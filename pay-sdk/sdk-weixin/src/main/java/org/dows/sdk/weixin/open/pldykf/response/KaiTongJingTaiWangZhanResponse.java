package org.dows.sdk.weixin.open.pldykf.response;

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
@Schema(name = "开通静态网站Response", title = "开通静态网站Response")
public class KaiTongJingTaiWangZhanResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

