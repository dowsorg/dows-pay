package org.dows.sdk.weixin.bak.register.management;

import org.dows.sdk.weixin.bak.register.management.request.ModifyBetaMiniprogramNickNameRequest;
import org.dows.sdk.weixin.bak.register.management.request.RegisterBetaMiniprogramRequest;
import org.dows.sdk.weixin.bak.register.management.request.VerfifyBetaMiniprogramRequest;
import org.dows.sdk.weixin.bak.register.management.response.ModifyBetaMiniprogramNickNameResponse;
import org.dows.sdk.weixin.bak.register.management.response.RegisterBetaMiniprogramResponse;
import org.dows.sdk.weixin.bak.register.management.response.VerfifyBetaMiniprogramResponse;

/**
 * @author lait.zhang@gmail.com
 * @description fastRegistBetaApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface FastRegistBetaApi {

    /**
     * description: 该接口用于修改试用小程序名称。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-regist-beta/modifyBetaMiniprogramNickName.html
     * api: https://api.weixin.qq.com/wxa/setbetaweappnickname?access_token=ACCESS_TOKEN
     *
     * @param modifyBetaMiniprogramNickNameRequest
     */
    ModifyBetaMiniprogramNickNameResponse modifyBetaMiniprogramNickName(ModifyBetaMiniprogramNickNameRequest modifyBetaMiniprogramNickNameRequest);

    /**
     * description: 该接口用于通过企业法人人脸识别的方式快速将试用小程序进行认证。使用过程中如遇到问题，可在发帖交流。1、试用小程序完成认证之后，不会把【的试用小程序】去掉，需要服务商调【设置名称】的接口来重置名称。且，如果在发布上线之后再修改名称，需要用户重新认证改名。
     * 2、当小程序已经完成转正之后，仍然不可以扫码登录mp.weixin.qq.com，需要到“小程序助手”完成邮箱账号密码的补登记，才可以正常登录mp哈。操作详情请查看
     * 3、在调用此接口支持务必先阅读文档中的关于试用小程序快速认证接口逻辑介绍部分。
     * 4、发起转正后会有相关的消息推送至【授权事件接收 URL】，详细说明查看后面介绍1、不支持境外主体和个人主体，只支持企业及个体户（含无主体名称个体工商户）
     * 2、 创建转正任务逻辑是串行，单次任务结束后才可以使用相同信息下发第二次任务，请注意规避任务阻塞
     * 3、 小程序已经转正了（即不是试用小程序）则不可以再调用该接口
     * 4、 如果法人扫脸任务失败了，则可以重新调这个接口给法人下发模板消息。如果是模板消息已经下发，但是法人一直还没处理但是又还没有超时，则接口会报错提示892515、 当法人扫脸成功，但是管理员转正失败，则可以继续调该接口进行下发模板消息；此时法人仍然收到扫脸的模板消息，并不是直接跳过法人扫脸直接给管理员下发由于该接口涉及用户的授权确认操作，为异步操作的流程，因此用户的操作状态平台会将相关信息推送到【授权事件接收 URL】。
     * 1、模板消息下发成功后推送2、 转正成功后推送3、 转正失败了会推送（失败含超时），可通过status和msg字段区分1、 企业法人收到人脸识别确认的模板消息2、 小程序管理员转正确认的模板消息（如果1失败了，则2不会收到模板消息）
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-regist-beta/verfifyBetaMiniprogram.html
     * api: https://api.weixin.qq.com/wxa/verifybetaweapp?access_token=ACCESS_TOKEN
     *
     * @param verfifyBetaMiniprogramRequest
     */
    VerfifyBetaMiniprogramResponse verfifyBetaMiniprogram(VerfifyBetaMiniprogramRequest verfifyBetaMiniprogramRequest);

    /**
     * description: 该接口用于快速创建试用小程序。使用过程中如遇到问题，可在发帖交流。由于该接口涉及用户的授权确认操作，为异步操作的流程，因此用户的操作状态平台会将相关信息推送到【授权事件接收 URL】。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-regist-beta/registerBetaMiniprogram.html
     * api: https://api.weixin.qq.com/wxa/component/fastregisterbetaweapp?access_token=ACCESS_TOKEN
     *
     * @param registerBetaMiniprogramRequest
     */
    RegisterBetaMiniprogramResponse registerBetaMiniprogram(RegisterBetaMiniprogramRequest registerBetaMiniprogramRequest);
}