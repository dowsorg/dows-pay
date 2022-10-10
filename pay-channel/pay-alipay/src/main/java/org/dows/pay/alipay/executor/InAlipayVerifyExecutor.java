package org.dows.pay.alipay.executor;


import org.dows.pay.alipay.constants.AlipayServiceEnvConstants;
import org.dows.pay.api.PayException;

/**
 * 开通服务窗开发者功能处理器
 */
public class InAlipayVerifyExecutor implements ActionExecutor {

    @Override
    public String execute() throws PayException {
        return this.setResponse();
    }

    /**
     * 设置response返回数据
     * 92993f2227e9282e8e00b35e126b2828
     * "<app_cert_sn>92993f2227e9282e8e00b35e126b2828</app_cert_sn>"
     * <p>
     * 公钥方式
     * String builder = "<success>" + Boolean.TRUE + "</success>" +
     * "<app_cert_sn>6cd4ee7e4f31c1adba2380cc65da4a3a</app_cert_sn>" +
     *
     * @return
     */
    private String setResponse() throws PayException {
        //固定响应格式，必须按此格式返回
        String builder = "<success>" + Boolean.TRUE + "</success>" ;
        return builder;
    }
}
