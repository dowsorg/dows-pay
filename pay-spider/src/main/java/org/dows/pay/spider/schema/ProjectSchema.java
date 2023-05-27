package org.dows.pay.spider.schema;

import lombok.Data;

import java.util.List;

@Data
public class ProjectSchema {
    /**
     * 项目名
     */
    private String name;
    /**
     * path
     */
    private String rootPath;

    /**
     * basePkg
     */
    private String basePkg = "";


//    private Config config;

    private List<ModuleSchema> modules;

}
