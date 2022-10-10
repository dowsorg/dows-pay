package org.dows.pay.alipay.executor;

import org.dows.pay.api.PayException;

/**
 * 业务执行接口
 */
public interface ActionExecutor {

    /**
     * 业务执行方法
     *
     * @return
     */
    String execute() throws PayException;

}
