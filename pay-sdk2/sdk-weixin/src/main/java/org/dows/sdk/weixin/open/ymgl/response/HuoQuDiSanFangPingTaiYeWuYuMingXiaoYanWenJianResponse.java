package org.dows.sdk.weixin.open1.ymgl.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/getThirdpartyJumpDomainConfirmFile.html
 * @description 获取第三方平台业务域名校验文件
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "获取第三方平台业务域名校验文件Response", title = "获取第三方平台业务域名校验文件Response")
public class HuoQuDiSanFangPingTaiYeWuYuMingXiaoYanWenJianResponse{
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "文件名")
    private String file_name;
    @Schema(title = "文件内容")
    private String file_content;
}

