package org.dows.pay.spider.util;

/**
 * 平铺数据结构方法
 */
public interface Treeable {
    //    获取节点ID
    Long getId();

    //    获取节点名称
    String getName();

    //    获取父节点ID
    Long getPid();

}
