package org.dows.pay.weixin;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.alipay.api.internal.mapping.ApiField;
import com.github.binarywang.wxpay.bean.request.BaseWxPayRequest;
import com.github.binarywang.wxpay.service.WxPayService;
import com.google.gson.annotations.SerializedName;
import me.chanjar.weixin.open.api.WxOpenMaBasicService;
import me.chanjar.weixin.open.api.WxOpenMaService;
import me.chanjar.weixin.open.api.WxOpenService;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.boot.PayClientFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractWeixinHandler implements PayHandler {
    protected final Map<Class, Map<String, Field>> WX_OBJECT_MODLE_FIELD_MAP = new ConcurrentHashMap<>();
    @Autowired
    private PayClientFactory payClientFactory;

    /**
     * todo 改换成微信的
     *
     * @param appId
     * @return
     */
    protected WxPayService getWeixinClient(String appId) {

        return payClientFactory.getWeixinClient(appId);

    }
    /**
     * todo 微信小程序
     *
     * @param appId
     * @return
     */
    protected WxOpenService getWxOpenClient(String appId) {

        return payClientFactory.getWxOpenClient(appId);

    }

    /**
     * todo 微信小程序-服务商管理二级商户
     *
     * @param appId
     * @return
     */
    protected WxOpenMaService getWxOpenMaClient(String appId) {

        return payClientFactory.getWxOpenMaClient(appId);

    }


    /**
     * 自动填充接口映射值
     *
     * @param payRequest
     * @param wxObject
     */
    protected void autoMappingValue(PayRequest payRequest, Object wxObject) {
        ChannelBizModel channelBizModel = payRequest.getBizModel();
        Map<String, Field> weixinFeilds = channelBizModel.getWeixinFeilds();
        Map<String, Field> collect = WX_OBJECT_MODLE_FIELD_MAP.get(wxObject.getClass());
        if (collect == null ) {
            collect = Arrays.stream(wxObject.getClass().getDeclaredFields())
                    .filter(f -> f.isAnnotationPresent(SerializedName.class))
                    .collect(Collectors.toMap(f -> f.getAnnotation(SerializedName.class).value(), Function.identity()));
            WX_OBJECT_MODLE_FIELD_MAP.put(wxObject.getClass(), collect);
        }
        // 根据注解匹配动态设置
        collect.forEach((k, field) -> {
            Field bizFiled = weixinFeilds.get(k);
            if (bizFiled != null) {
                try {
                    bizFiled.setAccessible(true);
                    Object ovalue = bizFiled.get(channelBizModel);
                    field.setAccessible(true);
                    field.set(wxObject, ovalue);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    public String getChannel() {
        return PayChannels.WEIXIN.name();
    }
}
