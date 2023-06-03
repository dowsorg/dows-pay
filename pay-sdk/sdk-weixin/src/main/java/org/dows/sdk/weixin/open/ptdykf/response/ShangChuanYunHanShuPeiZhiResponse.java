package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getUploadFuntionConfig.html
 *
 * @author lait.zhang@gmail.com
 * @description 上传云函数配置
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "上传云函数配置Response", title = "上传云函数配置Response")
public class ShangChuanYunHanShuPeiZhiResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

