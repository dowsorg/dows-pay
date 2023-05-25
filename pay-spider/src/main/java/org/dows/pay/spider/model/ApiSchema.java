package org.dows.pay.spider.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiSchema {
    private String cnName;
    private String enName;
    private String url;
    private String httpMethod;
    private String descr;

    private List<ParamSchema> input;

    private List<ParamSchema> output;
}