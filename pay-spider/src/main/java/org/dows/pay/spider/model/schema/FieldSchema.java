package org.dows.pay.spider.model.schema;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.dows.pay.spider.AlipayField;
import org.dows.pay.spider.WexinOpenField;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 属性	类型	必填	说明
 */
@Data
public class FieldSchema {

    @AlipayField("")
    @WexinOpenField("属性")
    private String name;

    @AlipayField("")
    @WexinOpenField("类型")
    private String fieldType;

    @AlipayField("")
    @WexinOpenField("必填")
    private String must;

    @AlipayField("")
    @WexinOpenField("说明")
    private String descr;
//    @TdIndex("说明")
//    private String explain;
    /**
     * input/output
     */
    private String ioType;

    private static Map<String, Field> weixinFieldMap = new ConcurrentHashMap<>();

    static {
        weixinFieldMap.putAll(Arrays.stream(FieldSchema.class.getDeclaredFields()).filter(f -> f.getAnnotation(WexinOpenField.class) != null)
                .collect(Collectors.toMap(f -> f.getAnnotation(WexinOpenField.class).value(), Function.identity())));
        // todo 支付宝
    }

    public Boolean isNotnull() {
        if (must.equalsIgnoreCase("是")) {
            return true;
        }
        return false;
    }

    public Map<String, Field> getWexinFieldMap() {
        return weixinFieldMap;
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
        } else if (fieldType.startsWith("Array<string") || fieldType.startsWith("array<string")) {
            return "List<String>";
        } else if (fieldType.equalsIgnoreCase("number")) {
            return "Integer";
        }
        return fieldType;
    }
}
