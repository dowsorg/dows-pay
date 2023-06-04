package org.dows.sdk.weixin.open.wxytg.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.dows.sdk.weixin.bak.common.model.CloudBaseRunServiceVolumeMount;
import org.dows.sdk.weixin.bak.common.model.HpaPolicy;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/createCloudbaseServiceVersion.html
 *
 * @author lait.zhang@gmail.com
 * @description 创建服务版本
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "创建服务版本Request", title = "创建服务版本Request")
public class ChuangJianFuWuBanBenRequest {
    @Schema(title = "")
    private String access_token;
    @Schema(title = "环境ID")
    private String env_id;
    @Schema(title = "枚举（package/repository/image/jar/war)")
    private String upload_type;
    @Schema(title = "流量占比")
    private Integer flow_ratio;
    @Schema(title = "Cpu的大小，单位：核")
    private Float cpu;
    @Schema(title = "Mem的大小，单位：G")
    private Float mem;
    @Schema(title = "最小副本数，最小值：0")
    private Integer min_num;
    @Schema(title = "副本最大数，最大值：50")
    private Integer max_num;
    @Schema(title = "策略类型(枚举值：比如cpu)")
    private String policy_type;
    @Schema(title = "策略阈值")
    private Integer policy_threshold;
    @Schema(title = "服务端口")
    private Integer container_port;
    @Schema(title = "服务名称")
    private String server_name;
    @Schema(title = "repository的类型(coding/gitlab/github/coding)")
    private String repository_type;
    @Schema(title = "Dockerfile地址")
    private String dockerfile_path;
    @Schema(title = "构建目录")
    private String build_dir;
    @Schema(title = "环境变量")
    private String env_params;
    @Schema(title = "repository地址")
    private String repository;
    @Schema(title = "分支")
    private String branch;
    @Schema(title = "版本备注")
    private String version_remark;
    @Schema(title = "代码包名字")
    private String package_name;
    @Schema(title = "代码包的版本")
    private String package_version;
    //    @Schema(title = "Image的详情")
//    private CloudBaseRunImageInfo image_info;
//    @Schema(title = "Github等拉取代码的详情")
//    private CloudBaseCodeRepoDetail code_detail;
//    @Schema(title = "私有镜像秘钥信息")
//    private CloudBaseRunImageSecretInfo image_secret_info;
    @Schema(title = "私有镜像 认证名称")
    private String image_pull_secret;
    @Schema(title = "用户自定义采集日志路径")
    private String custom_logs;
    @Schema(title = "延迟多长时间开始健康检查（单位s）")
    private Integer initial_delay_seconds;
    //    @Schema(title = "cfs挂载信息")
//    private List<CloudBaseRunVolumeMount>mount_volume_info;
    @Schema(title = "4 代表只能微信链路访问")
    private Integer access_type;
    //    @Schema(title = "es信息")
//    private CloudBaseEsInfo es_info;
    @Schema(title = "是否使用统一域名")
    private Boolean enable_union;
    @Schema(title = "服务路径")
    private String server_path;
    //    @Schema(title = "容器的描述文件")
//    private List<CloudBaseRunSideSpec>sidecar_specs;
//    @Schema(title = "安全特性")
//    private CloudBaseSecurityContext security;
//    @Schema(title = "服务磁盘挂载")
//    private List<CloudRunServiceVolume>service_volumes;
    @Schema(title = "是否创建JnsGw 0未传默认创建 1创建 2不创建")
    private Integer is_create_jns_gw;
    @Schema(title = "数据卷挂载参数")
    private List<CloudBaseRunServiceVolumeMount> service_volume_mounts;
    @Schema(title = "是否有Dockerfile：0-default has, 1-has, 2-has not")
    private Integer has_dockerfile;
    @Schema(title = "基础镜像")
    private String base_image;
    @Schema(title = "容器启动入口命令")
    private String entry_point;
    @Schema(title = "仓库语言")
    private String repo_language;
    @Schema(title = "）")
    private String upload_filename;
    @Schema(title = "自动扩缩容策略组")
    private List<HpaPolicy> policy_detail;
}

