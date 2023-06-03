package org.dows.sdk.weixin.open.pldykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/getShareCloudbaseEnv.html
 *
 * @author lait.zhang@gmail.com
 * @description 查询环境共享信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查询环境共享信息Request", title = "查询环境共享信息Request")
public class ChaXunHuanJingGongXiangXinXiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "要查询的appid")
    private List<String> appids;
    @Schema(title = "请求环境源，填 1，表示云托管环境")
    private Integer source_type;
}

