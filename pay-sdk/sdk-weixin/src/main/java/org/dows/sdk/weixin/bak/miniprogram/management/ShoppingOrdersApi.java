package org.dows.sdk.weixin.bak.miniprogram.management;

import org.dows.sdk.weixin.bak.miniprogram.management.request.*;
import org.dows.sdk.weixin.bak.miniprogram.management.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description shoppingOrdersApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface ShoppingOrdersApi {

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/uploadShoppingInfo.html
     * api: https://api.weixin.qq.com/user-order/orders?access_token=ACCESS_TOKEN
     *
     * @param uploadShoppingInfoRequest
     */
    UploadShoppingInfoResponse uploadShoppingInfo(UploadShoppingInfoRequest uploadShoppingInfoRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/uploadShippingInfo.html
     * api: https://api.weixin.qq.com/user-order/orders/shippings?access_token=ACCESS_TOKEN
     *
     * @param uploadShippingInfoRequest
     */
    UploadShippingInfoResponse uploadShippingInfo(UploadShippingInfoRequest uploadShippingInfoRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/uploadCombinedShoppingInfo.html
     * api: https://api.weixin.qq.com/user-order/combine-orders?access_token=ACCESS_TOKEN
     *
     * @param uploadCombinedShoppingInfoRequest
     */
    UploadCombinedShoppingInfoResponse uploadCombinedShoppingInfo(UploadCombinedShoppingInfoRequest uploadCombinedShoppingInfoRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/uploadCombinedShippingInfo.html
     * api: https://api.weixin.qq.com/user-order/combine-orders/shippings?access_token=ACCESS_TOKEN
     *
     * @param uploadCombinedShippingInfoRequest
     */
    UploadCombinedShippingInfoResponse uploadCombinedShippingInfo(UploadCombinedShippingInfoRequest uploadCombinedShippingInfoRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/openShoppingOrderProductPermission.html
     * api: https://api.weixin.qq.com/user-order/orders-permission/open?access_token=ACCESS_TOKEN
     *
     * @param openShoppingOrderProductPermissionRequest
     */
    OpenShoppingOrderProductPermissionResponse openShoppingOrderProductPermission(OpenShoppingOrderProductPermissionRequest openShoppingOrderProductPermissionRequest);

    /**
     * description: 返回最近一次审核的结果为上一次的提交审核的审核结果
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/confirmProductPermission.html
     * api: https://api.weixin.qq.com/user-order/orders-permission/confirm?access_token=ACCESS_TOKEN
     *
     * @param confirmProductPermissionRequest
     */
    ConfirmProductPermissionResponse confirmProductPermission(ConfirmProductPermissionRequest confirmProductPermissionRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/ShoppingInfoVerifyUploadResult.html
     * api: https://api.weixin.qq.com/user-order/shoppinginfo/verify
     *
     * @param shoppingInfoVerifyUploadResultRequest
     */
    ShoppingInfoVerifyUploadResultResponse shoppingInfoVerifyUploadResult(ShoppingInfoVerifyUploadResultRequest shoppingInfoVerifyUploadResultRequest);
}