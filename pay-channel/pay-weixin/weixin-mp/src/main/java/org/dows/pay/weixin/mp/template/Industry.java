package org.dows.pay.weixin.mp.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 */
@Data
public class Industry {

    @JsonProperty("primary_industry")
    private String primary;

    @JsonProperty("secondary_industry")
    private String secondary;

}
