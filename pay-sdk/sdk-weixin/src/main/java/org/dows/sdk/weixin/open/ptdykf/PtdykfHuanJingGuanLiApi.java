package org.dows.sdk.weixin.open.ptdykf;

import org.dows.sdk.weixin.open.ptdykf.request.ChuangJianYunHuanJingRequest;
import org.dows.sdk.weixin.open.ptdykf.request.HuanJingGongXiangRequest;
import org.dows.sdk.weixin.open.ptdykf.request.HuoQuYunHuanJingRequest;
import org.dows.sdk.weixin.open.ptdykf.request.ZhuanHuanYunHuanJingRequest;
import org.dows.sdk.weixin.open.ptdykf.response.ChuangJianYunHuanJingResponse;
import org.dows.sdk.weixin.open.ptdykf.response.HuanJingGongXiangResponse;
import org.dows.sdk.weixin.open.ptdykf.response.HuoQuYunHuanJingResponse;
import org.dows.sdk.weixin.open.ptdykf.response.ZhuanHuanYunHuanJingResponse;

/**
 * 环境管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface PtdykfHuanJingGuanLiApi {

    /**
     * 转换云环境
     * descr: 通过本接口可以将腾讯云控制台创建的环境变更为微信小程序的环境。使用过程中如遇到问题，可在,发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/env-management/changeTcbEnv.html
     * api: https://api.weixin.qq.com/tcb/modifyenv?access_token=ACCESS_TOKEN
     *
     * @param zhuanHuanYunHuanJingRequest
     */
    ZhuanHuanYunHuanJingResponse zhuanHuanYunHuanJing(ZhuanHuanYunHuanJingRequest zhuanHuanYunHuanJingRequest);

    /**
     * 创建云环境
     * descr: 通过本接口可以创建云环境。使用过程中如遇到问题，可在,发帖交流。,请注意，旧版,调整至当前接口，请开发者逐步进行接口切换。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/env-management/createEnv.html
     * api: https://api.weixin.qq.com/tcb/createenvandresource?access_token=ACCESS_TOKEN
     *
     * @param chuangJianYunHuanJingRequest
     */
    ChuangJianYunHuanJingResponse chuangJianYunHuanJing(ChuangJianYunHuanJingRequest chuangJianYunHuanJingRequest);

    /**
     * 获取云环境
     * descr: 通过本接口可以获取已有的云环境信息。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/env-management/getEnvInfo.html
     * api: https://api.weixin.qq.com/tcb/getenvinfo?access_token=ACCESS_TOKEN
     *
     * @param huoQuYunHuanJingRequest
     */
    HuoQuYunHuanJingResponse huoQuYunHuanJing(HuoQuYunHuanJingRequest huoQuYunHuanJingRequest);

    /**
     * 环境共享
     * descr: 通过本接口可以环境共享。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/env-management/shareEnv.html
     * api: https://api.weixin.qq.com/tcb/shareenv?access_token=ACCESS_TOKEN
     *
     * @param huanJingGongXiangRequest
     */
    HuanJingGongXiangResponse huanJingGongXiang(HuanJingGongXiangRequest huanJingGongXiangRequest);
}