package org.dows.sdk.weixin.open.pldykf;

import org.dows.sdk.weixin.open.pldykf.request.*;
import org.dows.sdk.weixin.open.pldykf.response.*;

/**
 * 环境管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface PldykfHuanJingGuanLiApi {

    /**
     * 转换云环境
     * descr: 通过本接口可以将腾讯云控制台创建的环境变更为微信小程序的环境。使用过程中如遇到问题，可在,发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/changeTcbEnv.html
     * api: https://api.weixin.qq.com/tcb/modifyenv?access_token=ACCESS_TOKEN
     *
     * @param zhuanHuanYunHuanJingRequest
     */
    ZhuanHuanYunHuanJingResponse zhuanHuanYunHuanJing(ZhuanHuanYunHuanJingRequest zhuanHuanYunHuanJingRequest);

    /**
     * 管理微信令牌权限
     * descr: 通过本接口可以开启或关闭cloudbase_access_token的使用权限，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/setCloudAccessToken.html
     * api: https://api.weixin.qq.com/tcb/usecloudaccesstoken?access_token=ACCESS_TOKEN
     *
     * @param guanLiWeiXinLingPaiQuanXianRequest
     */
    GuanLiWeiXinLingPaiQuanXianResponse guanLiWeiXinLingPaiQuanXian(GuanLiWeiXinLingPaiQuanXianRequest guanLiWeiXinLingPaiQuanXianRequest);

    /**
     * 查询环境共享信息
     * descr: 通过本接口可以批量查询小程序被共享的环境id，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/getShareCloudbaseEnv.html
     * api: https://api.weixin.qq.com/componenttcb/batchgetenvid?access_token=ACCESS_TOKEN
     *
     * @param chaXunHuanJingGongXiangXinXiRequest
     */
    ChaXunHuanJingGongXiangXinXiResponse chaXunHuanJingGongXiangXinXi(ChaXunHuanJingGongXiangXinXiRequest chaXunHuanJingGongXiangXinXiRequest);

    /**
     * 获取环境信息
     * descr: 通过本接口可以获取环境列表，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/getTcbEnvList.html
     * api: https://api.weixin.qq.com/componenttcb/describeenvs?access_token=ACCESS_TOKEN
     *
     * @param huoQuHuanJingXinXiRequest
     */
    HuoQuHuanJingXinXiResponse huoQuHuanJingXinXi(HuoQuHuanJingXinXiRequest huoQuHuanJingXinXiRequest);

    /**
     * 创建环境
     * descr: 通过本接口可以创建环境，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/createTcbEnv.html
     * api: https://api.weixin.qq.com/componenttcb/createenv?access_token=ACCESS_TOKEN
     *
     * @param chuangJianHuanJingRequest
     */
    ChuangJianHuanJingResponse chuangJianHuanJing(ChuangJianHuanJingRequest chuangJianHuanJingRequest);

    /**
     * 环境共享
     * descr: 通过本接口可以将环境共享给小程序（也称将小程序与环境绑定），使用过程中如遇到问题，可在,发帖交流。,服务商需将 msg_info_list 中的确认链接发送给小程序管理员，经小程序管理员确认允许绑定后，绑定正式生效。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/shareCloudbaseEnv.html
     * api: https://api.weixin.qq.com/componenttcb/batchshareenv?access_token=ACCESS_TOKEN
     *
     * @param huanJingGongXiangRequest
     */
    HuanJingGongXiangResponse huanJingGongXiang(HuanJingGongXiangRequest huanJingGongXiangRequest);
}