package org.dows.sdk.weixin.open.dsfptgl;

import org.dows.sdk.weixin.open.dsfptgl.request.HuoQuCaoGaoXiangLieBiaoRequest;
import org.dows.sdk.weixin.open.dsfptgl.request.HuoQuMoBanLieBiaoRequest;
import org.dows.sdk.weixin.open.dsfptgl.request.JiangCaoGaoTianJiaDaoMoBanKuRequest;
import org.dows.sdk.weixin.open.dsfptgl.request.ShanChuDaiMaMoBanRequest;
import org.dows.sdk.weixin.open.dsfptgl.response.HuoQuCaoGaoXiangLieBiaoResponse;
import org.dows.sdk.weixin.open.dsfptgl.response.HuoQuMoBanLieBiaoResponse;
import org.dows.sdk.weixin.open.dsfptgl.response.JiangCaoGaoTianJiaDaoMoBanKuResponse;
import org.dows.sdk.weixin.open.dsfptgl.response.ShanChuDaiMaMoBanResponse;

/**
 * 模板库管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface MoBanKuGuanLiApi {

    /**
     * 获取草稿箱列表
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/getTemplatedRaftList.html
     * api: https://api.weixin.qq.com/wxa/gettemplatedraftlist?access_token=ACCESS_TOKEN
     *
     * @param huoQuCaoGaoXiangLieBiaoRequest
     */
    HuoQuCaoGaoXiangLieBiaoResponse huoQuCaoGaoXiangLieBiao(HuoQuCaoGaoXiangLieBiaoRequest huoQuCaoGaoXiangLieBiaoRequest);

    /**
     * 将草稿添加到模板库
     * descr: 该接口用于将草稿添加到模板库设置为持久的代码模板。使用过程中如遇到问题，可在开放,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/addToTemplate.html
     * api: https://api.weixin.qq.com/wxa/addtotemplate?access_token=ACCESS_TOKEN
     *
     * @param jiangCaoGaoTianJiaDaoMoBanKuRequest
     */
    JiangCaoGaoTianJiaDaoMoBanKuResponse jiangCaoGaoTianJiaDaoMoBanKu(JiangCaoGaoTianJiaDaoMoBanKuRequest jiangCaoGaoTianJiaDaoMoBanKuRequest);

    /**
     * 获取模板列表
     * descr: 通过该接口可以获取模板库里的模板列表信息。使用过程中如遇到问题，可在,发帖交流,请求方式是get，不是post。如果之前使用了post请求的用户，请切换成get
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/getTemplateList.html
     * api: https://api.weixin.qq.com/wxa/gettemplatelist?access_token=ACCESS_TOKEN
     *
     * @param huoQuMoBanLieBiaoRequest
     */
    HuoQuMoBanLieBiaoResponse huoQuMoBanLieBiao(HuoQuMoBanLieBiaoRequest huoQuMoBanLieBiaoRequest);

    /**
     * 删除代码模板
     * descr: 通过该接口可以删除指定的模板。因为代码模板库的模板数量是有上限的，当达到上限或者有某个模板不再需要时，建议调用本接口删除指定的代码模板。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/deleteTemplate.html
     * api: https://api.weixin.qq.com/wxa/deletetemplate?access_token=ACCESS_TOKEN
     *
     * @param shanChuDaiMaMoBanRequest
     */
    ShanChuDaiMaMoBanResponse shanChuDaiMaMoBan(ShanChuDaiMaMoBanRequest shanChuDaiMaMoBanRequest);
}