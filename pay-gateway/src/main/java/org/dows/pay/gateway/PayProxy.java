package org.dows.pay.gateway;

import lombok.Builder;
import lombok.Data;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.PayRequest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Builder
@Data
public class PayProxy {
    // 支付通道
    private String channel;
    // 支付方法名
    private String payMethodName;
    // 当前该支付方法参数名称列表
    private String payArgNames;


    // spring ioc 容器中bean的名称
    private String beanName;
    // spring ioc 容器中bean的方法名称
    private String beanMethodName;

    // 代理对象的接口
    private PayHandler payHandler;
    // 代理的方法
    private Method method;


    public Object invoke(PayRequest payRequest) {


        try {
            return method.invoke(payHandler,payRequest);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
