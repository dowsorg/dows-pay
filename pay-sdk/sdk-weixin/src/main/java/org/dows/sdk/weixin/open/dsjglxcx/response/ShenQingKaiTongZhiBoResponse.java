package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/live-player/applyLivelnfo.html
 *
 * @author lait.zhang@gmail.com
 * @description 申请开通直播
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "申请开通直播Response", title = "申请开通直播Response")
public class ShenQingKaiTongZhiBoResponse {
    @Schema(title = "0代表申请已经受理，等待小程序管理员操作；2表示小程序近90天没有存在支付行为，不能申请开通直播能力。（数据生效时间为T+1，请耐心等待）")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "'apply'")
    private String action;
}

