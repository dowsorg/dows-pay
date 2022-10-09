package org.dows.pay.api;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
public abstract class PayResponse implements Serializable {

    private String code;
    private String msg;
    private String bizCode;
    private String bizMsg;
    private String body;
    private Map<String, String> params;
}
