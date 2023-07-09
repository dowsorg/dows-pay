package org.dows.pay.api.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ProfitReceiverAddReq implements Serializable {

    private String sub_mchid;

    private String appid;

    private String type;

    private String account;

    private String name;

    private String relation_type;
}
