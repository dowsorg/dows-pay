package org.dows.pay.weixin.mp.card.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public abstract class AbstractCard {

    @JsonProperty("base_info")
    private BaseInfo baseInfo;

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }
}
