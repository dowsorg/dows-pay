package org.dows.sdk.weixin.bak.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getBindOpenAccountEntity.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetBindOpenAccountEntityResponse", title = "GetBindOpenAccountEntityResponse")
public class GetBindOpenAccountEntityResponse {
    @Schema(title = "是否同主体；true表示同主体；false表示不同主体")
    private Boolean same_entity;
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

