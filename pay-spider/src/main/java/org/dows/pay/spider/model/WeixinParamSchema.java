package org.dows.pay.spider.model;

import lombok.Data;
import org.dows.pay.spider.TdIndex;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * 属性	类型	必填	说明
 */
@Data
public class WeixinParamSchema {
    @TdIndex("属性")
    private String field;
    @TdIndex("类型")
    private String fieldType;
    @TdIndex("必填")
    private String must;
    @TdIndex("说明")
    private String descr;
    /**
     * input/output
     */
    private String ioType;

    private static Map<String, Field> collect = new ConcurrentHashMap<>();

    static {
        collect.putAll(Arrays.stream(WeixinParamSchema.class.getDeclaredFields()).filter(f -> f.getAnnotation(TdIndex.class) != null)
                .collect(Collectors.toMap(f -> f.getAnnotation(TdIndex.class).value(), Function.identity())));
    }

    public Map<String, Field> getFields() {
        return collect;
    }
}
