package org.dows.pay.api.message;

import lombok.Builder;
import lombok.Data;
import org.dows.pay.api.PayMessage;

@Builder
@Data
public class WeixinMessage implements PayMessage {
    @Override
    public String getAppId() {
        return null;
    }

    @Override
    public String getMsgApi() {
        return null;
    }

    @Override
    public String getMsgId() {
        return null;
    }

    @Override
    public String getBizContent() {
        return null;
    }
}
