package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getBindOpenAccount.html
 *
 * @author lait.zhang@gmail.com
 * @description 查询绑定的开放平台帐号
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查询绑定的开放平台帐号Response", title = "查询绑定的开放平台帐号Response")
public class ChaXunBangDingDeKaiFangPingTaiZhangHaoResponse {
    @Schema(title = "是否绑定open帐号，true表示绑定；false表示未绑定任何open帐号")
    private Boolean have_open;
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

