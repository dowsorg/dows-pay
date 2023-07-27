package org.dows.pay.api.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClaimProfitReq implements Serializable {

    private String orderId;


}
