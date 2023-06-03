package org.dows.pay.spider.schema;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dows.pay.spider.AlipayField;
import org.dows.pay.spider.WexinOpenField;
import org.dows.pay.spider.util.SchemaUtil;

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
    @WexinOpenField("name")
    private String name;

    /**
     * 方法code
     */
    private String code;
    /**
     * 方法描述
     */
    @AlipayField("")
    @WexinOpenField("descr")
    private String descr;

    @WexinOpenField("overview")
    private String overview;

    /**
     * 方法url
     */
    @AlipayField("")
    @WexinOpenField("url")
    private String url;

    /**
     * 方法文档url
     */
    private String docUrl;
    /**
     * 支持http请求类型
     */
    @AlipayField("")
    @WexinOpenField("httpMethod")
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
    private ParamSchema output = new ParamSchema();

    /**
     *
     */
    private BeanSchema beanSchema;

    public String getName() {
        return name.trim();
    }

    public String getCode() {
        if(code != null){
            return code.trim().replace(" ","");
        }
        if (!StrUtil.isBlank(name)) {
            return SchemaUtil.getPingYin(name.trim().replace(" ",""));
        }
        return null;
    }

    public MethodSchema addInput(ParamSchema paramInfo) {
        inputs.add(paramInfo);
        return this;
    }

    public MethodSchema addInputs(List<ParamSchema> paramInfos) {
        inputs.addAll(paramInfos);
        return this;
    }


    private final static Map<String, Field> methodFieldMap = new ConcurrentHashMap<>();

    static {

        /*
        weixinMethodMap.putAll(Arrays.stream(MethodSchema.class.getDeclaredFields()).filter(f -> f.getAnnotation(WexinOpenField.class) != null)
                .collect(Collectors.toMap(f -> f.getAnnotation(WexinOpenField.class).value(), Function.identity())));
        // todo 支付宝
        */
        methodFieldMap.putAll(Arrays.stream(MethodSchema.class.getDeclaredFields())
                .collect(Collectors.toMap(f -> f.getName(), Function.identity())));
    }


    public void setFieldValue(String filed, Object val) {
        Field field = methodFieldMap.get(filed);
        if (field != null) {
            try {
                field.set(this, val);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getWeixinUrl() {
        return url == null ? "" : url.substring(url.indexOf(" ") + 1);
    }

    public String getWeixinDocUrl() {
        return docUrl == null ? "" : docUrl.substring(docUrl.indexOf(" ") + 1);
    }

    public String getWeixinHttpMethod() {
        return url == null ? "" : url.substring(0, url.indexOf(" "));
    }


    @Override
    public String toString() {
        return "MethodSchema{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", descr='" + descr + '\'' +
                ", overview='" + overview + '\'' +
                ", url='" + url + '\'' +
                ", docUrl='" + docUrl + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", restMethod='" + restMethod + '\'' +
                ", methodType='" + methodType + '\'' +
                ", genericVal='" + genericVal + '\'' +
                '}';
    }
}
