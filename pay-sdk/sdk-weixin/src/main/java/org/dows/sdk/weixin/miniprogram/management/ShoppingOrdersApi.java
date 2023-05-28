package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.*;
import org.dows.sdk.weixin.miniprogram.management.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description shoppingOrdersApi
 * @date 2023年5月28日 下午9:55:33
 */
public interface ShoppingOrdersApi {

    /**
     * https://api.weixin.qq.com/user-order/orders?access_token=ACCESS_TOKEN
     *
     * @param uploadShoppingInfoRequest
     */
    UploadShoppingInfoResponse uploadShoppingInfo(UploadShoppingInfoRequest uploadShoppingInfoRequest);

    /**
     * https://api.weixin.qq.com/user-order/orders/shippings?access_token=ACCESS_TOKEN
     *
     * @param uploadShippingInfoRequest
     */
    UploadShippingInfoResponse uploadShippingInfo(UploadShippingInfoRequest uploadShippingInfoRequest);

    /**
     * https://api.weixin.qq.com/user-order/combine-orders?access_token=ACCESS_TOKEN
     *
     * @param uploadCombinedShoppingInfoRequest
     */
    UploadCombinedShoppingInfoResponse uploadCombinedShoppingInfo(UploadCombinedShoppingInfoRequest uploadCombinedShoppingInfoRequest);

    /**
     * https://api.weixin.qq.com/user-order/combine-orders/shippings?access_token=ACCESS_TOKEN
     *
     * @param uploadCombinedShippingInfoRequest
     */
    UploadCombinedShippingInfoResponse uploadCombinedShippingInfo(UploadCombinedShippingInfoRequest uploadCombinedShippingInfoRequest);

    /**
     * https://api.weixin.qq.com/user-order/orders-permission/open?access_token=ACCESS_TOKEN
     *
     * @param openShoppingOrderProductPermissionRequest
     */
    OpenShoppingOrderProductPermissionResponse openShoppingOrderProductPermission(OpenShoppingOrderProductPermissionRequest openShoppingOrderProductPermissionRequest);

    /**
     * 返回最近一次审核的结果为上一次的提交审核的审核结果
     * https://api.weixin.qq.com/user-order/orders-permission/confirm?access_token=ACCESS_TOKEN
     *
     * @param confirmProductPermissionRequest
     */
    ConfirmProductPermissionResponse confirmProductPermission(ConfirmProductPermissionRequest confirmProductPermissionRequest);

    /**
     * https://api.weixin.qq.com/user-order/shoppinginfo/verify
     *
     * @param shoppingInfoVerifyUploadResultRequest
     */
    ShoppingInfoVerifyUploadResultResponse shoppingInfoVerifyUploadResult(ShoppingInfoVerifyUploadResultRequest shoppingInfoVerifyUploadResultRequest);
}