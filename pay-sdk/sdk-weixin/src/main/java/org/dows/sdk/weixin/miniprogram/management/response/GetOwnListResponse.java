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
public class GetOwnListResponse {
    @Schema(title = "待验证")
    private;

    @Schema(title = "已通过")
    private;

    @Schema(title = "已拒绝")
    private;

    @Schema(title = "已超时")
    private;

    @Schema(title = "已撤销")
    private;

    @Schema(title = "已取消授权")
    private;


}
