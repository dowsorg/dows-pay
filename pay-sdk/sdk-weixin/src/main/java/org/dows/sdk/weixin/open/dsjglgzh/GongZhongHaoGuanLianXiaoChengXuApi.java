package org.dows.sdk.weixin.open.dsjglgzh;

import org.dows.sdk.weixin.open.dsjglgzh.request.GongZhongHaoGuanLianXiaoChengXuRequest;
import org.dows.sdk.weixin.open.dsjglgzh.request.GongZhongHaoJieChuGuanLianXiaoChengXuRequest;
import org.dows.sdk.weixin.open.dsjglgzh.request.HuoQuGongZhongHaoGuanLianDeXiaoChengXuRequest;
import org.dows.sdk.weixin.open.dsjglgzh.response.GongZhongHaoGuanLianXiaoChengXuResponse;
import org.dows.sdk.weixin.open.dsjglgzh.response.GongZhongHaoJieChuGuanLianXiaoChengXuResponse;
import org.dows.sdk.weixin.open.dsjglgzh.response.HuoQuGongZhongHaoGuanLianDeXiaoChengXuResponse;

/**
 * 公众号关联小程序
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface GongZhongHaoGuanLianXiaoChengXuApi {

    /**
     * 获取公众号关联的小程序
     * descr: 该接口用于获取公众号关联的小程序,公众号需要先把“小程序管理”权限集授权给第三方平台，第三方平台才可以调用此接口进行关联和管理操作。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/officalaccount-management/link-miniprogram/getLinkMiniprogram.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/wxamplinkget?access_token=ACCESS_TOKEN
     *
     * @param huoQuGongZhongHaoGuanLianDeXiaoChengXuRequest
     */
    HuoQuGongZhongHaoGuanLianDeXiaoChengXuResponse huoQuGongZhongHaoGuanLianDeXiaoChengXu(HuoQuGongZhongHaoGuanLianDeXiaoChengXuRequest huoQuGongZhongHaoGuanLianDeXiaoChengXuRequest);

    /**
     * 公众号关联小程序
     * descr: 该接口用于关联小程序,1、第三方平台调用接口发起关联,2、公众号管理员收到模板消息，同意关联小程序。,3、小程序管理员收到模板消息，同意关联公众号。,4、关联成功
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/officalaccount-management/link-miniprogram/linkMiniprogram.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/wxamplink?access_token=ACCESS_TOKEN
     *
     * @param gongZhongHaoGuanLianXiaoChengXuRequest
     */
    GongZhongHaoGuanLianXiaoChengXuResponse gongZhongHaoGuanLianXiaoChengXu(GongZhongHaoGuanLianXiaoChengXuRequest gongZhongHaoGuanLianXiaoChengXuRequest);

    /**
     * 公众号解除关联小程序
     * descr: 解除已关联的小程序
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/officalaccount-management/link-miniprogram/unlinkMiniprogram.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/wxampunlink?access_token=ACCESS_TOKEN
     *
     * @param gongZhongHaoJieChuGuanLianXiaoChengXuRequest
     */
    GongZhongHaoJieChuGuanLianXiaoChengXuResponse gongZhongHaoJieChuGuanLianXiaoChengXu(GongZhongHaoJieChuGuanLianXiaoChengXuRequest gongZhongHaoJieChuGuanLianXiaoChengXuRequest);
}