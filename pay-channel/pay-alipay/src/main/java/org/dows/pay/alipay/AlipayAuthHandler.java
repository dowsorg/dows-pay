package org.dows.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayOpenAuthTokenAppModel;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.auth.api.TempRedisApi;
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

        String appAuthToken = alipayOpenAuthTokenAppResponse.getAppAuthToken();
        String appRefreshToken = alipayOpenAuthTokenAppResponse.getAppRefreshToken();

        // save redis
        tempRedisApi.setKey(appId, appAuthToken);
        tempRedisApi.setKey(String.join(StringPool.UNDERSCORE,appId,"authorizer_refresh_token"),appRefreshToken);
    }


}
