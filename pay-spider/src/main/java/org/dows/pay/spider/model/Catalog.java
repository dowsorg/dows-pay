package org.dows.pay.spider.model;

import lombok.Data;

import java.util.List;

@Data
public class Catalog {
    private String catalogName;
    private List<MenuInfo> menuInfos;
    // 孩子节点
    private List<Catalog>  catalogs;



}
