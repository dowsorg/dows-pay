package org.dows.sdk.client;

import org.aopalliance.intercept.Invocation;

/**
 *
 */
public interface ApiInvoker {

    ApiResult invoke(Invocation invocation);

}
