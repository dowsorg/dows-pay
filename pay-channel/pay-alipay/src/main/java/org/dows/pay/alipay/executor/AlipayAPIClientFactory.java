package org.dows.pay.alipay.executor;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.dows.pay.alipay.constants.AlipayServiceEnvConstants;


/**
 * API调用客户端工厂
 */
public class AlipayAPIClientFactory {

    /**
     * API调用客户端
     */
    private static AlipayClient alipayClient;

    /**
     * 获得API调用客户端
     *
     * @return
     */
    public static AlipayClient getAlipayClient() {

        if (null == alipayClient) {
            alipayClient = new DefaultAlipayClient(AlipayServiceEnvConstants.ALIPAY_GATEWAY, AlipayServiceEnvConstants.APP_ID,
                    AlipayServiceEnvConstants.PRIVATE_KEY, "json", AlipayServiceEnvConstants.CHARSET, AlipayServiceEnvConstants.ALIPAY_PUBLIC_KEY, AlipayServiceEnvConstants.SIGN_TYPE);
        }
        return alipayClient;
    }
}
