package org.dows.sdk.weixin.open.pldykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/uploadCloudFunctionConfig.html
 *
 * @author lait.zhang@gmail.com
 * @description 更新云函数配置
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "更新云函数配置Request", title = "更新云函数配置Request")
public class GengXinYunHanShuPeiZhiRequest {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

