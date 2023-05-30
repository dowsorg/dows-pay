package org.dows.pay.spider.util;

import lombok.Data;

import java.util.List;

/**
 * 树形结构节点
 */
@Data
public class TreeNode {
    //父节点
    private Long pid;
    //唯一标识
    private Long id;
    //名称
    private String name;
    //级别
    private int level;
    //子节点
    private List<TreeNode> children;
}