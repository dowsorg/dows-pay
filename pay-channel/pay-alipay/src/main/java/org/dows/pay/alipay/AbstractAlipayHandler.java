package org.dows.pay.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.api.response.PayQueryRes;
import org.dows.pay.boot.PayClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractAlipayHandler implements PayHandler {
    protected final Map<Class, Map<String, Field>> ALIPAY_OBJECT_MODLE_FIELD_MAP = new ConcurrentHashMap<>();
    @Autowired
    private PayClientFactory payClientFactory;
    @Autowired
    protected ApplicationEventPublisher applicationEventPublisher;

    protected AlipayClient getAlipayClient(String appId) {
        return payClientFactory.getAlipayClient(appId);
    }

    @Autowired
    protected ApplicationContext applicationContext;
    /**
     * 自动填充接口映射值
     *
     * @param payRequest
     * @param alipayObject
     */
    protected void autoMappingValue(PayRequest payRequest, AlipayObject alipayObject) {
        ChannelBizModel channelBizModel = payRequest.getBizModel();
        Map<String, Field> alipayFeilds = channelBizModel.getAlipayFeilds();
        Map<String, Field> collect = ALIPAY_OBJECT_MODLE_FIELD_MAP.get(alipayObject.getClass());
        if (collect == null) {
            collect = Arrays.stream(alipayObject.getClass().getDeclaredFields())
                    .filter(f -> f.isAnnotationPresent(ApiField.class))
                    .collect(Collectors.toMap(f -> f.getAnnotation(ApiField.class).value(), Function.identity()));
            ALIPAY_OBJECT_MODLE_FIELD_MAP.put(alipayObject.getClass(), collect);
        }
        // 根据注解匹配动态设置
        collect.forEach((k, field) -> {
            Field bizFiled = alipayFeilds.get(k);
            if (bizFiled != null) {
                try {
                    bizFiled.setAccessible(true);
                    Object ovalue = bizFiled.get(channelBizModel);
                    field.setAccessible(true);
                    field.set(alipayObject, ovalue);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public String getChannel() {
        return PayChannels.ALIPAY.name();
    }

}
