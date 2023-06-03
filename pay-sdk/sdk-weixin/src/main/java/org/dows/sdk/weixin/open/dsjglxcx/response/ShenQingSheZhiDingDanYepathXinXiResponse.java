package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/applySetOrderPathInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description 申请设置订单页path信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "申请设置订单页path信息Response", title = "申请设置订单页path信息Response")
public class ShenQingSheZhiDingDanYepathXinXiResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "返回码信息")
    private String errmsg;
}

