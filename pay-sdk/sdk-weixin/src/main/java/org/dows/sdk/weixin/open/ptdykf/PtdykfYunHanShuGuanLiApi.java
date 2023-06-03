package org.dows.sdk.weixin.open.ptdykf;

import org.dows.sdk.weixin.open.ptdykf.request.*;
import org.dows.sdk.weixin.open.ptdykf.response.*;

/**
 * 云函数管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface PtdykfYunHanShuGuanLiApi {

    /**
     * 触发云函数
     * descr: 通过本接口可以触发云函数。 使用过程中如遇到问题，可在,发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/invokeCloudFunction.html
     * api: New https://api.weixin.qq.com/tcb/invokecloudfunction?access_token=ACCESS_TOKEN
     *
     * @param chuFaYunHanShuRequest
     */
    ChuFaYunHanShuResponse chuFaYunHanShu(ChuFaYunHanShuRequest chuFaYunHanShuRequest);

    /**
     * 创建云函数
     * descr: 通过本接口可以创建云函数。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/createFunction.html
     * api: https://api.weixin.qq.com/tcb/createfunction?access_token=ACCESS_TOKEN
     *
     * @param chuangJianYunHanShuRequest
     */
    ChuangJianYunHanShuResponse chuangJianYunHanShu(ChuangJianYunHanShuRequest chuangJianYunHanShuRequest);

    /**
     * 获取代码保护密钥
     * descr: 通过本接口可以获取代码保护密钥。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getCodeSecret.html
     * api: https://api.weixin.qq.com/tcb/getcodesecret?access_token=ACCESS_TOKEN
     *
     * @param huoQuDaiMaBaoHuMiYaoRequest
     */
    HuoQuDaiMaBaoHuMiYaoResponse huoQuDaiMaBaoHuMiYao(HuoQuDaiMaBaoHuMiYaoRequest huoQuDaiMaBaoHuMiYaoRequest);

    /**
     * 获取上传凭证
     * descr: 通过本接口可以获取上传云函数签名header 。使用过程中如遇到问题，可在,发帖交流。,hashed_payload是,请求POST数据的签名，具体参数参考,的请求参数。签名过程参考如下JavaScript代码片段：
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getYploadSignature.html
     * api: https://api.weixin.qq.com/tcb/getuploadsignature?access_token=ACCESS_TOKEN
     *
     * @param huoQuShangChuanPingZhengRequest
     */
    HuoQuShangChuanPingZhengResponse huoQuShangChuanPingZheng(HuoQuShangChuanPingZhengRequest huoQuShangChuanPingZhengRequest);

    /**
     * 获取云函数列表
     * descr: 通过本接口可以获取云函数列表。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getFuntionList.html
     * api: https://api.weixin.qq.com/tcb/listfunctions?access_token=ACCESS_TOKEN
     *
     * @param huoQuYunHanShuLieBiaoRequest
     */
    HuoQuYunHanShuLieBiaoResponse huoQuYunHanShuLieBiao(HuoQuYunHanShuLieBiaoRequest huoQuYunHanShuLieBiaoRequest);

    /**
     * 获取云函数下载地址
     * descr: 通过本接口可以获取云函数下载地址。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getFuntionLink.html
     * api: https://api.weixin.qq.com/tcb/downloadfunction?access_token=ACCESS_TOKEN
     *
     * @param huoQuYunHanShuXiaZaiDiZhiRequest
     */
    HuoQuYunHanShuXiaZaiDiZhiResponse huoQuYunHanShuXiaZaiDiZhi(HuoQuYunHanShuXiaZaiDiZhiRequest huoQuYunHanShuXiaZaiDiZhiRequest);

    /**
     * 上传云函数配置
     * descr: 通过本接口可以上传云函数配置。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getUploadFuntionConfig.html
     * api: https://api.weixin.qq.com/tcb/uploadfuncconfig?access_token=ACCESS_TOKEN
     *
     * @param shangChuanYunHanShuPeiZhiRequest
     */
    ShangChuanYunHanShuPeiZhiResponse shangChuanYunHanShuPeiZhi(ShangChuanYunHanShuPeiZhiRequest shangChuanYunHanShuPeiZhiRequest);

    /**
     * 获取云函数配置
     * descr: 通过本接口可以获取云函数配置。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getFuntionConfig.html
     * api: https://api.weixin.qq.com/tcb/getfuncconfig?access_token=ACCESS_TOKEN
     *
     * @param huoQuYunHanShuPeiZhiRequest
     */
    HuoQuYunHanShuPeiZhiResponse huoQuYunHanShuPeiZhi(HuoQuYunHanShuPeiZhiRequest huoQuYunHanShuPeiZhiRequest);
}