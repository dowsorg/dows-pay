package org.dows.sdk.weixin.open.pldykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/uploadCloudFunctionCode.html
 *
 * @author lait.zhang@gmail.com
 * @description 更新云函数代码
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "更新云函数代码Request", title = "更新云函数代码Request")
public class GengXinYunHanShuDaiMaRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "函数名")
    private String functionname;
    @Schema(title = "环境ID")
    private List<String> envs;
    @Schema(title = "包含函数代码文件的 zip 格式文件，使用该接口时要求将 zip 文件的内容转成 base64 编码，最大支持20M（云开发自动上传云端依赖，无需手动上传）")
    private String zipfile;
}

