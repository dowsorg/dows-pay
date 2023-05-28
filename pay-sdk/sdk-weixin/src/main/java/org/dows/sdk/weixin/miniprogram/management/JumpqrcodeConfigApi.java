package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.*;
import org.dows.sdk.weixin.miniprogram.management.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description jumpqrcodeConfigApi
 * @date 2023年5月28日 下午9:55:33
 */
public interface JumpqrcodeConfigApi {

    /**
     * 该接口用于获取已设置的二维码规则
     * https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpget?access_token=ACCESS_TOKEN
     *
     * @param getJumpQRCodeRequest
     */
    GetJumpQRCodeResponse getJumpQRCode(GetJumpQRCodeRequest getJumpQRCodeRequest);

    /**
     * 该接口用于增加或修改二维码规则
     * https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpadd?access_token=ACCESS_TOKEN
     *
     * @param addJumpQRCodeRequest
     */
    AddJumpQRCodeResponse addJumpQRCode(AddJumpQRCodeRequest addJumpQRCodeRequest);

    /**
     * 需要先调接口添加二维码规则，然后调用本接口将二维码规则发布生效，发布后用户扫码命中该规则的二维码时将跳转到正式版小程序指定的页面
     * https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumppublish?access_token=ACCESS_TOKEN
     *
     * @param publishJumpQRCodeRequest
     */
    PublishJumpQRCodeResponse publishJumpQRCode(PublishJumpQRCodeRequest publishJumpQRCodeRequest);

    /**
     * 该接口用于删除已设置的二维码规则
     * https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpdelete?access_token=ACCESS_TOKEN
     *
     * @param deleteJumpQRCodeRequest
     */
    DeleteJumpQRCodeResponse deleteJumpQRCode(DeleteJumpQRCodeRequest deleteJumpQRCodeRequest);

    /**
     * https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpdownload?access_token=ACCESS_TOKEN
     *
     * @param downloadQRCodeTextRequest
     */
    DownloadQRCodeTextResponse downloadQRCodeText(DownloadQRCodeTextRequest downloadQRCodeTextRequest);
}