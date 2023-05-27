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
    private final List<MethodInfo> methods = new ArrayList<>();
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
    /**
     * 接口类目
     */
    private String name;

    private String pkg;
    /**
     * 接口描述
     */
    private String descr;

    /**
     * 泛型类型: String -> <String>, String, Object -> <String, Object>, Map<String, Object> -> <Map<String, Object>>
     */
    private String genericTyp;

    /**
     * api || rest
     */
    private String interfaceType;

    private String stuffix;


    public String getNameStuffix() {
        return name + stuffix;
    }

    public String getName() {
        return StrUtil.upperFirst(name);
    }

    public InterfaceSchema addMethodInfo(MethodInfo methodInfo) {
        methods.add(methodInfo);
        return this;
    }

    public InterfaceSchema addMethodInfos(List<MethodInfo> methodInfos) {
        methods.addAll(methodInfos);
        return this;
    }

    public InterfaceSchema addImport(String imports) {
        this.imports.add(imports);
        return this;
    }
}
