package org.dows.sdk.weixin.bak.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-api-management/applyPrivacyInterface.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "ApplyPrivacyInterfaceRequest", title = "ApplyPrivacyInterfaceRequest")
public class ApplyPrivacyInterfaceRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "申请的 api 英文名，例如wx.choosePoi，严格区分大小写")
    private String api_name;
    @Schema(title = "申请说原因，不超过300个字符；需要以utf-8编码提交，否则会出现审核失败")
    private String content;
    @Schema(title = "(辅助网页)例如，上传官网网页链接用于辅助审核")
    private List<String> url_list;
    @Schema(title = "(辅助图片)填写图片的url ，最多10个")
    private List<String> pic_list;
    @Schema(title = "(辅助视频)填写视频的链接 ，最多支持1个；视频格式只支持mp4格式")
    private List<String> video_list;
}

