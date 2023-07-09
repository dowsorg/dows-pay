package org.dows.pay.api.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ProfitReceiverAddReq implements Serializable {

    private String sub_mchid;

    private String appid;

    private String type;

    private String account;

    private String name;

    private String relation_type;
}
