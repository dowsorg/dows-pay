package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.*;
import org.dows.sdk.weixin.open.dsjglxcx.response.*;

/**
 * 购物订单
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface GouWuDingDanApi {

    /**
     * 上传购物详情
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/uploadShoppingInfo.html
     * api: https://api.weixin.qq.com/user-order/orders?access_token=ACCESS_TOKEN
     *
     * @param shangChuanGouWuXiangQingRequest
     */
    ShangChuanGouWuXiangQingResponse shangChuanGouWuXiangQing(ShangChuanGouWuXiangQingRequest shangChuanGouWuXiangQingRequest);

    /**
     * 上传物流信息
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/uploadShippingInfo.html
     * api: https://api.weixin.qq.com/user-order/orders/shippings?access_token=ACCESS_TOKEN
     *
     * @param shangChuanWuLiuXinXiRequest
     */
    ShangChuanWuLiuXinXiResponse shangChuanWuLiuXinXi(ShangChuanWuLiuXinXiRequest shangChuanWuLiuXinXiRequest);

    /**
     * 上传合单购物详情
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/uploadCombinedShoppingInfo.html
     * api: https://api.weixin.qq.com/user-order/combine-orders?access_token=ACCESS_TOKEN
     *
     * @param shangChuanHeDanGouWuXiangQingRequest
     */
    ShangChuanHeDanGouWuXiangQingResponse shangChuanHeDanGouWuXiangQing(ShangChuanHeDanGouWuXiangQingRequest shangChuanHeDanGouWuXiangQingRequest);

    /**
     * 上传合单物流信息
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/uploadCombinedShippingInfo.html
     * api: https://api.weixin.qq.com/user-order/combine-orders/shippings?access_token=ACCESS_TOKEN
     *
     * @param shangChuanHeDanWuLiuXinXiRequest
     */
    ShangChuanHeDanWuLiuXinXiResponse shangChuanHeDanWuLiuXinXi(ShangChuanHeDanWuLiuXinXiRequest shangChuanHeDanWuLiuXinXiRequest);

    /**
     * 开通购物订单产品权限
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/openShoppingOrderProductPermission.html
     * api: https://api.weixin.qq.com/user-order/orders-permission/open?access_token=ACCESS_TOKEN
     *
     * @param kaiTongGouWuDingDanChanPinQuanXianRequest
     */
    KaiTongGouWuDingDanChanPinQuanXianResponse kaiTongGouWuDingDanChanPinQuanXian(KaiTongGouWuDingDanChanPinQuanXianRequest kaiTongGouWuDingDanChanPinQuanXianRequest);

    /**
     * 提交购物订单接入审核
     * descr: 返回最近一次审核的结果为上一次的提交审核的审核结果
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/confirmProductPermission.html
     * api: https://api.weixin.qq.com/user-order/orders-permission/confirm?access_token=ACCESS_TOKEN
     *
     * @param tiJiaoGouWuDingDanJieRuShenHeRequest
     */
    TiJiaoGouWuDingDanJieRuShenHeResponse tiJiaoGouWuDingDanJieRuShenHe(TiJiaoGouWuDingDanJieRuShenHeRequest tiJiaoGouWuDingDanJieRuShenHeRequest);

    /**
     * 验证购物订单上传结果
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/ShoppingInfoVerifyUploadResult.html
     * api: https://api.weixin.qq.com/user-order/shoppinginfo/verify
     *
     * @param yanZhengGouWuDingDanShangChuanJieGuoRequest
     */
    YanZhengGouWuDingDanShangChuanJieGuoResponse yanZhengGouWuDingDanShangChuanJieGuo(YanZhengGouWuDingDanShangChuanJieGuoRequest yanZhengGouWuDingDanShangChuanJieGuoRequest);
}