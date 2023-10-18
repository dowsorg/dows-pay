package org.dows.pay.api.request;

import lombok.Data;

@Data
public class WechatMiniUploadRequest {

    private String merchantNo;

    /**
     * 模板id 不传即为默认最新
     */
    private String templateId;

    private String appId;

    private String appVersion;
}
