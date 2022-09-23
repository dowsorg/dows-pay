package org.dows.pay.alipay;

import cn.hutool.core.bean.BeanUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayOpenMiniIsvQueryModel;
import com.alipay.api.domain.CreateMiniRequest;
import com.alipay.api.request.AlipayOpenMiniIsvCreateRequest;
import com.alipay.api.request.AlipayOpenMiniIsvQueryRequest;
import com.alipay.api.response.AlipayOpenMiniIsvCreateResponse;
import com.alipay.api.response.AlipayOpenMiniIsvQueryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.message.AlipayMessage;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * 代理商户作业相关业务逻辑，如：代开通或代创建小程序，其他等...
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AlipayIsvHandler extends AbstractAlipayHandler {

    /**
     * 申请/创建小程序
     *
     * @param
     */
    @PayMapping(method = PayMethods.ISV_CREATE)
    public void createIsvMini(PayRequest payRequest) {

        CreateMiniRequest createMiniRequest = BeanUtil.toBean(payRequest.getParams(), CreateMiniRequest.class);
        AlipayOpenMiniIsvCreateRequest request = new AlipayOpenMiniIsvCreateRequest();
        request.setBizModel(createMiniRequest);
        try {
            AlipayOpenMiniIsvCreateResponse response =
                    getAlipayClient(payRequest.getAppId()).certificateExecute(request);
            // todo 做处理
            log.info("收到响应请求:{}", response);


        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * 查询该订单协助创建小程序的情况
     * 服务商调用 alipay.open.mini.isv.query 接口，传入 order_no（订单编号）参数，
     */
    @PayMapping(method = PayMethods.ISV_QUERY)
    public void queryIsvMini(PayRequest payRequest) {

        AlipayOpenMiniIsvQueryModel alipayOpenMiniIsvQueryModel = new AlipayOpenMiniIsvQueryModel();
        AlipayOpenMiniIsvQueryRequest request = new AlipayOpenMiniIsvQueryRequest();
        request.setBizModel(alipayOpenMiniIsvQueryModel);
        AlipayOpenMiniIsvQueryResponse response = null;
        try {
            response = getAlipayClient(payRequest.getAppId()).execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }


    /**
     * 商户确认服务商代创建小程序结果通知
     */
    @EventListener(value = {PayEvent.class})
    public void onIsvMerchantConfirmed(PayEvent<AlipayMessage> payEvent) {
        AlipayMessage payMessage = payEvent.getPayMessage();
        log.info("处理 alipay.open.mini.merchant.confirmed 事件消息:{}", payMessage);
        // todo 业务处理
        String appId = payMessage.getAppId();
        String msgApi = payMessage.getMsgApi();
        String msgId = payMessage.getMsgId();


        String bizContent = payMessage.getBizContent();
        log.info("业务响应:bizContent = {}", bizContent);
    }
}
