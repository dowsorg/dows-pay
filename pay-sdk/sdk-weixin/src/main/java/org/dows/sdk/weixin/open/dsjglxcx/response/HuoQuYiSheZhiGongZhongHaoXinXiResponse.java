package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/subscribe-component/getShowItem.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取已设置公众号信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取已设置公众号信息Response", title = "获取已设置公众号信息Response")
public class HuoQuYiSheZhiGongZhongHaoXinXiResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "是否可以设置 1 可以，0，不可以")
    private Integer can_open;
    @Schema(title = "是否已经设置，1 已设置，0，未设置")
    private Integer is_open;
    @Schema(title = "展示的公众号 appid")
    private String appid;
    @Schema(title = "展示的公众号 nickname")
    private String nickname;
    @Schema(title = "展示的公众号头像")
    private String headimg;
}

