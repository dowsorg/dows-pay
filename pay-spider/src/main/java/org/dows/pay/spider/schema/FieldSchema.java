package org.dows.pay.spider.schema;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.dows.pay.spider.AlipayField;
import org.dows.pay.spider.WexinOpenField;
import org.dows.pay.spider.WexinPayField;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 属性	类型	必填	说明
 * 参数名	变量	类型[长度限制]	必填	描述
 */
@Data
public class FieldSchema {
    @WexinOpenField("属性")
    @WexinPayField("变量")
    private String code;

    @WexinPayField("参数名")
    private String name;

    @AlipayField("")
    @WexinOpenField("类型")
    @WexinPayField("类型[长度限制]")
    private String fieldType;

    @AlipayField("")
    @WexinOpenField("必填")
    @WexinPayField("必填")
    private String must;

    @AlipayField("")
    @WexinOpenField("说明")
    @WexinPayField("描述")
    private String descr;
//    @TdIndex("说明")
//    private String explain;
    /**
     * input/output
     */
    private String ioType;

    private static Map<String, Field> weixinOpenFieldMap = new ConcurrentHashMap<>();
    private static Map<String, Field> weixinPayFieldMap = new ConcurrentHashMap<>();

    static {
        weixinOpenFieldMap.putAll(Arrays.stream(FieldSchema.class.getDeclaredFields()).filter(f -> f.getAnnotation(WexinOpenField.class) != null)
                .collect(Collectors.toMap(f -> f.getAnnotation(WexinOpenField.class).value(), Function.identity())));

        weixinPayFieldMap.putAll(Arrays.stream(FieldSchema.class.getDeclaredFields()).filter(f -> f.getAnnotation(WexinPayField.class) != null)
                .collect(Collectors.toMap(f -> f.getAnnotation(WexinPayField.class).value(), Function.identity())));
        // todo 支付宝
    }

    public Boolean isNotnull() {
        if (must.equalsIgnoreCase("是")) {
            return true;
        }
        return false;
    }

    public Map<String, Field> getWexinOpenFieldMap() {
        return weixinOpenFieldMap;
    }

    public Map<String, Field> getWexinPayFieldMap() {
        return weixinPayFieldMap;
    }

    public String getDescr() {
        if (StrUtil.isBlank(descr)) {
            return "";
        }
        return descr.replaceAll("\"", "'");
    }

    public String getFieldType() {
        if (StrUtil.isBlank(fieldType)) {
            return "";
        } else if (fieldType.contains("[")) {
            return fieldType.substring(0, fieldType.indexOf("["));
        } else if (fieldType.startsWith("Array<string") || fieldType.startsWith("array<string")) {
            return "List<String>";
        } else if (fieldType.equalsIgnoreCase("number")) {
            return "Integer";
        }
        return fieldType;
    }
}
