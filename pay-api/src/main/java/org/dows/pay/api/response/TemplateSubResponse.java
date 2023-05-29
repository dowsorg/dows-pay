package org.dows.pay.api.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TemplateSubResponse implements Serializable {

    private Integer Id;
    private String appId;
    private String auditId;
    private String merchantNo;
    private Integer appType;
    private Integer auditStatus;
    private Integer deleted;
    private Date dt;
    private Date updateTime;

}
