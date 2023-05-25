package org.dows.pay.weixin.mp.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 */
@Data
public class Template {

    @JsonProperty("template_id")
    private String templateId;
    private String title;

    @JsonProperty("primary_industry")
    private String primaryIndustry;

    @JsonProperty("deputy_industry")
    private String secondaryIndustry;

    private String content;
    private String example;
}
