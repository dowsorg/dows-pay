package org.dows.sdk.weixin.bak.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/live-player/applyLivelnfo.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "ApplyLivelnfoResponse", title = "ApplyLivelnfoResponse")
public class ApplyLivelnfoResponse {
    @Schema(title = "0代表申请已经受理，等待小程序管理员操作；2表示小程序近90天没有存在支付行为，不能申请开通直播能力。（数据生效时间为T+1，请耐心等待）")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "'apply'")
    private String action;
}

