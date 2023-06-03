package org.dows.sdk.weixin.open.wxytg.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/createCloudbaseService.html
 *
 * @author lait.zhang@gmail.com
 * @description 创建服务
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "创建服务Request", title = "创建服务Request")
public class ChuangJianFuWuRequest {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

