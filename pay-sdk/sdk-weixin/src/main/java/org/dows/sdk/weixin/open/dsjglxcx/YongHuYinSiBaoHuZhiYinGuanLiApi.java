package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.HuoQuXiaoChengXuYongHuYinSiBaoHuZhiYinRequest;
import org.dows.sdk.weixin.open.dsjglxcx.request.ShangChuanXiaoChengXuYongHuYinSiBaoHuZhiYinRequest;
import org.dows.sdk.weixin.open.dsjglxcx.request.SheZhiXiaoChengXuYongHuYinSiBaoHuZhiYinRequest;
import org.dows.sdk.weixin.open.dsjglxcx.response.HuoQuXiaoChengXuYongHuYinSiBaoHuZhiYinResponse;
import org.dows.sdk.weixin.open.dsjglxcx.response.ShangChuanXiaoChengXuYongHuYinSiBaoHuZhiYinResponse;
import org.dows.sdk.weixin.open.dsjglxcx.response.SheZhiXiaoChengXuYongHuYinSiBaoHuZhiYinResponse;

/**
 * 用户隐私保护指引管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface YongHuYinSiBaoHuZhiYinGuanLiApi {

    /**
     * 设置小程序用户隐私保护指引
     * descr: 1、配置后，需重新提交代码审核，审核通过且需要重新发布上线后才会在小程序端生效。,2、配置后，可通过,接口查询审核的状态，如果是驳回了则可以查看驳回原因。,3、传参时注意不要json_encode中文变成了unicode编码，否则在小程序端会展示成乱码。建议set成功之后，调get接口看下设置的中文是否正常被显示。,1、开发版指的是通过setprivacysetting接口已经配置的用户隐私保护指引内容，但是还没发布到现网，还没正式生效的版本。,2、现网版本指的是已经在小程序现网版本已经生效的用户隐私保护指引内容。,3、如果小程序已有一个现网版，可以通过该接口（privacy_ver=1）直接修改owner_setting里除了ext_file_media_id之外的信息，修改后即可生效。,4、如果需要修改其他信息，则只能修改开发版（privacy_ver=2），然后提交代码审核，审核通过之后发布生效。,5、当该小程序还没有现网版的隐私保护指引时却传了privacy_ver=1，则会出现 86074 报错
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-management/setPrivacySetting.html
     * api: https://api.weixin.qq.com/cgi-bin/component/setprivacysetting?access_token=ACCESS_TOKEN
     *
     * @param sheZhiXiaoChengXuYongHuYinSiBaoHuZhiYinRequest
     */
    SheZhiXiaoChengXuYongHuYinSiBaoHuZhiYinResponse sheZhiXiaoChengXuYongHuYinSiBaoHuZhiYin(SheZhiXiaoChengXuYongHuYinSiBaoHuZhiYinRequest sheZhiXiaoChengXuYongHuYinSiBaoHuZhiYinRequest);

    /**
     * 获取小程序用户隐私保护指引
     * descr: 1、开发版指的是通过setprivacysetting接口已经配置的用户隐私保护指引内容，但是还没发布到现网，还没正式生效的版本。,2、现网版本指的是已经在小程序现网版本已经生效的用户隐私保护指引内容。,3、如果不传privacy_ver，要传个空的json，否则会报错
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-management/getPrivacySetting.html
     * api: https://api.weixin.qq.com/cgi-bin/component/getprivacysetting?access_token=ACCESS_TOKEN
     *
     * @param huoQuXiaoChengXuYongHuYinSiBaoHuZhiYinRequest
     */
    HuoQuXiaoChengXuYongHuYinSiBaoHuZhiYinResponse huoQuXiaoChengXuYongHuYinSiBaoHuZhiYin(HuoQuXiaoChengXuYongHuYinSiBaoHuZhiYinRequest huoQuXiaoChengXuYongHuYinSiBaoHuZhiYinRequest);

    /**
     * 上传小程序用户隐私保护指引
     * descr: 1、限制文件大小为不超过100kb，否则会报错
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-management/uploadPrivacySetting.html
     * api: https://api.weixin.qq.com/cgi-bin/component/uploadprivacyextfile?access_token=ACCESS_TOKEN
     *
     * @param shangChuanXiaoChengXuYongHuYinSiBaoHuZhiYinRequest
     */
    ShangChuanXiaoChengXuYongHuYinSiBaoHuZhiYinResponse shangChuanXiaoChengXuYongHuYinSiBaoHuZhiYin(ShangChuanXiaoChengXuYongHuYinSiBaoHuZhiYinRequest shangChuanXiaoChengXuYongHuYinSiBaoHuZhiYinRequest);
}