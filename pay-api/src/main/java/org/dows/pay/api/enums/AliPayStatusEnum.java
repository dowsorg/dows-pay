package org.dows.pay.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
public enum AliPayStatusEnum {

    MERCHANT_INFO_HOLD("MERCHANT_INFO_HOLD", "暂存"),
    MERCHANT_AUDITING("MERCHANT_AUDITING", "审核中"),
    MERCHANT_CONFIRM("MERCHANT_CONFIRM", "待商户确认"),
    MERCHANT_CONFIRM_SUCCESS("MERCHANT_CONFIRM_SUCCESS", "商户确认成功"),
    MERCHANT_APPLY_ORDER_CANCELED("MERCHANT_APPLY_ORDER_CANCELED", "审核失败"),

    ;

    @Getter
    private String type;

    @Getter
    private String desc;


    public static String getDesc(String type) {
        for (AliPayStatusEnum payStatusEnum : values()) {
            if (Objects.equals(type,payStatusEnum.getType())) {
                return payStatusEnum.getDesc();
            }
        }
        return "";
    }
}
