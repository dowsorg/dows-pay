package org.dows.sdk.weixin.open.pldykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/createTcbEnv.html
 *
 * @author lait.zhang@gmail.com
 * @description 创建环境
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "创建环境Response", title = "创建环境Response")
public class ChuangJianHuanJingResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "后付费订单号")
    private String tranid;
    @Schema(title = "环境ID")
    private String env;
}

