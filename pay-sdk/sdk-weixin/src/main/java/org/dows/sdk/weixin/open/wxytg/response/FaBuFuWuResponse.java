package org.dows.sdk.weixin.open.wxytg.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/releaseCloudbaseServiceVersion.html
 *
 * @author lait.zhang@gmail.com
 * @description 发布服务
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "发布服务Response", title = "发布服务Response")
public class FaBuFuWuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "是否成功，success是成功，failed是失败")
    private String result;
    @Schema(title = "发布单id")
    private Integer release_order_id;
}

