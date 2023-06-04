package org.dows.sdk.client.core;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
@Data
public class ApiFactoryBean<T> implements FactoryBean<T>, BeanPostProcessor {

    private ApiService apiService;

    private Class<?> targetClass;

    @Override
    public T getObject() throws Exception {
        return (T) apiService.getOrCreateService(targetClass);
    }

    @Override
    public Class<?> getObjectType() {
        return targetClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().equals(ApiService.class)) {
            this.apiService = (ApiService) bean;
        }
        return bean;
    }
}
