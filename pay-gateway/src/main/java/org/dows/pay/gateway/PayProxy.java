package org.dows.pay.gateway;

import cn.hutool.json.JSONUtil;
import lombok.Builder;
import lombok.Data;
import org.dows.framework.api.exceptions.BizException;
import org.dows.pay.api.DefaultPayResponse;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.PayResponse;

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


    public PayResponse invoke(PayRequest payRequest) {
        try {
            Object obj = method.invoke(payHandler, payRequest);
            if (obj instanceof PayResponse) {
                return (PayResponse) obj;
            }
            DefaultPayResponse defaultPayResponse = new DefaultPayResponse();
            defaultPayResponse.setBody(JSONUtil.toJsonStr(obj));
            return defaultPayResponse;
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException!=null) {
                throw new BizException(targetException.getMessage());
            }
            throw new BizException("方法内部报错");
        } catch (Exception e) {
            throw new BizException("方法内部报错");
        }
    }
}
