package org.dows.sdk.client;

import org.aopalliance.intercept.Invocation;
import org.springframework.core.Ordered;


public interface ApiChain extends Ordered {

    /**
     * 调用链 调用
     */
    ApiResult doChain(ApiInvoker invoker, Invocation invocation);

}
