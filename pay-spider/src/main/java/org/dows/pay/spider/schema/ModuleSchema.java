package org.dows.pay.spider.schema;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.dows.pay.spider.util.SchemaUtil;

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
        String spkg = "";
        if (!StrUtil.isBlank(pkg)) {
            spkg = SchemaUtil.filterBeanPkgChar(pkg);
        } else {
            spkg = SchemaUtil.getPinYinHeadChar(SchemaUtil.filterBeanNameChar(name)).toLowerCase();
        }
        return projectSchema.getBasePkg() + (StrUtil.isBlank(spkg) ? "" : "." + spkg);
    }

    public String getCode() {
        if (code != null) {
            return SchemaUtil.filterBeanNameChar(code);
            /*code.trim()
                    .replaceAll(" ", "")
                    .replaceAll("（", "")
                    .replaceAll("）", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "")
                    .replaceAll("-", "_");*/
        }
        if (!StrUtil.isBlank(name)) {
            return SchemaUtil.getPingYin(SchemaUtil.filterBeanNameChar(name));
                    /*name.trim()
                    .replaceAll(" ", "")
                    .replaceAll("（", "")
                    .replaceAll("）", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "")
                    .replaceAll("-", "_")*/
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
