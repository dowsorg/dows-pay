package org.dows.sdk.weixin.open.pldykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/deleteCloudFunction.html
 *
 * @author lait.zhang@gmail.com
 * @description 删除云函数
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "删除云函数Response", title = "删除云函数Response")
public class ShanChuYunHanShuResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

