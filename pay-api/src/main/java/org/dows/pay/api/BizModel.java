package org.dows.pay.api;

import org.dows.pay.api.annotation.AlipayApiField;
import org.dows.pay.api.annotation.WeixinApiField;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 业务对象
 */
public interface BizModel {

    Map<Class, Map<String, Field>> ALIPAY_MODLE_FIELD_MAP = new ConcurrentHashMap<>();
    Map<Class, Map<String, Field>> WEIXIN_MODLE_FIELD_MAP = new ConcurrentHashMap<>();

    /**
     * 获取对象字段特定的注解名称及对应的Field对象
     *
     * @return
     */
    default Map<String, Field> getAlipayFeilds() {
        Map<String, Field> fieldMap = ALIPAY_MODLE_FIELD_MAP.get(this.getClass());
        if (fieldMap != null) {
            return fieldMap;
        }
        Map<String, Field> collect = Arrays.stream(this.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(AlipayApiField.class))
                .collect(Collectors.toMap(f -> f.getAnnotation(AlipayApiField.class).name(), Function.identity()));
        ALIPAY_MODLE_FIELD_MAP.put(this.getClass(), collect);
        return collect;
    }


    default Map<String, Field> getWeixinFeilds() {
        Map<String, Field> fieldMap = WEIXIN_MODLE_FIELD_MAP.get(this.getClass());
        if (fieldMap != null) {
            return fieldMap;
        }
        Map<String, Field> collect = Arrays.stream(this.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(WeixinApiField.class))
                .collect(Collectors.toMap(f -> f.getAnnotation(WeixinApiField.class).name(), Function.identity()));
        WEIXIN_MODLE_FIELD_MAP.put(this.getClass(), collect);
        return collect;
    }
}
