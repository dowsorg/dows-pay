package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.*;
import org.dows.sdk.weixin.miniprogram.management.response.*;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：18服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface EmbeddedManagementApi {
    /**
     * 本接口用于添加半屏小程序，使用过程中如遇到问题，可在发帖交流1、如果被添加的半屏小程序设置为'需管理员验证'，那么调用该接口申请添加半屏小程序后，会下发模板消息至被添加的半屏小程序管理员，需等对方管理员同意后方可添加成功，可通过get_list接口查看通过状态。2、如果被添加的半屏小程序设置为'自动授权通过'，那么调用该接口申请添加半屏小程序后，即可添加成功，可通过get_list接口查看通过状态。3、如果被添加的半屏小程序设置为'拒绝授权邀请'，那么调用该接口申请添加半屏小程序后，即刻被拒绝，可通过get_list接口查看通过状态。4、一个小程序最多可调用10个半屏小程序；一天最多申请50个半屏小程序；5、服务商一天最多可通过api代10个小程序申请添加同一个半屏小程序；6、一个半屏小程序最多可授权给1000个小程序调用；7、24h内，最多申请3次同一个半屏小程序；8、其他使用限制可查看：
     *
     * @param addEmbeddedRequest
     */
    AddEmbeddedResponse addEmbedded(AddEmbeddedRequest addEmbeddedRequest);

    /**
     * @param deleteEmbeddedRequest
     */
    DeleteEmbeddedResponse deleteEmbedded(DeleteEmbeddedRequest deleteEmbeddedRequest);

    /**
     * @param deleteAuthorizedEmbeddedRequest
     */
    DeleteAuthorizedEmbeddedResponse deleteAuthorizedEmbedded(DeleteAuthorizedEmbeddedRequest deleteAuthorizedEmbeddedRequest);

    /**
     * @param getEmbeddedListRequest
     */
    GetEmbeddedListResponse getEmbeddedList(GetEmbeddedListRequest getEmbeddedListRequest);

    /**
     * @param getOwnListRequest
     */
    GetOwnListResponse getOwnList(GetOwnListRequest getOwnListRequest);

    /**
     * 调用本接口可以设置半屏小程序授权方式，使用过程中如遇到问题，可在发帖交流。
     *
     * @param setAuthorizedEmbeddedRequest
     */
    SetAuthorizedEmbeddedResponse setAuthorizedEmbedded(SetAuthorizedEmbeddedRequest setAuthorizedEmbeddedRequest);

}
