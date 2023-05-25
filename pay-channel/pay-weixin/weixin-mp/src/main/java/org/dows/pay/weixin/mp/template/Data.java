package org.dows.pay.weixin.mp.template;

/**
 *
 */
@lombok.Data
public class Data {

    private String value;
    private String color;

    public Data() {
    }

    public Data(String value, String color) {
        this.value = value;
        this.color = color;
    }

}
