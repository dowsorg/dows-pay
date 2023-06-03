package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.BangDingTiYanZheRequest;
import org.dows.sdk.weixin.open.dsjglxcx.request.HuoQuTiYanZheLieBiaoRequest;
import org.dows.sdk.weixin.open.dsjglxcx.request.JieChuBangDingTiYanZheRequest;
import org.dows.sdk.weixin.open.dsjglxcx.response.BangDingTiYanZheResponse;
import org.dows.sdk.weixin.open.dsjglxcx.response.HuoQuTiYanZheLieBiaoResponse;
import org.dows.sdk.weixin.open.dsjglxcx.response.JieChuBangDingTiYanZheResponse;

/**
 * 小程序成员管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface XiaoChengXuChengYuanGuanLiApi {

    /**
     * 绑定体验者
     * descr: 如果运营者同时也是该小程序的管理员，则无需绑定，管理员默认有体验权限。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/member-management/bindTester.html
     * api: https://api.weixin.qq.com/wxa/bind_tester?access_token=ACCESS_TOKEN
     *
     * @param bangDingTiYanZheRequest
     */
    BangDingTiYanZheResponse bangDingTiYanZhe(BangDingTiYanZheRequest bangDingTiYanZheRequest);

    /**
     * 解除绑定体验者
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/member-management/unbindTester.html
     * api: https://api.weixin.qq.com/wxa/unbind_tester?access_token=ACCESS_TOKEN
     *
     * @param jieChuBangDingTiYanZheRequest
     */
    JieChuBangDingTiYanZheResponse jieChuBangDingTiYanZhe(JieChuBangDingTiYanZheRequest jieChuBangDingTiYanZheRequest);

    /**
     * 获取体验者列表
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/member-management/getTester.html
     * api: https://api.weixin.qq.com/wxa/memberauth?access_token=ACCESS_TOKEN
     *
     * @param huoQuTiYanZheLieBiaoRequest
     */
    HuoQuTiYanZheLieBiaoResponse huoQuTiYanZheLieBiao(HuoQuTiYanZheLieBiaoRequest huoQuTiYanZheLieBiaoRequest);
}