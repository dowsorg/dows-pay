package org.dows.sdk.weixin.open.wxytg;

import org.dows.sdk.weixin.open.wxytg.request.*;
import org.dows.sdk.weixin.open.wxytg.response.*;

/**
 * 环境管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface WxytgHuanJingGuanLiApi {

    /**
     * 查询环境共享信息
     * descr: 通过本接口可以批量查询小程序被共享的环境id，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/getShareCloudbaseEnv.html
     * api: https://api.weixin.qq.com/componenttcb/batchgetenvid?access_token=ACCESS_TOKEN
     *
     * @param chaXunHuanJingGongXiangXinXiRequest
     */
    ChaXunHuanJingGongXiangXinXiResponse chaXunHuanJingGongXiangXinXi(ChaXunHuanJingGongXiangXinXiRequest chaXunHuanJingGongXiangXinXiRequest);

    /**
     * 环境共享
     * descr: 通过本接口可以将环境共享给小程序（也称将小程序与环境绑定），使用过程中如遇到问题，可在,发帖交流。,服务商需将 msg_info_list 中的确认链接发送给小程序管理员，经小程序管理员确认允许绑定后，绑定正式生效。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/shareCloudbaseEnv.html
     * api: https://api.weixin.qq.com/componenttcb/batchshareenv?access_token=ACCESS_TOKEN
     *
     * @param huanJingGongXiangRequest
     */
    HuanJingGongXiangResponse huanJingGongXiang(HuanJingGongXiangRequest huanJingGongXiangRequest);

    /**
     * 获取环境信息
     * descr: 通过本接口可以查询微信云托管环境信息，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/getWxCloudBaseRunEnvs.html
     * api: https://api.weixin.qq.com/componenttcb/describecloudbaserunenvs?access_token=ACCESS_TOKEN
     *
     * @param huoQuHuanJingXinXiRequest
     */
    HuoQuHuanJingXinXiResponse huoQuHuanJingXinXi(HuoQuHuanJingXinXiRequest huoQuHuanJingXinXiRequest);

    /**
     * 创建云托管环境
     * descr: 通过本接口可以创建微信云托管环境，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/createCloudbaseEnv.html
     * api: https://api.weixin.qq.com/componenttcb/createcloudbaserunenv?access_token=ACCESS_TOKEN
     *
     * @param chuangJianYunTuoGuanHuanJingRequest
     */
    ChuangJianYunTuoGuanHuanJingResponse chuangJianYunTuoGuanHuanJing(ChuangJianYunTuoGuanHuanJingRequest chuangJianYunTuoGuanHuanJingRequest);

    /**
     * 解除环境共享关联关系
     * descr: 通过本接口可以解除和对应小程序环境共享关联关系（也称将小程序解除环境绑定），使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/unshareCloudbaseEnv.html
     * api: https://api.weixin.qq.com/componenttcb/batchunshareenv?access_token=ACCESS_TOKEN
     *
     * @param jieChuHuanJingGongXiangGuanLianGuanXiRequest
     */
    JieChuHuanJingGongXiangGuanLianGuanXiResponse jieChuHuanJingGongXiangGuanLianGuanXi(JieChuHuanJingGongXiangGuanLianGuanXiRequest jieChuHuanJingGongXiangGuanLianGuanXiRequest);
}