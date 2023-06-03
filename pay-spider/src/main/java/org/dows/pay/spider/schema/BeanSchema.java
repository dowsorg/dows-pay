package org.dows.pay.spider.schema;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.dows.pay.spider.model.schema.ApiSchema;
import org.dows.pay.spider.util.SchemaUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class BeanSchema {

    /**
     * bean名称
     */
    private String name;

    /**
     * bean code
     */
    private String code;
    /**
     * interface|class|annotation....
     */
    private String type;
    /**
     * 描述
     */
    private String descr;
    /**
     * 包
     */
    private String pkg;

    /**
     * 统一后缀
     */
    private String suffix;

    /**
     * 泛型类型: String -> <String>, String, Object -> <String, Object>, Map<String, Object> -> <Map<String, Object>>
     */
    private String genericTyp;

    /**
     * 父类
     */
    private BeanSchema parentClass;

    // 所属模块
    private ModuleSchema module;
    /**
     * 需要导入的包
     */
    private final List<String> imports = new ArrayList<>();


    private final List<FieldSchema> fields = new ArrayList<>();

    /**
     * 请求方法
     */
    private final List<MethodSchema> methods = new ArrayList<>();

    /**
     * 继承接口
     */
    private final List<BeanSchema> superInterfaces = new ArrayList<>();


    private final static Map<String, Field> fieldMap = new ConcurrentHashMap<>();


    static {
        fieldMap.putAll(Arrays.stream(ApiSchema.class.getDeclaredFields()).collect(Collectors.toMap(f -> f.getName(), Function.identity())));
    }

    public BeanSchema() {

    }

    /**
     * @param map
     */
    public BeanSchema(Map<String, Object> map) {
        map.forEach((k, v) -> {
            Field field = fieldMap.get(k);
            if (field != null) {
                field.setAccessible(true);
                try {
                    field.set(this, v);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


    public BeanSchema addField(FieldSchema fieldSchema) {
        this.fields.add(fieldSchema);
        return this;
    }

    public BeanSchema addMethod(MethodSchema methodSchema) {
        this.methods.add(methodSchema);
        return this;
    }

    /**
     * 转驼峰
     *
     * @return
     */
/*    public String getName() {
        return StrUtil.toCamelCase(name.replaceAll("-", "_")) + "Api";
    }*/
    public void setPkg(String pkg) {
        String s = SchemaUtil.filterBeanPkgChar(pkg);
        this.pkg = SchemaUtil.getPinYinHeadChar(s);
    }

    /**
     * 如若自定义code 可在setName后setCode(xxx)
     *
     * @param name
     */
    public void setName(String name) {
        this.name = SchemaUtil.filterBeanNameChar(name);
        String nn = StrUtil.toCamelCase(this.name) + "Api";
        this.code = SchemaUtil.getPingYin(nn);
    }

    public String getPkg() {
        if (module != null) {
            return (null == module.getPkg() ? "" : module.getPkg()) + (StrUtil.isBlank(pkg) ? "" : "." + pkg);
        }
        return (StrUtil.isBlank(pkg) ? "" : "." + pkg);
    }

    public String getPath() {
        if (module != null) {
            return (null == module.getPath() ? "" : module.getPath()) + "/" + getPkg().replaceAll("\\.", "/");
        }
        return getPkg().replaceAll("\\.", "/");
    }

    public List<MethodSchema> getMethods() {
        return this.methods;
    }

    public List<FieldSchema> getFields() {
        return this.fields;
    }

    @Override
    public String toString() {
        return "BeanSchema{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", descr='" + descr + '\'' +
                ", pkg='" + pkg + '\'' +
                ", suffix='" + suffix + '\'' +
                ", genericTyp='" + genericTyp + '\'' +
                ", fields=" + fields +
                ", superInterfaces=" + superInterfaces +
                '}';
    }
}
