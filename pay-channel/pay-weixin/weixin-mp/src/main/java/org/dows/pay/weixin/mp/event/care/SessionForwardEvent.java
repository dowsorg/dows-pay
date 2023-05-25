package org.dows.pay.weixin.mp.event.care;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.jdi.request.EventRequest;


/**
 *
 */
public class SessionForwardEvent extends EventRequest {

    @JsonProperty("FromKfAccount")
    private String fromCare;

    @JsonProperty("ToKfAccount")
    private String toCare;

    public String getFromCare() {
        return fromCare;
    }

    public void setFromCare(String fromCare) {
        this.fromCare = fromCare;
    }

    public String getToCare() {
        return toCare;
    }

    public void setToCare(String toCare) {
        this.toCare = toCare;
    }
}
