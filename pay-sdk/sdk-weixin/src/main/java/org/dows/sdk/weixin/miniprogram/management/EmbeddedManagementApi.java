package org.dows.sdk.weixin.miniprogram.management;

/**
 * @description embeddedManagementApi
 * @author lait.zhang@gmail.com
 * @date  2023年5月28日 下午9:55:33
 */
public interface EmbeddedManagementApi{

    /**
     * 本接口用于添加半屏小程序，使用过程中如遇到问题，可在发帖交流1、如果被添加的半屏小程序设置为"需管理员验证"，那么调用该接口申请添加半屏小程序后，会下发模板消息至被添加的半屏小程序管理员，需等对方管理员同意后方可添加成功，可通过get_list接口查看通过状态。2、如果被添加的半屏小程序设置为"自动授权通过"，那么调用该接口申请添加半屏小程序后，即可添加成功，可通过get_list接口查看通过状态。3、如果被添加的半屏小程序设置为"拒绝授权邀请"，那么调用该接口申请添加半屏小程序后，即刻被拒绝，可通过get_list接口查看通过状态。4、一个小程序最多可调用10个半屏小程序；一天最多申请50个半屏小程序；5、服务商一天最多可通过api代10个小程序申请添加同一个半屏小程序；6、一个半屏小程序最多可授权给1000个小程序调用；7、24h内，最多申请3次同一个半屏小程序；8、其他使用限制可查看：
     * https://api.weixin.qq.com/wxaapi/wxaembedded/add_embedded?access_token=ACCESS_TOKEN
     * 
     * @param addEmbeddedRequest
     * 
     */
    AddEmbeddedResponse addEmbedded(AddEmbeddedRequest addEmbeddedRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxaapi/wxaembedded/del_embedded?access_token=ACCESS_TOKEN
     * 
     * @param deleteEmbeddedRequest
     * 
     */
    DeleteEmbeddedResponse deleteEmbedded(DeleteEmbeddedRequest deleteEmbeddedRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxaapi/wxaembedded/del_authorize?access_token=ACCESS_TOKEN
     * 
     * @param deleteAuthorizedEmbeddedRequest
     * 
     */
    DeleteAuthorizedEmbeddedResponse deleteAuthorizedEmbedded(DeleteAuthorizedEmbeddedRequest deleteAuthorizedEmbeddedRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxaapi/wxaembedded/get_list?access_token=ACCESS_TOKEN
     * 
     * @param getEmbeddedListRequest
     * 
     */
    GetEmbeddedListResponse getEmbeddedList(GetEmbeddedListRequest getEmbeddedListRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxaapi/wxaembedded/get_own_list?access_token=ACCESS_TOKEN
     * 
     * @param getOwnListRequest
     * 
     */
    GetOwnListResponse getOwnList(GetOwnListRequest getOwnListRequest);

    /**
     * 调用本接口可以设置半屏小程序授权方式，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/wxaapi/wxaembedded/set_authorize?access_token=ACCESS_TOKEN
     * 
     * @param setAuthorizedEmbeddedRequest
     * 
     */
    SetAuthorizedEmbeddedResponse setAuthorizedEmbedded(SetAuthorizedEmbeddedRequest setAuthorizedEmbeddedRequest);
}