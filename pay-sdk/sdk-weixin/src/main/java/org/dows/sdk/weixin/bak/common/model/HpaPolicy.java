package org.dows.sdk.weixin.bak.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class HpaPolicy {
    @Schema(title = "策略类型")
    private String policy_type;
    @Schema(title = "策略阈值")
    private Integer policy_threshold;
}