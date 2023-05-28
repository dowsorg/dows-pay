package org.dows.sdk.client;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Data
public class ApiResult {

    private Integer statusCode;

    private Object data;

    private Map<String, List<String>> headers;

    private Exception exception;

    public boolean hasException() {
        return exception != null;
    }

}
