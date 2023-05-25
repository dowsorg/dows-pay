package org.dows.pay.spider.model;

import lombok.Data;

@Data
public class MenuInfo {
    private String module;
    private String sub;
    private String href;
    private String code;
    private String descr;
}