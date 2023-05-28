package org.dows.sdk.weixin.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class ApplyLivelnfoResponse {
    @Schema(title = "0代表申请已经受理，等待小程序管理员操作；2表示小程序近90天没有存在支付行为，不能申请开通直播能力。（数据生效时间为T+1，请耐心等待）")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "'apply'")
    private String action;
}

