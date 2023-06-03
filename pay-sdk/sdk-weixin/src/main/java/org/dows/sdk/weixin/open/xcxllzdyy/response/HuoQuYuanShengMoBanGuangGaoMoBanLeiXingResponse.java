package org.dows.sdk.weixin.open.xcxllzdyy.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/AgencyGetTmplType.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取原生模板广告模板类型
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取原生模板广告模板类型Response", title = "获取原生模板广告模板类型Response")
public class HuoQuYuanShengMoBanGuangGaoMoBanLeiXingResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
    @Schema(title = "模板类型：5全屏模板，6竖版上图下文，7竖版上文下图，12竖版上图下文叠加A，13竖版上图下文叠加B，2横幅上图下文，3横幅下图上文，4横板上图下文叠加A，11横板上图下文叠加B，9横幅左图右文，10横幅右图左文，20横幅单图，100001单格子无动画，100002单格子有动画，100003多格子无轮播，100004多格子有轮播，100005矩阵格子展示型，100006矩阵格子触发型，15看一看沉浸式，14小年糕自适应，23支付页面定制")
    private Integer tmpl_type;
}

