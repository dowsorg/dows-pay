package org.dows.pay.api.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ScanPayApplyRes implements Serializable {

    private String orderId;

    private String scanQrCode;

    private String tradeNo;

    private String sign;
}
