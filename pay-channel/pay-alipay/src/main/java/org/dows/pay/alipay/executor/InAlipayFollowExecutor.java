package org.dows.pay.alipay.executor;

import cn.hutool.json.JSONObject;
import org.dows.pay.alipay.util.AlipayMsgBuildUtil;


/**
 * 关注服务窗执行器
 */
public class InAlipayFollowExecutor implements ActionExecutor {

    /**
     * 业务参数
     */
    private JSONObject bizContent;

    public InAlipayFollowExecutor(JSONObject bizContent) {
        this.bizContent = bizContent;
    }

    public InAlipayFollowExecutor() {
        super();
    }

    @Override
    public String execute() {

        //TODO 根据支付宝请求参数，可以将支付宝账户UID-服务窗ID关系持久化，用于后续开发者自己的其他操作
        // 这里只是个样例程序，所以这步省略。
        // 直接构造简单响应结果返回
        final String fromUserId = bizContent.getStr("FromUserId");

        return AlipayMsgBuildUtil.buildBaseAckMsg(fromUserId);
    }
}
