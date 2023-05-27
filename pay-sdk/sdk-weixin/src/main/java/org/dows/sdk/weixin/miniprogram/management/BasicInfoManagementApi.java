package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.*;
import org.dows.sdk.weixin.miniprogram.management.response.*;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：3、30、61服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface BasicInfoManagementApi {
    /**
     * 调用本 API 可以获取小程序的基本信息，所属权限集为30。使用过程中如遇到问题，可在开放平台服务商专区发帖交流。补充：该接口同适用于获取公众号基本信息，所属权限集为3；
     *
     * @param getAccountBasicInfoRequest
     */
    GetAccountBasicInfoResponse getAccountBasicInfo(GetAccountBasicInfoRequest getAccountBasicInfoRequest);

    /**
     * 该 API 用于查询公众号或小程序是否绑定的开放平台帐号。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getBindOpenAccountRequest
     */
    GetBindOpenAccountResponse getBindOpenAccount(GetBindOpenAccountRequest getBindOpenAccountRequest);

    /**
     * 调用本 API 可以检测微信认证的名称是否符合规则。使用过程中如遇到问题，可在发帖交流该接口只允许通过api创建的小程序使用。
     *
     * @param checkNickNameRequest
     */
    CheckNickNameResponse checkNickName(CheckNickNameRequest checkNickNameRequest);

    /**
     * 的审核结果会向消息与事件接收 URL 推送相关通知。
     *
     * @param setNickNameRequest
     */
    SetNickNameResponse setNickName(SetNickNameRequest setNickNameRequest);

    /**
     * @param getNickNameStatusRequest
     */
    GetNickNameStatusResponse getNickNameStatus(GetNickNameStatusRequest getNickNameStatusRequest);

    /**
     * 调用本接口可以修改功能介绍。使用过程中如遇到问题，可在发帖交流。报错53204请注意： 1、signature长度4~120。 2、signature至少4个字的中文描述。
     *
     * @param setSignatureRequest
     */
    SetSignatureResponse setSignature(SetSignatureRequest setSignatureRequest);

    /**
     * 通过本接口可以查询小程序当前是否可被搜索。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getSearchStatusRequest
     */
    GetSearchStatusResponse getSearchStatus(GetSearchStatusRequest getSearchStatusRequest);

    /**
     * @param setSearchStatusRequest
     */
    SetSearchStatusResponse setSearchStatus(SetSearchStatusRequest setSearchStatusRequest);

    /**
     * @param getFetchdataSettingRequest
     */
    GetFetchdataSettingResponse getFetchdataSetting(GetFetchdataSettingRequest getFetchdataSettingRequest);

    /**
     * head_img_media_id：media_id 临时素材 media_id 通过调用“临时素材管理接口”获取 . 调用如下接口时请使用第三方平台接口调用令牌authorizer_access_token
     *
     * @param setHeadImageRequest
     */
    SetHeadImageResponse setHeadImage(SetHeadImageRequest setHeadImageRequest);

    /**
     * 该 API 用于查询公众号或小程序绑定的开放平台帐号是否与当前公众号/小程序同主体。使用过程中如遇到问题，可在开放平台服务商专区发帖交流。
     *
     * @param getBindOpenAccountEntityRequest
     */
    GetBindOpenAccountEntityResponse getBindOpenAccountEntity(GetBindOpenAccountEntityRequest getBindOpenAccountEntityRequest);

    /**
     * 该接口用于获取订单页path信息。
     *
     * @param getOrderPathInfoRequest
     */
    GetOrderPathInfoResponse getOrderPathInfo(GetOrderPathInfoRequest getOrderPathInfoRequest);

    /**
     * 该接口用于申请设置订单页path信息appid_list：一次提交不超过100个appid返回码说明
     *
     * @param applySetOrderPathInfoRequest
     */
    ApplySetOrderPathInfoResponse applySetOrderPathInfo(ApplySetOrderPathInfoRequest applySetOrderPathInfoRequest);


}
