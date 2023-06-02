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

    public String getWxPayDocUrl() {
        if (href.startsWith("http")) {
            return href;
        } else {
            return "https://pay.weixin.qq.com/wiki/doc/apiv3/apis/" + href;
        }
    }

    public String getWxOpenDocUrl() {
        if (href.startsWith("http")) {
            return href;
        } else {
            return "https://developers.weixin.qq.com" + href;
        }
    }

    public String getDyOpenDocUrl() {
        if (href.startsWith("http")) {
            return href;
        } else {
            return "https://partner.open-douyin.com" + href;
        }
    }

    public String getFullPkg() {
        if (patent != null) {
            return patent.getPkg() + (pkg == null ? "" : "." + pkg);
        }
        return pkg;
    }

    public String getFullName() {
        if (patent != null) {
            return patent.getName() + (name == null ? "" : "." + name);
        }
        return name;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", href='" + href + '\'' +
                ", pkg='" + pkg + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
