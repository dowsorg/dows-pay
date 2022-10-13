package org.dows.pay.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import org.dows.pay.api.BizModel;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.boot.PayClientFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractAlipayHandler implements PayHandler {

    @Autowired
    private PayClientFactory payClientFactory;

    protected AlipayClient getAlipayClient(String appId) {
        return payClientFactory.getAlipayClient(appId);
    }


    //    protected AlipayMsgClient getAlipayMsgClient(String appId) {
//        return PayClientFactory.getAlipayMsgClient(appId);
//    }
    protected void autoMappingValue(BizModel bizModel, AlipayObject alipayObject) {
        Map<String, Field> alipayFeilds = bizModel.getAlipayFeilds();
        Map<String, Field> collect = Arrays.stream(alipayObject.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(ApiField.class))
                .collect(Collectors.toMap(f -> f.getAnnotation(ApiField.class).value(), Function.identity()));
        // 根据注解匹配动态设置
        collect.forEach((k, field) -> {
            Field bizFiled = alipayFeilds.get(k);
            if (bizFiled != null) {
                try {
                    field.setAccessible(true);
                    Object ovalue = bizFiled.get(bizModel);
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
