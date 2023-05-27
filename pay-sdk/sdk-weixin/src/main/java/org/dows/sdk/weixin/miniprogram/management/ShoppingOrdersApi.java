package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.*;
import org.dows.sdk.weixin.miniprogram.management.response.*;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：120、121服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface ShoppingOrdersApi {
    /**
     * @param uploadShoppingInfoRequest
     */
    UploadShoppingInfoResponse uploadShoppingInfo(UploadShoppingInfoRequest uploadShoppingInfoRequest);

    /**
     * @param uploadShippingInfoRequest
     */
    UploadShippingInfoResponse uploadShippingInfo(UploadShippingInfoRequest uploadShippingInfoRequest);

    /**
     * @param uploadCombinedShoppingInfoRequest
     */
    UploadCombinedShoppingInfoResponse uploadCombinedShoppingInfo(UploadCombinedShoppingInfoRequest uploadCombinedShoppingInfoRequest);

    /**
     * @param uploadCombinedShippingInfoRequest
     */
    UploadCombinedShippingInfoResponse uploadCombinedShippingInfo(UploadCombinedShippingInfoRequest uploadCombinedShippingInfoRequest);

    /**
     * @param openShoppingOrderProductPermissionRequest
     */
    OpenShoppingOrderProductPermissionResponse openShoppingOrderProductPermission(OpenShoppingOrderProductPermissionRequest openShoppingOrderProductPermissionRequest);

    /**
     * 返回最近一次审核的结果为上一次的提交审核的审核结果
     *
     * @param confirmProductPermissionRequest
     */
    ConfirmProductPermissionResponse confirmProductPermission(ConfirmProductPermissionRequest confirmProductPermissionRequest);

    /**
     * @param ShoppingInfoVerifyUploadResultRequest
     */
    ShoppingInfoVerifyUploadResultResponse ShoppingInfoVerifyUploadResult(ShoppingInfoVerifyUploadResultRequest ShoppingInfoVerifyUploadResultRequest);


}
