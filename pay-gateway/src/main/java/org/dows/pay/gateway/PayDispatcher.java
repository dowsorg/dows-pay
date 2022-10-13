package org.dows.pay.gateway;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.PayResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayDispatcher {


    private final RoutingTable routingTable;

    public Response<PayResponse> dispatcher(PayRequest payRequest) {
        PayProxy payProxy = routingTable.findProxy(payRequest.getPayNamespace());

        // todo 做支付请求流水记录数据落es->租户-应用-通道-方法-参数-响应-状态-处理返回值的状态
        payRequest.getAppId();

        return Response.ok(payProxy.invoke(payRequest));
    }


}
