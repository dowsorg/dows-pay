package org.dows.pay.spider.properties;

import lombok.Data;

import java.util.List;

@Data
public class Crawler {
    private String channel;
    private String seed;
    private List<Flow> flows;
}