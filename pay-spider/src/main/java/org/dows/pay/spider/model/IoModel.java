package org.dows.pay.spider.model;

import lombok.Data;

@Data
public class IoModel {
    private String field;
    private String fieldType;
    private Boolean must;
    private String descr;
    /**
     * input/output
     */
    private String ioType;

}