package org.dows.pay.api;

import org.dows.pay.api.annotation.AlipayApiField;
import org.dows.pay.api.annotation.WeixinApiField;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 业务对象
 */
public interface BizModel {
    /**
     * 获取对象字段特定的注解名称及对应的Field对象
     *
     * @return
     */
    default Map<String, Field> getAlipayFeilds() {
        Map<String, Field> collect = Arrays.stream(this.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(AlipayApiField.class))
                .collect(Collectors.toMap(f -> f.getAnnotation(AlipayApiField.class).value(), Function.identity()));
        return collect;

    }


    default Map<String, Field> getWeixinFeilds() {
        Map<String, Field> collect = Arrays.stream(this.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(WeixinApiField.class))
                .collect(Collectors.toMap(f -> f.getAnnotation(WeixinApiField.class).value(), Function.identity()));
        return collect;
    }
}
