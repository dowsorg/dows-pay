package org.dows.pay.api.request;

import lombok.Data;

@Data
public class MiniUploadRequest {

    private String appId;

    private String templateId;

    /**
     *
     * 代码版本号，开发者可自定义（长度不要超过 64 个字符）
     */
    private String userVersion;

    /**
     * 代码描述，开发者可自定义
     */
    private String userDesc;

    /**
     * 控制 ext.json配置文件的内容
     */
    private String extJsonObject;

}
