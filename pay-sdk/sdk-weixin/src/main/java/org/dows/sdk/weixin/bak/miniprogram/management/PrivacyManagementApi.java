package org.dows.sdk.weixin.bak.miniprogram.management;

import org.dows.sdk.weixin.bak.miniprogram.management.request.GetPrivacySettingRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.request.SetPrivacySettingRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.request.UploadPrivacySettingRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.response.GetPrivacySettingResponse;
import org.dows.sdk.weixin.bak.miniprogram.management.response.SetPrivacySettingResponse;
import org.dows.sdk.weixin.bak.miniprogram.management.response.UploadPrivacySettingResponse;

/**
 * @author lait.zhang@gmail.com
 * @description privacyManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface PrivacyManagementApi {

    /**
     * description: 1、配置后，需重新提交代码审核，审核通过且需要重新发布上线后才会在小程序端生效。2、配置后，可通过接口查询审核的状态，如果是驳回了则可以查看驳回原因。3、传参时注意不要json_encode中文变成了unicode编码，否则在小程序端会展示成乱码。建议set成功之后，调get接口看下设置的中文是否正常被显示。1、开发版指的是通过setprivacysetting接口已经配置的用户隐私保护指引内容，但是还没发布到现网，还没正式生效的版本。2、现网版本指的是已经在小程序现网版本已经生效的用户隐私保护指引内容。3、如果小程序已有一个现网版，可以通过该接口（privacy_ver=1）直接修改owner_setting里除了ext_file_media_id之外的信息，修改后即可生效。4、如果需要修改其他信息，则只能修改开发版（privacy_ver=2），然后提交代码审核，审核通过之后发布生效。5、当该小程序还没有现网版的隐私保护指引时却传了privacy_ver=1，则会出现 86074 报错
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-management/setPrivacySetting.html
     * api: https://api.weixin.qq.com/cgi-bin/component/setprivacysetting?access_token=ACCESS_TOKEN
     *
     * @param setPrivacySettingRequest
     */
    SetPrivacySettingResponse setPrivacySetting(SetPrivacySettingRequest setPrivacySettingRequest);

    /**
     * description: 1、开发版指的是通过setprivacysetting接口已经配置的用户隐私保护指引内容，但是还没发布到现网，还没正式生效的版本。2、现网版本指的是已经在小程序现网版本已经生效的用户隐私保护指引内容。3、如果不传privacy_ver，要传个空的json，否则会报错
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-management/getPrivacySetting.html
     * api: https://api.weixin.qq.com/cgi-bin/component/getprivacysetting?access_token=ACCESS_TOKEN
     *
     * @param getPrivacySettingRequest
     */
    GetPrivacySettingResponse getPrivacySetting(GetPrivacySettingRequest getPrivacySettingRequest);

    /**
     * description: 1、限制文件大小为不超过100kb，否则会报错
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-management/uploadPrivacySetting.html
     * api: https://api.weixin.qq.com/cgi-bin/component/uploadprivacyextfile?access_token=ACCESS_TOKEN
     *
     * @param uploadPrivacySettingRequest
     */
    UploadPrivacySettingResponse uploadPrivacySetting(UploadPrivacySettingRequest uploadPrivacySettingRequest);
}