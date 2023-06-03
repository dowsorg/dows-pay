package org.dows.sdk.weixin.open.xcxllzdyy.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/SetBlackList.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置屏蔽的广告主
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置屏蔽的广告主Request", title = "设置屏蔽的广告主Request")
public class SheZhiPingBiDeGuangGaoZhuRequest {
    @Schema(title = "1：设置屏蔽 2：删除屏蔽")
    private Integer op;
    @Schema(title = "为json序列化格式，包含屏蔽类型type及标识ID。其中，type枚举值：1：公众号，id代表公众号微信号 2：IOS应用，id代表IOS应用APPID 3：安卓应用，id代表安卓应用的应用宝包名 4：小程序/小游戏，id代表原始ID。注：屏蔽数量有上限，超过将超时报错。公众号，最多可屏蔽20个，iOS应用，最多可屏蔽10个，安卓应用，最多可屏蔽10个，小程序/小游戏，最多可屏蔽20个")
    private String list;
}

