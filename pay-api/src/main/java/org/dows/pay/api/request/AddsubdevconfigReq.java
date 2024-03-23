package org.dows.pay.api.request;


import lombok.Data;

@Data
public class AddsubdevconfigReq {
    //服务商
    private String appId;
    private String mchId;
    //商家
    private String subMchId;
    private String subAppId;
}
