package org.dows.sdk.weixin.bak.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/AgencyUpdateAdunit.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "AgencyUpdateAdunitRequest", title = "AgencyUpdateAdunitRequest")
public class AgencyUpdateAdunitRequest {
    @Schema(title = "广告单元名称")
    private String name;
    @Schema(title = "广告单元ID")
    private String ad_unit_id;
    @Schema(title = "广告单元开关状态：AD_UNIT_STATUS_ON开通，AD_UNIT_STATUS_OFF关闭")
    private String status;
    @Schema(title = "激励视频广告位必填，广告展示时长最小值。目前可选值：6")
    private Integer video_duration_min;
    @Schema(title = "激励视频广告位必填，广告展示时长最大值。目前可选值：15/30/60")
    private Integer video_duration_max;
    @Schema(title = "原生模板广告位必填tmpl_type或tmpl_id。方式一：tmpl_type 选择固定模板样式，当前可选值：6竖版上图下文，7竖版上文下图，12竖版上图下文叠加A，13竖版上图下文叠加B，2横幅上图下文，3横幅下图上文，4横板上图下文叠加A，11横板上图下文叠加B，9横幅左图右文，10横幅右图左文，20横幅单图，100001单格子无动画，100003多格子无轮播")
    private Integer tmpl_type;
    @Schema(title = "原生模板模板广告位必填tmpl_type或tmpl_id。方式二：自定义创建模板，填入【第三方平台->变现专区->原生模板广告位管理中】自定义创建的模板ID。操作指引见：")
    private String tmpl_id;
}

