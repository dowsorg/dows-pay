package org.dows.pay.spider.properties;

import lombok.Data;

import java.util.Map;

@Data
public class Rule {
    private String section;
    private Map<String,String> regex;
    private Class<?> mapping;
}