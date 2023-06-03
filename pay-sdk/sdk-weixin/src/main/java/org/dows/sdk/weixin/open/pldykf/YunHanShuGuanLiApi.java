package org.dows.sdk.weixin.open.pldykf;

import org.dows.sdk.weixin.open.pldykf.request.*;
import org.dows.sdk.weixin.open.pldykf.response.*;

/**
 * 云函数管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface YunHanShuGuanLiApi {

    /**
     * 创建云函数
     * descr: 通过本接口可以批量创建云函数，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/batchuUloadCloudFunction.html
     * api: https://api.weixin.qq.com/componenttcb/batchuploadscf?access_token=ACCESS_TOKEN
     *
     * @param chuangJianYunHanShuRequest
     */
    ChuangJianYunHanShuResponse chuangJianYunHanShu(ChuangJianYunHanShuRequest chuangJianYunHanShuRequest);

    /**
     * 更新云函数配置
     * descr: 通过本接口可以更新云函数配置，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/uploadCloudFunctionConfig.html
     * api: https://api.weixin.qq.com/componenttcb/updatescfconfig?access_token=ACCESS_TOKEN
     *
     * @param gengXinYunHanShuPeiZhiRequest
     */
    GengXinYunHanShuPeiZhiResponse gengXinYunHanShuPeiZhi(GengXinYunHanShuPeiZhiRequest gengXinYunHanShuPeiZhiRequest);

    /**
     * 删除云函数
     * descr: 通过本接口可以删除云函数，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/deleteCloudFunction.html
     * api: https://api.weixin.qq.com/componenttcb/deletescf?access_token=ACCESS_TOKEN
     *
     * @param shanChuYunHanShuRequest
     */
    ShanChuYunHanShuResponse shanChuYunHanShu(ShanChuYunHanShuRequest shanChuYunHanShuRequest);

    /**
     * 获取云函数
     * descr: 通过本接口可以获取云函数列表，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/getCloudFunctionList.html
     * api: https://api.weixin.qq.com/componenttcb/getscflist?access_token=ACCESS_TOKEN
     *
     * @param huoQuYunHanShuRequest
     */
    HuoQuYunHanShuResponse huoQuYunHanShu(HuoQuYunHanShuRequest huoQuYunHanShuRequest);

    /**
     * 获取触发器
     * descr: 通过本接口可以获取触发器，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/getTriggers.html
     * api: https://api.weixin.qq.com/componenttcb/gettriggers?access_token=ACCESS_TOKEN
     *
     * @param huoQuChuFaQiRequest
     */
    HuoQuChuFaQiResponse huoQuChuFaQi(HuoQuChuFaQiRequest huoQuChuFaQiRequest);

    /**
     * 更新触发器
     * descr: 通过本接口可以批量更新触发器，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/updateTriggers.html
     * api: https://api.weixin.qq.com/componenttcb/batchupdatetriggers?access_token=ACCESS_TOKEN
     *
     * @param gengXinChuFaQiRequest
     */
    GengXinChuFaQiResponse gengXinChuFaQi(GengXinChuFaQiRequest gengXinChuFaQiRequest);

    /**
     * 触发云函数
     * descr: 通过本接口可以触发云函数。 使用过程中如遇到问题，可在,发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/invokeCloudFunction.html
     * api: New https://api.weixin.qq.com/tcb/invokecloudfunction?access_token=ACCESS_TOKEN
     *
     * @param chuFaYunHanShuRequest
     */
    ChuFaYunHanShuResponse chuFaYunHanShu(ChuFaYunHanShuRequest chuFaYunHanShuRequest);

    /**
     * 更新云函数代码
     * descr: 通过本接口可以批量更新云函数代码
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/uploadCloudFunctionCode.html
     * api: https://api.weixin.qq.com/componenttcb/batchuploadscfcode?access_token=ACCESS_TOKEN
     *
     * @param gengXinYunHanShuDaiMaRequest
     */
    GengXinYunHanShuDaiMaResponse gengXinYunHanShuDaiMa(GengXinYunHanShuDaiMaRequest gengXinYunHanShuDaiMaRequest);
}