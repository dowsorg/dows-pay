package org.dows.pay.weixin.mp.event.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.sun.jdi.request.EventRequest;


/**
 * 模板消息事件
 */
public class JobFinishedEvent extends EventRequest {

    @JsonProperty("MsgID")
    private long msgId;

    @JsonProperty("Status")
    @JacksonXmlCData
    private String status;

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean success() {
        return "success".equalsIgnoreCase(this.status);
    }
}
