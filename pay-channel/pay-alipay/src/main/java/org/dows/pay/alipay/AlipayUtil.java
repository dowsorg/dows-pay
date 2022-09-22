package org.dows.pay.alipay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alipay.api.AlipayObject;
import com.alipay.api.domain.CreateMiniRequest;
import com.alipay.api.internal.mapping.ApiField;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.ParamName;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AlipayUtil {

    public static void main(String[] args) {


        System.out.println(JSON.toJSONString(new CreateMiniRequest(), SerializerFeature.WriteMapNullValue, SerializerFeature.PrettyFormat));
    }


    /**
     * 自动对比设置参数
     *
     * @param payRequest
     * @param alipayObject
     */
    public void setParamsValeu(PayRequest payRequest, AlipayObject alipayObject) {
        // todo 后期初始化统一参数名到ioc中，减少每次的生成
        Map<String, Field> uniParamMap = Arrays.stream(payRequest.getClass().getFields())
                .filter(f -> f.isAnnotationPresent(ParamName.class))
                .collect(Collectors.toMap(f -> f.getAnnotation(ParamName.class).value(), Function.identity()));
        Map<String, Field> payParamMap = Arrays.stream(alipayObject.getClass().getFields())
                .filter(f -> f.isAnnotationPresent(ApiField.class))
                .collect(Collectors.toMap(f -> f.getAnnotation(ApiField.class).value(), Function.identity()));
        // todo 通过提前定义，对比自动设置
        uniParamMap.forEach((k, v) -> {
            Field field = payParamMap.get(k);
            if (field != null) {
                field.setAccessible(true);
                try {
                    // 设置公共参数
                    field.set(alipayObject, v.get(payRequest));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

        });
    }
}
