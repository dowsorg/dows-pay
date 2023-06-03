package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.*;
import org.dows.sdk.weixin.open.dsjglxcx.response.*;

/**
 * 扫普通二维码打开小程序
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface SaoPuTongErWeiMaDaKaiXiaoChengXuApi {

    /**
     * 获取已设置的二维码规则
     * descr: 该接口用于获取已设置的二维码规则
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/getJumpQRCode.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpget?access_token=ACCESS_TOKEN
     *
     * @param huoQuYiSheZhiDeErWeiMaGuiZeRequest
     */
    HuoQuYiSheZhiDeErWeiMaGuiZeResponse huoQuYiSheZhiDeErWeiMaGuiZe(HuoQuYiSheZhiDeErWeiMaGuiZeRequest huoQuYiSheZhiDeErWeiMaGuiZeRequest);

    /**
     * 增加或修改二维码规则
     * descr: 该接口用于增加或修改二维码规则
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/addJumpQRCode.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpadd?access_token=ACCESS_TOKEN
     *
     * @param zengJiaHuoXiuGaiErWeiMaGuiZeRequest
     */
    ZengJiaHuoXiuGaiErWeiMaGuiZeResponse zengJiaHuoXiuGaiErWeiMaGuiZe(ZengJiaHuoXiuGaiErWeiMaGuiZeRequest zengJiaHuoXiuGaiErWeiMaGuiZeRequest);

    /**
     * 发布已设置的二维码规则
     * descr: 需要先调接口添加二维码规则，然后调用本接口将二维码规则发布生效，发布后用户扫码命中该规则的二维码时将跳转到正式版小程序指定的页面
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/publishJumpQRCode.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumppublish?access_token=ACCESS_TOKEN
     *
     * @param faBuYiSheZhiDeErWeiMaGuiZeRequest
     */
    FaBuYiSheZhiDeErWeiMaGuiZeResponse faBuYiSheZhiDeErWeiMaGuiZe(FaBuYiSheZhiDeErWeiMaGuiZeRequest faBuYiSheZhiDeErWeiMaGuiZeRequest);

    /**
     * 删除已设置的二维码规则
     * descr: 该接口用于删除已设置的二维码规则
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/deleteJumpQRCode.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpdelete?access_token=ACCESS_TOKEN
     *
     * @param shanChuYiSheZhiDeErWeiMaGuiZeRequest
     */
    ShanChuYiSheZhiDeErWeiMaGuiZeResponse shanChuYiSheZhiDeErWeiMaGuiZe(ShanChuYiSheZhiDeErWeiMaGuiZeRequest shanChuYiSheZhiDeErWeiMaGuiZeRequest);

    /**
     * 获取校验文件名称及内容
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/downloadQRCodeText.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpdownload?access_token=ACCESS_TOKEN
     *
     * @param huoQuXiaoYanWenJianMingChengJiNeiRongRequest
     */
    HuoQuXiaoYanWenJianMingChengJiNeiRongResponse huoQuXiaoYanWenJianMingChengJiNeiRong(HuoQuXiaoYanWenJianMingChengJiNeiRongRequest huoQuXiaoYanWenJianMingChengJiNeiRongRequest);
}