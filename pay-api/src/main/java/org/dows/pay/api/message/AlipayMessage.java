package org.dows.pay.api.message;

import lombok.Builder;
import lombok.Data;
import org.dows.pay.api.PayMessage;

@Builder
@Data
public class AlipayMessage implements PayMessage {
    private String appId;
    private String notifyType;
    private String msgApi;
    private String msgId;
    private String bizContent;
}
