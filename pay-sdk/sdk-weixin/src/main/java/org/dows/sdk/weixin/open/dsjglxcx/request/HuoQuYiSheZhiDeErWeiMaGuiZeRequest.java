package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/getJumpQRCode.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取已设置的二维码规则
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取已设置的二维码规则Request", title = "获取已设置的二维码规则Request")
public class HuoQuYiSheZhiDeErWeiMaGuiZeRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "小程序的appid。获取“扫服务号二维码打开小程序”已设置的二维码规则才需要传这个参数。")
    private String appid;
    @Schema(title = "默认值为0。 0：查询最近新增 10000 条（数量大建议用1或者2）；1：prefix查询；2：分页查询，按新增顺序返回。获取“扫服务号二维码打开小程序”已设置的二维码规则才需要传这个参数。")
    private Integer get_type;
    @Schema(title = "prefix查询，get_type=1 必传，最多传 200 个前缀。获取“扫服务号二维码打开小程序”已设置的二维码规则才需要传这个参数。")
    private List<String> prefix_list;
    @Schema(title = "页码，get_type=2 必传，从 1 开始。获取“扫服务号二维码打开小程序”已设置的二维码规则才需要传这个参数。")
    private Integer page_num;
    @Schema(title = "每页数量，get_type=2 必传，最大为 200。获取“扫服务号二维码打开小程序”已设置的二维码规则才需要传这个参数。")
    private Integer page_size;
}

