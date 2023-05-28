package org.dows.pay.spider.schema;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class ModuleSchema {
    private String name;

    private String pkg = "";

    private PomSchema pomSchema;


    // 所属项目
    private ProjectSchema projectSchema;

    private final List<BeanSchema> beanSchemas = new ArrayList<>();
    //子模块
    private List<ModuleSchema> childModules;

    public void addBeanSchema(BeanSchema beanSchema) {
        this.beanSchemas.add(beanSchema);
    }

    public String getJavaPath() {
        return projectSchema.getRootPath() + "/" + projectSchema.getName()
                + "/" + (null == name ? "" : name) + "/" + "src/main/java";
    }

    public String getResourcesPath() {
        return projectSchema.getRootPath() + "/" + projectSchema.getName()
                + "/" + (null == name ? "" : name) + "/" + "src/main/resources";
    }

    public String getPath() {
        return getJavaPath()/* + "/" + (projectSchema.getBasePkg() + pkg)
                .replaceAll("\\.", "/")*/;
    }

    public String getPkg() {
        return projectSchema.getBasePkg() + (StrUtil.isBlank(pkg) ? "" : "."
                + pkg.replaceAll("/", ".").replaceAll("-", "."));
    }

}
