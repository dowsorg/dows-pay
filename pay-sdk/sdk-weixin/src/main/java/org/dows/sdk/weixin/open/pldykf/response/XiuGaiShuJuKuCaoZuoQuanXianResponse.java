package org.dows.sdk.weixin.open.pldykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/setPermission.html
 *
 * @author lait.zhang@gmail.com
 * @description 修改数据库操作权限
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "修改数据库操作权限Response", title = "修改数据库操作权限Response")
public class XiuGaiShuJuKuCaoZuoQuanXianResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

