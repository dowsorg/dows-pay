package org.dows.pay.spider.schema;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.dows.pay.spider.util.PinyinUtil;

import java.util.ArrayList;
import java.util.List;

@Data
public class ModuleSchema {
    private String name;

    private String code;

    private String pkg = "";

    private PomSchema pomSchema;


    // 所属项目
    private ProjectSchema projectSchema;

    private final List<BeanSchema> beanSchemas = new ArrayList<>();
    //子模块
    private final List<ModuleSchema> childModules = new ArrayList<>();

    public void addBeanSchema(BeanSchema beanSchema) {
        this.beanSchemas.add(beanSchema);
    }

    public String getJavaPath() {
        return projectSchema.getRootPath() + "/" + projectSchema.getName()
                + "/" + (null == code ? "" : code) + "/" + "src/main/java";
    }

    public String getResourcesPath() {
        return projectSchema.getRootPath() + "/" + projectSchema.getName()
                + "/" + (null == code ? "" : code) + "/" + "src/main/resources";
    }

    public String getPath() {
        return getJavaPath()/* + "/" + (projectSchema.getBasePkg() + pkg)
                .replaceAll("\\.", "/")*/;
    }

    public String getPkg() {
        return projectSchema.getBasePkg() + (StrUtil.isBlank(pkg) ? "" : "."
                + pkg.trim().replaceAll("/", ".").replaceAll("-", "."));
    }

    public String getCode() {
        if(code != null){
            return code.trim();
        }
        if (!StrUtil.isBlank(name)) {
            return PinyinUtil.getPingYin(name.trim());
        }
        return null;
    }

    public void addModule(ModuleSchema moduleSchema) {
        childModules.add(moduleSchema);
    }


    @Override
    public String toString() {
        return "ModuleSchema{" +
                "name='" + name + '\'' +
                ", pkg='" + pkg + '\'' +
                '}';
    }
}
