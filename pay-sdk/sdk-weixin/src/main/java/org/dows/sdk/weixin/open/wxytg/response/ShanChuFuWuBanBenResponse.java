package org.dows.sdk.weixin.open.wxytg.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/deleteCloudbaseServiceVersion.html
 *
 * @author lait.zhang@gmail.com
 * @description 删除服务版本
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "删除服务版本Response", title = "删除服务版本Response")
public class ShanChuFuWuBanBenResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "返回结果，succ为成功")
    private String result;
}

