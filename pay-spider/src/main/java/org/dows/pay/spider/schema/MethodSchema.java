package org.dows.pay.spider.schema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dows.pay.spider.AlipayField;
import org.dows.pay.spider.WexinField;
import org.dows.pay.spider.model.schema.FieldSchema;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MethodSchema {
    /**
     * 方法名
     */
    @AlipayField("")
    @WexinField("属性")
    private String name;
    /**
     * 方法描述
     */
    private String descr;

    /**
     * 方法url
     */
    @AlipayField("")
    @WexinField("属性")
    private String url;
    /**
     * 支持http请求类型
     */
    private String httpMethod;
    /**
     * 是否 restful 风格 API
     */
    private String restMethod;
    /**
     * 接口方法im，类方法cm
     */
    private String methodType;
    /**
     * 方法注释
     */
    //private final Set<Annot> annotations = new LinkedHashSet<>();

    /**
     * 方法泛型值: T -> public <T> 方法返回值 方法名称(方法参数);
     */
    private String genericVal;

    /**
     * 方法请求入参
     */
    private final List<ParamSchema> inputs = new ArrayList<>();
    /**
     * 方法返回值或出参
     */
    private ParamSchema output;


    public String getName() {
        return name.trim();
    }

    public MethodSchema addInput(ParamSchema paramInfo) {
        inputs.add(paramInfo);
        return this;
    }

    public MethodSchema addInputs(List<ParamSchema> paramInfos) {
        inputs.addAll(paramInfos);
        return this;
    }


    private final static Map<String, Field> weixinMethodMap = new ConcurrentHashMap<>();

    static {
        weixinMethodMap.putAll(Arrays.stream(FieldSchema.class.getDeclaredFields()).filter(f -> f.getAnnotation(WexinField.class) != null)
                .collect(Collectors.toMap(f -> f.getAnnotation(WexinField.class).value(), Function.identity())));
        // todo 支付宝
    }

    public Map<String, Field> getWeixinMethodMap() {
        return weixinMethodMap;
    }

    public void setFieldValue(String filed, Object val) {
        Field field = weixinMethodMap.get(filed);
        if (field != null) {
            try {
                field.set(this, val);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
