package org.dows.pay.api.request;

import lombok.Data;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.annotation.WeixinApiField;

@Data
public class MiniUploadTemplateIdBO implements ChannelBizModel {


    /**
     * 模板id
     */
    @WeixinApiField(name = "templateId")
    private String templateId;

    /**
     *
     * 代码版本号，开发者可自定义（长度不要超过 64 个字符）
     */
    @WeixinApiField(name = "userVersion")
    private String userVersion;

    /**
     * 代码描述，开发者可自定义
     */
    @WeixinApiField(name = "userDesc")
    private String userDesc;

    /**
     * 控制 ext.json配置文件的内容
     */
    @WeixinApiField(name = "extJsonObject")
    private String extJsonObject;


}
