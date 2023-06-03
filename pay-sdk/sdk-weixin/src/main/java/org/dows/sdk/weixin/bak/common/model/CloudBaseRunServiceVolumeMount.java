package org.dows.sdk.weixin.bak.common.model;

import lombok.Data;

@Data
public class CloudBaseRunServiceVolumeMount {
    //Volume 名称
    private String name;
    //挂载路径
    private String mount_path;
    //是否只读
    private Boolean read_only;
    //子路径
    private String sub_path;
    //传播挂载方式
    private String mount_propagation;
}
