package org.dows.pay.weixin.mp.event.care;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.jdi.request.EventRequest;


/**
 *
 */
public class SessionCreateEvent extends EventRequest {

    @JsonProperty("KfAccount")
    private String care;

    public String getCare() {
        return care;
    }

    public void setCare(String care) {
        this.care = care;
    }
}
