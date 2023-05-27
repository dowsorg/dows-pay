package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.*;
import org.dows.sdk.weixin.miniprogram.management.response.*;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：3、18服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface JumpqrcodeConfigApi {
    /**
     * 该接口用于获取已设置的二维码规则
     *
     * @param getJumpQRCodeRequest
     */
    GetJumpQRCodeResponse getJumpQRCode(GetJumpQRCodeRequest getJumpQRCodeRequest);

    /**
     * 该接口用于增加或修改二维码规则
     *
     * @param addJumpQRCodeRequest
     */
    AddJumpQRCodeResponse addJumpQRCode(AddJumpQRCodeRequest addJumpQRCodeRequest);

    /**
     * 需要先调接口添加二维码规则，然后调用本接口将二维码规则发布生效，发布后用户扫码命中该规则的二维码时将跳转到正式版小程序指定的页面
     *
     * @param publishJumpQRCodeRequest
     */
    PublishJumpQRCodeResponse publishJumpQRCode(PublishJumpQRCodeRequest publishJumpQRCodeRequest);

    /**
     * 该接口用于删除已设置的二维码规则
     *
     * @param deleteJumpQRCodeRequest
     */
    DeleteJumpQRCodeResponse deleteJumpQRCode(DeleteJumpQRCodeRequest deleteJumpQRCodeRequest);

    /**
     * @param downloadQRCodeTextRequest
     */
    DownloadQRCodeTextResponse downloadQRCodeText(DownloadQRCodeTextRequest downloadQRCodeTextRequest);


}
