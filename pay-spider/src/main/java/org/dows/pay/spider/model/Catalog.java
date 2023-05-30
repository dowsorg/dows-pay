package org.dows.pay.spider.model;

import lombok.Data;
import org.dows.pay.spider.util.Treeable;

import java.util.ArrayList;
import java.util.List;

@Data
public class Catalog implements Treeable {
    private Long id;
    private Long pid;
    private String name;
    private String icon;
    private String href;
    // 包
    private String pkg;
    // 类型：dir|pgk or file|bean
    private String type;
    // 父节点
    private Catalog patent;
    // 孩子节点
    private final List<Catalog> childs = new ArrayList<>();

    //private final static Map<String, BeanSchema> beanSchemaMap = new HashMap<>();
    public void addChild(Catalog catalog) {
        childs.add(catalog);
    }


    public String getUrl(String prefix) {
        if (href.startsWith("http")) {
            return href;
        } else {
            return prefix + "/" + href;
        }
    }


    public String getWeixinPayDocUrl() {
        if (href.startsWith("http")) {
            return href;
        } else {
            return "https://pay.weixin.qq.com/wiki/doc/apiv3/apis/" + href;
        }
    }

    public String getPkg() {
        if (patent != null) {
            return patent.getPkg() + (pkg == null ? "" : "." + pkg);
        }
        return pkg;
    }

    public String getName() {
        if (patent != null) {
            return patent.getName() + (name == null ? "" : "." + name);
        }
        return name;
    }
}
