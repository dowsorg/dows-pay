package org.dows.pay.weixin;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.CreateMiniRequest;
import com.alipay.api.request.AlipayOpenMiniIsvCreateRequest;
import com.alipay.api.response.AlipayOpenMiniIsvCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeixinIsvHandler extends AbstractWeixinHandler {
    /**
     * 申请/创建小程序
     *
     * @param
     */
    @PayMapping(method = PayMethods.ISV_CREATE)
    public void createIsvMini(PayRequest payRequest) {

        CreateMiniRequest createMiniRequest = new CreateMiniRequest();
        AlipayOpenMiniIsvCreateRequest request = new AlipayOpenMiniIsvCreateRequest();
        request.setBizModel(createMiniRequest);
        try {
            AlipayOpenMiniIsvCreateResponse response =
                    getWeixinClient(payRequest.getAppId()).execute(request);
            // todo 做处理


        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }

    }
}
