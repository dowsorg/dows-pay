package org.dows.pay.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayOpenAuthTokenAppModel;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.annotation.PayMapping;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * 回调业务功能,
 * 前提：
 * 进入 第三方应用详情 > 消息服务 > FROM 平台，订阅 alipay.open.mini.merchant.confirmed
 * 通知，用于接收商家确认的结果通知，详情可查看 From 蚂蚁消息服务使用。
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AlipayCallbackHandler extends AbstractAlipayHandler {
    private final AlipayClient alipayClient;
    private final AlipayClient certAlipayClient;



    /**
     * todo 商家授权成功回调，内部数据处理逻辑
     * 代商家创建小程序后，商家授权成功，由支付宝平台发起回调, 这里解析返回字符串参数，并返回AppAuthToken
     */
    @PayMapping(method = "", argNames = "")
    public String onIsvMiniMerchantAccredit(String content) {
        JSONObject jsonObject = JSONObject.parseObject(content);
        JSONObject bizContent = jsonObject.getJSONObject("biz_content");
        JSONObject detail = bizContent.getJSONObject("detail");
        String appAuthToken = detail.getString("app_auth_token");
        return appAuthToken;
    }


    /**
     * todo 用户支付成功回调，内部数据处理逻辑
     *
     * @param request
     * @return
     * @throws IOException
     */
    @PayMapping(method = "", argNames = "")
    public String onPaySuccess(HttpServletRequest request) {


        return null;
    }


    /**
     * 支付宝授权回调
     *
     * @param appId
     * @param appAuthCode
     * @throws AlipayApiException
     */
    @PayMapping(method = "", argNames = "")
    public void onAuthorization(String appId, String appAuthCode) throws AlipayApiException {
        AlipayOpenAuthTokenAppRequest alipayOpenAuthTokenAppRequest = new AlipayOpenAuthTokenAppRequest();

        AlipayOpenAuthTokenAppModel alipayOpenAuthTokenAppModel = new AlipayOpenAuthTokenAppModel();
        alipayOpenAuthTokenAppModel.setCode(appAuthCode);
        alipayOpenAuthTokenAppModel.setGrantType("authorization_code");

        alipayOpenAuthTokenAppRequest.setBizModel(alipayOpenAuthTokenAppModel);
        AlipayOpenAuthTokenAppResponse alipayOpenAuthTokenAppResponse = alipayClient.execute(alipayOpenAuthTokenAppRequest);
        String appAuthToken = alipayOpenAuthTokenAppResponse.getAppAuthToken();
        String appRefreshToken = alipayOpenAuthTokenAppResponse.getAppRefreshToken();

    }


}
