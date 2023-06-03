package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getCodePage.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取已上传的代码页面列表
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取已上传的代码页面列表Response", title = "获取已上传的代码页面列表Response")
public class HuoQuYiShangChuanDeDaiMaYeMianLieBiaoResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "page_list 页面配置列表")
    private List<String> page_list;
}

