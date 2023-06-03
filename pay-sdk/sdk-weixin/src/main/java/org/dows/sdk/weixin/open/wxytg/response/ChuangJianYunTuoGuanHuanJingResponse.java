package org.dows.sdk.weixin.open.wxytg.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/createCloudbaseEnv.html
 *
 * @author lait.zhang@gmail.com
 * @description 创建云托管环境
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "创建云托管环境Response", title = "创建云托管环境Response")
public class ChuangJianYunTuoGuanHuanJingResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "环境id")
    private String env_id;
    @Schema(title = "后付费订单号")
    private String tran_id;
}

