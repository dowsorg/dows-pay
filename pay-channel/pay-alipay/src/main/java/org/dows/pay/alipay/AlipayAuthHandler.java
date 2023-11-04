package org.dows.pay.alipay;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayOpenAuthTokenAppModel;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.auth.api.TempRedisApi;
import org.dows.pay.entity.PayApply;
import org.dows.pay.service.PayApplyService;
import org.springframework.stereotype.Service;


/**
 * 回调业务功能,
 * 前提：
 * 进入 第三方应用详情 > 消息服务 > FROM 平台，订阅 alipay.open.mini.merchant.confirmed
 * 通知，用于接收商家确认的结果通知，详情可查看 From 蚂蚁消息服务使用。
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AlipayAuthHandler extends AbstractAlipayHandler {

    private final TempRedisApi tempRedisApi;

    private final PayApplyService payApplyService;


    /**
     * 支付宝授权回调
     *
     * @param appId
     * @param appAuthCode
     * @throws AlipayApiException
     */
    public void onAuthorization(String appId, String appAuthCode) throws AlipayApiException {
        AlipayOpenAuthTokenAppRequest alipayOpenAuthTokenAppRequest = new AlipayOpenAuthTokenAppRequest();

        AlipayOpenAuthTokenAppModel alipayOpenAuthTokenAppModel = new AlipayOpenAuthTokenAppModel();
        alipayOpenAuthTokenAppModel.setCode(appAuthCode);
        alipayOpenAuthTokenAppModel.setGrantType("authorization_code");

        alipayOpenAuthTokenAppRequest.setBizModel(alipayOpenAuthTokenAppModel);
        AlipayOpenAuthTokenAppResponse alipayOpenAuthTokenAppResponse =
                getAlipayClient(appId).execute(alipayOpenAuthTokenAppRequest);

        log.info("支付宝获取授权码返回：{}", JSON.toJSONString(alipayOpenAuthTokenAppResponse));
        String appAuthToken = alipayOpenAuthTokenAppResponse.getAppAuthToken();
        String appRefreshToken = alipayOpenAuthTokenAppResponse.getAppRefreshToken();
        String authAppId = alipayOpenAuthTokenAppResponse.getAuthAppId();
        String mchId = alipayOpenAuthTokenAppResponse.getUserId();


        //商家确认之后把appId回写到pay_apply,支付宝支付获取appId从pay_apply表中获取,支付宝特定取法，待支付宝上线小程序后支付appId和微信逻辑一样
        PayApply payApply = payApplyService.getByMchIdAndType(mchId,2);
        if(payApply!=null && StrUtil.isNotBlank(authAppId)){
            payApply.setAppId(authAppId);
            payApply.setChecked(Boolean.TRUE);
            payApplyService.updateById(payApply);
        }

        // save redis
        tempRedisApi.setKey(appId, appAuthToken);
        tempRedisApi.setKey(String.join(StringPool.UNDERSCORE,appId,"authorizer_refresh_token"),appRefreshToken);
    }


}
