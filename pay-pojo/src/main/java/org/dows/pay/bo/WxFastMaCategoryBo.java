package org.dows.pay.bo;

import lombok.Data;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.annotation.WeixinApiField;

import java.util.List;


@Data
public class WxFastMaCategoryBo implements ChannelBizModel {


    /**
     * 一级类目ID.
     */
    @WeixinApiField(name = "first")
    private int first;

    /**
     * 二级类目ID.
     */
    @WeixinApiField(name = "second")
    private int second;

    /**
     * 资质信息.
     */
    @WeixinApiField(name = "certicates")
    private List<Certificate> certicates;

    @Data
    public static class Certificate {
        @WeixinApiField(name = "key")
        private String key;
        @WeixinApiField(name = "value")
        private String value;
    }


}
