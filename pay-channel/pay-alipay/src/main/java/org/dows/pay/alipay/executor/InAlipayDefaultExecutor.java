package org.dows.pay.alipay.executor;

import cn.hutool.json.JSONObject;
import org.dows.pay.alipay.util.AlipayMsgBuildUtil;
import org.dows.pay.api.PayException;


/**
 * 默认执行器(该执行器仅发送ack响应)
 */
public class InAlipayDefaultExecutor implements ActionExecutor {

    /**
     * 业务参数
     */
    private JSONObject bizContent;

    public InAlipayDefaultExecutor(JSONObject bizContent) {
        this.bizContent = bizContent;
    }

    public InAlipayDefaultExecutor() {
        super();
    }


    @Override
    public String execute() throws PayException {

        //取得发起请求的支付宝账号id
        final String fromUserId = bizContent.getStr("FromUserId");

        return AlipayMsgBuildUtil.buildBaseAckMsg(fromUserId);
    }
}
