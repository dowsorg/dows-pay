package org.dows.sdk.weixin.bak.miniprogram.management;

import org.dows.sdk.weixin.bak.miniprogram.management.request.*;
import org.dows.sdk.weixin.bak.miniprogram.management.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description jumpqrcodeConfigApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface JumpqrcodeConfigApi {

    /**
     * description: 该接口用于获取已设置的二维码规则
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/getJumpQRCode.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpget?access_token=ACCESS_TOKEN
     *
     * @param getJumpQRCodeRequest
     */
    GetJumpQRCodeResponse getJumpQRCode(GetJumpQRCodeRequest getJumpQRCodeRequest);

    /**
     * description: 该接口用于增加或修改二维码规则
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/addJumpQRCode.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpadd?access_token=ACCESS_TOKEN
     *
     * @param addJumpQRCodeRequest
     */
    AddJumpQRCodeResponse addJumpQRCode(AddJumpQRCodeRequest addJumpQRCodeRequest);

    /**
     * description: 需要先调接口添加二维码规则，然后调用本接口将二维码规则发布生效，发布后用户扫码命中该规则的二维码时将跳转到正式版小程序指定的页面
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/publishJumpQRCode.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumppublish?access_token=ACCESS_TOKEN
     *
     * @param publishJumpQRCodeRequest
     */
    PublishJumpQRCodeResponse publishJumpQRCode(PublishJumpQRCodeRequest publishJumpQRCodeRequest);

    /**
     * description: 该接口用于删除已设置的二维码规则
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/deleteJumpQRCode.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpdelete?access_token=ACCESS_TOKEN
     *
     * @param deleteJumpQRCodeRequest
     */
    DeleteJumpQRCodeResponse deleteJumpQRCode(DeleteJumpQRCodeRequest deleteJumpQRCodeRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/downloadQRCodeText.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpdownload?access_token=ACCESS_TOKEN
     *
     * @param downloadQRCodeTextRequest
     */
    DownloadQRCodeTextResponse downloadQRCodeText(DownloadQRCodeTextRequest downloadQRCodeTextRequest);
}