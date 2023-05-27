package org.dows.pay.spider.handler;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private String id;
    private String name;
    private WeixinLinkSchema linkSchema;

    private List<Menu> childs;

}
