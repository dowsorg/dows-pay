package org.dows.pay.gateway;

import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.annotation.PayMapping;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
@Service
public class PayDispatcher implements ApplicationContextAware {

    // 支付路由表
    private static Map<String, PayProxy> payProxyMap = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, PayHandler> payHandlerMap = applicationContext.getBeansOfType(PayHandler.class);
        payHandlerMap.forEach((k, v) -> {
            Stream.of(v.getClass().getDeclaredMethods())
                    .filter(m -> m.isAnnotationPresent(PayMapping.class))
                    .forEach(m -> {
                        PayMapping payMapping = m.getAnnotation(PayMapping.class);
                        PayProxy payProxy = PayProxy.builder()
                                .beanName(k)
                                .beanMethodName(m.getName())
                                // todo 后期做对象及字段的自动转换和映射
                                .payMethodName(payMapping.method().getNamespace())
                                .payArgNames(payMapping.method().getArgNames())

                                .channel(v.getChannel().toLowerCase())
                                .payHandler(v)
                                .method(m)
                                .build();
                        String payMethodNamespace = payProxy.getPayMethodName() + "." + payProxy.getChannel();
                        payProxyMap.put(payMethodNamespace, payProxy);
                    });
        });
    }

    public Response<PayResponse> dispatcher(PayRequest payRequest) {
        if (payProxyMap.size() < 1) {
            log.error("请配置路由表");
        }


        // todo 做支付请求流水记录数据落es->租户-应用-通道-方法-参数-响应-状态-处理返回值的状态
        payRequest.getAppId();


        PayProxy payProxy = payProxyMap.get(payRequest.getPayNamespace());
        payProxy.invoke(payRequest);
        return Response.ok();
    }


}
