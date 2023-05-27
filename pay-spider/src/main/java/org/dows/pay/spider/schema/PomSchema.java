package org.dows.pay.spider.schema;

import lombok.Data;

@Data
public class PomSchema {
    private String artifactId;
    private String groupId;
    private String version;
}
