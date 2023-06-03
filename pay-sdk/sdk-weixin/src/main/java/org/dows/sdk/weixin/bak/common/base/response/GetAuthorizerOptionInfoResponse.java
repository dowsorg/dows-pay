package org.dows.sdk.weixin.bak.common.base.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerOptionInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetAuthorizerOptionInfoResponse", title = "GetAuthorizerOptionInfoResponse")
public class GetAuthorizerOptionInfoResponse {
    @Schema(title = "选项名称")
    private String option_name;
    @Schema(title = "选项值")
    private String option_value;
}

