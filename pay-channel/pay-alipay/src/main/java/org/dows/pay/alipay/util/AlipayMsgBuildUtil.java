package org.dows.pay.alipay.util;

import org.dows.pay.alipay.constants.AlipayServiceEnvConstants;

import java.util.Calendar;


/**
 * 消息构造工具
 */
public class AlipayMsgBuildUtil {

    /**
     * 构造单发图文消息
     *
     * @param fromUserId
     * @return
     */
    public static String buildSingleImgTextMsg(String fromUserId) {

        //构建json格式单发图文消息: 所有内容开发者请根据自有业务自行设置响应值，这里只是个样例
        String sb = "{'articles':[{'action_name':'立即查看','desc':'这是图文内容','image_url':'http://pic.alipayobjects.com/e/201311/1PaQ27Go6H_src.jpg','title':'这是标题','url':'https://www.alipay.com/'}],'msg_type':'image-text','to_user_id':'"
                + fromUserId + "'}";

        return sb;
    }

    /**
     * 构造群发图文消息
     *
     * @return
     */
    public static String buildGroupImgTextMsg() {

        //构建json格式群发图文消息: 所有内容开发者请根据自有业务自行设置响应值，这里只是个样例

        return "{'articles':[{'action_name':'立即查看','desc':'这是图文内容','image_url':'http://pic.alipayobjects.com/e/201311/1PaQ27Go6H_src.jpg','title':'这是标题','url':'https://www.alipay.com/'}],'msg_type':'image-text'}";
    }

    /**
     * 构造单发纯文本消息
     *
     * @param fromUserId
     * @return
     */
    public static String buildSingleTextMsg(String fromUserId) {

        //构建json格式单发纯文本消息体： 所有内容开发者请根据自有业务自行设置响应值，这里只是个样例
        String sb = "{'msg_type':'text','text':{'content':'这是纯文本消息'}, 'to_user_id':'" + fromUserId
                + "'}";

        return sb;
    }

    /**
     * 构造群发纯文本消息
     *
     * @return
     */
    public static String buildGroupTextMsg() {

        //构建json格式群发纯文本消息体： 所有内容开发者请根据自有业务自行设置响应值，这里只是个样例

        return "{'msg_type':'text','text':{'content':'这是纯文本消息'}}";
    }

    /**
     * 构造免登图文消息
     *
     * @param fromUserId
     * @return
     */
    public static String buildImgTextLoginAuthMsg(String fromUserId) {

        //免登连接地址，开发者需根据部署服务修改相应服务ip地址
        String url = "http://10.15.132.68:8080/AlipayFuwuDemo/loginAuth.html";

        //构建json格式的单发免登图文消息体     authType 等于 "loginAuth"表示免登消息 ： 所有内容开发者请根据自有业务自行设置响应值，这里只是个样例
        String sb = "{'articles':[{'action_name':'立即查看','desc':'这是图文内容','image_url':'http://pic.alipayobjects.com/e/201311/1PaQ27Go6H_src.jpg','title':'这是标题','url':'"
                + url
                + "', 'auth_type':'loginAuth'}],'msg_type':'image-text', 'to_user_id':'"
                + fromUserId + "'}";

        return sb;
    }

    /**
     * 构造基础的响应消息
     *
     * @return
     */
    public static String buildBaseAckMsg(String fromUserId) {
        String sb = "<XML>" +
                "<ToUserId><![CDATA[" + fromUserId + "]]></ToUserId>" +
                "<AppId><![CDATA[" + AlipayServiceEnvConstants.APP_ID + "]]></AppId>" +
                "<CreateTime>" + Calendar.getInstance().getTimeInMillis() + "</CreateTime>" +
                "<MsgType><![CDATA[ack]]></MsgType>" +
                "</XML>";
        return sb;
    }

}
