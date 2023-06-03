package org.dows.sdk.weixin.open.ptdykf;

import org.dows.sdk.weixin.open.ptdykf.request.HuoQuXiaoXiTuiSongPeiZhiRequest;
import org.dows.sdk.weixin.open.ptdykf.request.ShangChuanXiaoXiTuiSongPeiZhiRequest;
import org.dows.sdk.weixin.open.ptdykf.response.HuoQuXiaoXiTuiSongPeiZhiResponse;
import org.dows.sdk.weixin.open.ptdykf.response.ShangChuanXiaoXiTuiSongPeiZhiResponse;

/**
 * 消息推送
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface XiaoXiTuiSongApi {

    /**
     * 上传消息推送配置
     * descr: 通过本接口可以上传消息推送配置。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/msg-push/setCallBackConfig.html
     * api: https://api.weixin.qq.com/tcb/setcallbackconfig?access_token=ACCESS_TOKEN
     *
     * @param shangChuanXiaoXiTuiSongPeiZhiRequest
     */
    ShangChuanXiaoXiTuiSongPeiZhiResponse shangChuanXiaoXiTuiSongPeiZhi(ShangChuanXiaoXiTuiSongPeiZhiRequest shangChuanXiaoXiTuiSongPeiZhiRequest);

    /**
     * 获取消息推送配置
     * descr: 通过本接口可以获取消息推送配置。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/msg-push/getCallBackConfig.html
     * api: https://api.weixin.qq.com/tcb/getcallbackconfig?access_token=ACCESS_TOKEN
     *
     * @param huoQuXiaoXiTuiSongPeiZhiRequest
     */
    HuoQuXiaoXiTuiSongPeiZhiResponse huoQuXiaoXiTuiSongPeiZhi(HuoQuXiaoXiTuiSongPeiZhiRequest huoQuXiaoXiTuiSongPeiZhiRequest);
}