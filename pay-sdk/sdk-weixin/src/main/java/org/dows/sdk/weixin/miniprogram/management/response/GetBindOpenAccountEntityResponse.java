package org.dows.sdk.weixin.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class GetBindOpenAccountEntityResponse {
    @Schema(title = "是否同主体；true表示同主体；false表示不同主体")
    private Boolean same_entity;

    @Schema(title = "错误码")
    private Number errcode;

    @Schema(title = "错误信息")
    private String errmsg;


}
