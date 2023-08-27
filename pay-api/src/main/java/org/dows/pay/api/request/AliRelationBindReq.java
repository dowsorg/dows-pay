package org.dows.pay.api.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class AliRelationBindReq implements Serializable {

    private String type;

    private String account;

    private String appId;

    private String merchantNo;

}
