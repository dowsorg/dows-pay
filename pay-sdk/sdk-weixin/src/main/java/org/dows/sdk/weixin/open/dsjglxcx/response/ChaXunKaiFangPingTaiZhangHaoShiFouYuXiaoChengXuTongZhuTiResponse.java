package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getBindOpenAccountEntity.html
 *
 * @author lait.zhang@gmail.com
 * @description 查询开放平台帐号是否与小程序同主体
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查询开放平台帐号是否与小程序同主体Response", title = "查询开放平台帐号是否与小程序同主体Response")
public class ChaXunKaiFangPingTaiZhangHaoShiFouYuXiaoChengXuTongZhuTiResponse {
    @Schema(title = "是否同主体；true表示同主体；false表示不同主体")
    private Boolean same_entity;
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

