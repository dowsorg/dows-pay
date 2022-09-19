package org.dows.pay.boot;


import org.dows.pay.api.PayHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class PayHandlerHolder implements ApplicationContextAware {


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> payHandlerMap = applicationContext.getBeansWithAnnotation(PayHandler.class);


    }
}
