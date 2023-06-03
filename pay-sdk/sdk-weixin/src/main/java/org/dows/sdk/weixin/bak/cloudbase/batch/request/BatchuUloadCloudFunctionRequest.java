package org.dows.sdk.weixin.bak.cloudbase.batch.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/batchuUloadCloudFunction.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "BatchuUloadCloudFunctionRequest", title = "BatchuUloadCloudFunctionRequest")
public class BatchuUloadCloudFunctionRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "函数名")
    private String functionname;
    @Schema(title = "环境ID")
    private List<String> envs;
    @Schema(title = "包含函数代码文件的 zip 格式文件，使用该接口时要求将 zip 文件的内容转成 base64 编码，最大支持20M （云开发自动上传云端依赖，无需手动上传）")
    private String zipfile;
    @Schema(title = "VPC唯一标识")
    private String vpcid;
    @Schema(title = "子网id")
    private String subnetid;
}

