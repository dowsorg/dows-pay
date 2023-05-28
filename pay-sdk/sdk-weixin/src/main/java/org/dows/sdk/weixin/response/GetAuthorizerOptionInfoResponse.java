package org.dows.sdk.weixin.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetAuthorizerOptionInfoResponse", title = "GetAuthorizerOptionInfoResponse")
public class GetAuthorizerOptionInfoResponse {
    @Schema(title = "选项名称")
    private String option_name;
    @Schema(title = "选项值")
    private String option_value;
}

