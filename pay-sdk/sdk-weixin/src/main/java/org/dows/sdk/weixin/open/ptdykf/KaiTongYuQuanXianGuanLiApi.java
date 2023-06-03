package org.dows.sdk.weixin.open.ptdykf;

import org.dows.sdk.weixin.open.ptdykf.request.ChaXunShiFouBangDingShouJiHaoRequest;
import org.dows.sdk.weixin.open.ptdykf.request.GuanLiWeiXinLingPaiQuanXianRequest;
import org.dows.sdk.weixin.open.ptdykf.request.HuoQuTengXunYunAPIDiaoYongPingZhengRequest;
import org.dows.sdk.weixin.open.ptdykf.request.KaiTongYunKaiFaRequest;
import org.dows.sdk.weixin.open.ptdykf.response.ChaXunShiFouBangDingShouJiHaoResponse;
import org.dows.sdk.weixin.open.ptdykf.response.GuanLiWeiXinLingPaiQuanXianResponse;
import org.dows.sdk.weixin.open.ptdykf.response.HuoQuTengXunYunAPIDiaoYongPingZhengResponse;
import org.dows.sdk.weixin.open.ptdykf.response.KaiTongYunKaiFaResponse;

/**
 * 开通与权限管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface KaiTongYuQuanXianGuanLiApi {

    /**
     * 管理微信令牌权限
     * descr: 通过本接口可以开启或关闭cloudbase_access_token的使用权限，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/setCloudAccessToken.html
     * api: https://api.weixin.qq.com/tcb/usecloudaccesstoken?access_token=ACCESS_TOKEN
     *
     * @param guanLiWeiXinLingPaiQuanXianRequest
     */
    GuanLiWeiXinLingPaiQuanXianResponse guanLiWeiXinLingPaiQuanXian(GuanLiWeiXinLingPaiQuanXianRequest guanLiWeiXinLingPaiQuanXianRequest);

    /**
     * 开通云开发
     * descr: 通过本接口可以开通云开发。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/createCloudUser.html
     * api: https://api.weixin.qq.com/tcb/createclouduser?access_token=ACCESS_TOKEN
     *
     * @param kaiTongYunKaiFaRequest
     */
    KaiTongYunKaiFaResponse kaiTongYunKaiFa(KaiTongYunKaiFaRequest kaiTongYunKaiFaRequest);

    /**
     * 获取腾讯云API调用凭证
     * descr: 1、该接口有频率限制: 10次每小时。,2、腾讯云 API 调用说明
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/getCloudToken.html
     * api: https://api.weixin.qq.com/tcb/getqcloudtoken?access_token=ACCESS_TOKEN
     *
     * @param huoQuTengXunYunAPIDiaoYongPingZhengRequest
     */
    HuoQuTengXunYunAPIDiaoYongPingZhengResponse huoQuTengXunYunAPIDiaoYongPingZheng(HuoQuTengXunYunAPIDiaoYongPingZhengRequest huoQuTengXunYunAPIDiaoYongPingZhengRequest);

    /**
     * 查询是否绑定手机号
     * descr: 通过本接口可以查询小程序是否绑定了手机号，并支持推送模版消息给小程序管理员收集手机号。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/checkMobileConfig.html
     * api: https://api.weixin.qq.com/tcb/checkmobile?access_token=ACCESS_TOKEN
     *
     * @param chaXunShiFouBangDingShouJiHaoRequest
     */
    ChaXunShiFouBangDingShouJiHaoResponse chaXunShiFouBangDingShouJiHao(ChaXunShiFouBangDingShouJiHaoRequest chaXunShiFouBangDingShouJiHaoRequest);
}