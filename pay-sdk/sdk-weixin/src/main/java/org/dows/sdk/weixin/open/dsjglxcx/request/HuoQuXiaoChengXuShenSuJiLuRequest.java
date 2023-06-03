package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/record-management/getAppealRecords.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取小程序申诉记录
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取小程序申诉记录Request", title = "获取小程序申诉记录Request")
public class HuoQuXiaoChengXuShenSuJiLuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "违规处罚记录id（通过getillegalrecords接口返回的记录id）")
    private String illegal_record_id;
}

