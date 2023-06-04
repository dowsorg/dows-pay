package org.dows.sdk.client.core;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.sdk.client.ApiChain;
import org.dows.sdk.client.ApiConfiguration;
import org.dows.sdk.client.ApiInvoker;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
@Data
@Slf4j
@Service
@RequiredArgsConstructor
public class ApiService {


    private final ApiUrlProperties apiUrlProperties;
    private final ApiDispatcher apiDispatcher;
    private ApiConfiguration configuration;
    private ApiInvoker startInvoker = null;
    private Map<Class<?>, Object> serviceCache = new ConcurrentHashMap<>();


    public void init() {
        //创建调用链
        //configuration.init();
        List<ApiChain> chains = configuration.getChains();

        //排序
        Collections.sort(chains, new Comparator<ApiChain>() {
            @Override
            public int compare(ApiChain o1, ApiChain o2) {
                int order1 = o1.getOrder();
                int order2 = o2.getOrder();
                return order2 > order1 ? 1 : -1;
            }
        });

        ApiInvoker last = null;
        for (int i = chains.size() - 1; i >= 0; i--) {
            final ApiChain chain = chains.get(i);
            final ApiInvoker next = last;
            /*last = new ApiInvoker() {
                @Override
                public ApiResult invoke(Invocation invocation) {
                    return chain.doChain(next, invocation);
                }
            };*/
        }
        startInvoker = last;
    }

    public <T> T getOrCreateService(Class<T> serviceCls) {
        Object service;
        if (!serviceCache.containsKey(serviceCls)) {
            try {
                service = createService(serviceCls);
            } catch (Exception e) {
                String msg = String.format("服务创建失败! serviceCls [" + serviceCls + "]");
                log.error(msg, e);
                throw new RuntimeException(msg);
            }
            serviceCache.put(serviceCls, service);
        } else {
            service = serviceCache.get(serviceCls);
        }
        return (T) service;
    }

    /**
     * 创建代理服务,对代理类和头参数等进行封装
     *
     * @param serviceCls 服务接口类
     * @return
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private Object createService(final Class<?> serviceCls) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        ProxyFactory factory = new ProxyFactory();
        if (serviceCls.isInterface()) {
            factory.setInterfaces(new Class[]{serviceCls});
        } else {
            String msg = String.format("类[%s]不是接口!", serviceCls);
            log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        return factory.create(null, null, new ApiMethodHandler(serviceCls));
    }

    @Override
    public String toString() {
        return "ApiService{" +
//                "apiUrlProperties=" + apiUrlProperties +
//                ", apiDispatcher=" + apiDispatcher +
//                ", configuration=" + configuration +
//                ", startInvoker=" + startInvoker +
//                ", serviceCache=" + serviceCache +
                '}';
    }

    class ApiMethodHandler implements MethodHandler {

        private Class<?> serviceCls;

        public ApiMethodHandler(Class<?> serviceCls) {
            this.serviceCls = serviceCls;
        }

        public Object invoke(Object target, Method method, Method arg2, Object[] args) throws Throwable {

            String m = method.getDeclaringClass().getName() + "." + method.getName();
            Class<?> returnType = method.getReturnType();
            String url = apiUrlProperties.getWeixin().get(m);
            if (StrUtil.isBlank(url)) {
                throw new RuntimeException("系统异常,url不存在!");
            }
            int length = args.length;
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i < length; i++) {
                jsonObject.putAll(JSONUtil.parseObj(args[i]));
            }

            /**
             * todo 设置请求参数
             *
             */
            JSONObject result = apiDispatcher.dispatch("", url, jsonObject);
            // todo 参数码表，确认具体平台-业务线
            if (result.containsKey("errcode")) {
                throw new RuntimeException("error: " + result.toString());
            }
            return result.toBean(returnType);
        }


        @Override
        public String toString() {
            return "ApiMethodHandler{" +
                    //"serviceCls=" + serviceCls +
                    '}';
        }
    }


}
