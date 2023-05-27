package org.dows.pay.spider.schema;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

import java.io.File;
import java.util.List;

@Data
public class ModuleSchema {
    private String name;

    private String pkg = "";

    private PomSchema pomSchema;

    private List<BeanSchema> beanSchemas;

    // 所属项目
    private ProjectSchema projectSchema;

    //子模块
    private List<ModuleSchema> childModules;

    public String getJavaPath() {
        return projectSchema.getRootPath() + File.separator + projectSchema.getName()
                + File.separator + null == name ? "" : name + File.separator + "src/main/java";
    }

    public String getResourcesPath() {
        return projectSchema.getRootPath() + File.separator + projectSchema.getName()
                + File.separator + name + File.separator + "src/main/resources";
    }

    public String getPath() {
        return getJavaPath() + File.separator + (projectSchema.getBasePkg() + pkg)
                .replaceAll("\\.", "/");
    }

    public String getPkg() {
        return projectSchema.getBasePkg() + (StrUtil.isBlank(pkg) ? "" : "." + pkg);
    }

}
