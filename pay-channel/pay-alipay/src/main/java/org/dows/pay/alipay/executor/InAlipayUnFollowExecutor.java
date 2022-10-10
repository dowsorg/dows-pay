package org.dows.pay.alipay.executor;

import cn.hutool.json.JSONObject;
import org.dows.pay.alipay.util.AlipayMsgBuildUtil;

/**
 * 取消关注服务窗执行器
 */
public class InAlipayUnFollowExecutor implements ActionExecutor {

    /**
     * 业务参数
     */
    private JSONObject bizContent;

    public InAlipayUnFollowExecutor(JSONObject bizContent) {
        this.bizContent = bizContent;
    }

    public InAlipayUnFollowExecutor() {
        super();
    }

    @Override
    public String execute() {

        //取得发起请求的支付宝账号id
        final String fromUserId = bizContent.getStr("FromUserId");

        //TODO 根据支付宝请求参数，开发者可以删除之前保存的本地支付宝UID-服务窗ID的关注关系
        // 这里只是个样例程序，所以这步省略。

        return AlipayMsgBuildUtil.buildBaseAckMsg(fromUserId);
    }
}
