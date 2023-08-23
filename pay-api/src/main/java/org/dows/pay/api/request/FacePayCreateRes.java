package org.dows.pay.api.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class FacePayCreateRes implements Serializable {

    /**
     * 商户订单号
     */
    private String tradeNo;

    private String qrCodeImage;
}
