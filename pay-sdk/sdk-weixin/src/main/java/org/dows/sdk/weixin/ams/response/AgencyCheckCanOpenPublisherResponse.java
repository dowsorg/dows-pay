package org.dows.sdk.weixin.ams.response;

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
public class AgencyCheckCanOpenPublisherResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
    @Schema(title = "返回能否开通状态：0否，1能")
    private Integer status;

}
