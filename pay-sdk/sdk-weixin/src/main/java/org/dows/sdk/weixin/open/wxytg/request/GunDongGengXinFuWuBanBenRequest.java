package org.dows.sdk.weixin.open.wxytg.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.dows.sdk.weixin.bak.common.model.HpaPolicy;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/updateCloudbaseServiceVersion.html
 *
 * @author lait.zhang@gmail.com
 * @description 滚动更新服务版本
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "滚动更新服务版本Request", title = "滚动更新服务版本Request")
public class GunDongGengXinFuWuBanBenRequest {
    @Schema(title = "")
    private String access_token;
    @Schema(title = "环境ID")
    private String env_id;
    @Schema(title = "要替换的版本名称，可以为latest")
    private String version_name;
    @Schema(title = "枚举（package/repository/image)")
    private String upload_type;
    @Schema(title = "repository的类型(coding/gitlab/github)")
    private String repository_type;
    @Schema(title = "流量占比")
    private Integer flow_ratio;
    @Schema(title = "dockerfile地址")
    private String dockerfile_path;
    @Schema(title = "构建目录")
    private String build_dir;
    @Schema(title = "Cpu的大小，单位：核")
    private String cpu;
    @Schema(title = "Mem的大小，单位：G")
    private String mem;
    @Schema(title = "最小副本数，最小值：0")
    private String min_num;
    @Schema(title = "最大副本数")
    private String max_num;
    @Schema(title = "策略类型")
    private String policy_type;
    @Schema(title = "策略阈值")
    private String policy_threshold;
    @Schema(title = "环境变量")
    private String env_params;
    @Schema(title = "容器端口")
    private Integer container_port;
    @Schema(title = "服务名称")
    private String server_name;
    @Schema(title = "repository地址")
    private String repository;
    @Schema(title = "分支")
    private String branch;
    @Schema(title = "版本备注")
    private String version_remark;
    @Schema(title = "代码包名字")
    private String package_name;
    @Schema(title = "代码包版本")
    private String package_version;
    //    @Schema(title = "Image的详情")
//    private CloudBaseRunImageInfo image_info;
//    @Schema(title = "Github等拉取代码的详情")
//    private CloudBaseCodeRepoDetail code_detail;
    @Schema(title = "是否回放流量")
    private Boolean is_rebuild;
    @Schema(title = "延迟多长时间开始健康检查（单位s）")
    private Integer initial_delay_seconds;
    //    @Schema(title = "cfs挂载信息")
//    private List<CloudBaseRunVolumeMount> mount_volume_info;
    @Schema(title = "是否回滚")
    private Boolean rollback;
    @Schema(title = "版本历史名")
    private String snapshot_name;
    @Schema(title = "自定义采集路径")
    private String custom_logs;
    @Schema(title = "是否启用统一域名")
    private Boolean enable_union;
    @Schema(title = "服务路径（只会第一次生效）")
    private String server_path;
    @Schema(title = "是否更新Cls")
    private Boolean is_update_cls;
    @Schema(title = "自动扩缩容策略组")
    private List<HpaPolicy> policy_detail;
}

