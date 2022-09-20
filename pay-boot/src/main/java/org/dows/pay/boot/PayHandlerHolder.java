//package org.dows.pay.boot;
//
//
//import org.dows.pay.api.PayHandler;
//import org.dows.pay.gateway.PayProxy;
//import org.dows.pay.api.annotation.PayMapping;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Stream;
//
//
//@Component
//public class PayHandlerHolder implements ApplicationContextAware {
//    private List<PayProxy> payProxys = new ArrayList<>();
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        Map<String, PayHandler> payHandlerMap = applicationContext.getBeansOfType(PayHandler.class);
//        payHandlerMap.forEach((k, v) -> {
//            Stream.of(v.getClass().getDeclaredMethods())
//                    .filter(m -> m.isAnnotationPresent(PayMapping.class))
//                    .forEach(m -> {
//                        PayProxy payProxy = PayProxy.builder()
//                                .beanName(k)
//                                .method(m.getName())
//                                .channel(v.getChannel().toLowerCase())
//                                .payHandler(v)
//                                .build();
//                        payProxys.add(payProxy);
//                    });
//        });
//    }
//
//
//}
