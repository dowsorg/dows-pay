package org.dows.pay.spider.model.schema;

import cn.hutool.core.util.StrUtil;
import lombok.Builder;
import lombok.Data;
import org.springframework.cglib.core.MethodInfo;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class InterfaceSchema {
    /**
     * 接口名
     */
    private String name;
    /**
     * 接口描述
     */
    private String descr;
    /**
     * 所在包
     */
    private String pkg;


    /**
     * 泛型类型: String -> <String>, String, Object -> <String, Object>, Map<String, Object> -> <Map<String, Object>>
     */
    private String genericTyp;

    /**
     * api || rest
     */
    private String interfaceType;

    /**
     * 统一后缀
     */
    private String stuffix;

    /**
     * 需要导入的包
     */
    private final List<String> imports = new ArrayList<>();
    /**
     * 接口注解
     */
    //private final Set<Annot> annotations = new LinkedHashSet<>();
    /**
     * 请求方法
     */
    private final List<MethodSchema> methods = new ArrayList<>();
    /**
     * 存储从入参数中解析出的字段 Model 类型
     */
    private final List<Model> inModels = new ArrayList<>();
    /**
     * 存储从出参数中解析出的字段 Model 类型
     */
    private final List<Model> outModels = new ArrayList<>();

    /**
     * 继承接口
     */
    private final List<InterfaceSchema> superInterfaces = new ArrayList<>();



    public String getNameStuffix() {
        return name + stuffix;
    }

    public String getName() {
        return StrUtil.upperFirst(name);
    }

    public InterfaceSchema addMethodInfo(MethodSchema methodInfo) {
        methods.add(methodInfo);
        return this;
    }

    public InterfaceSchema addMethodInfos(List<MethodSchema> methodInfos) {
        methods.addAll(methodInfos);
        return this;
    }

    public InterfaceSchema addImport(String imports) {
        this.imports.add(imports);
        return this;
    }
}
