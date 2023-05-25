package org.dows.pay.weixin.mp.care;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.weixin.mp.MpWxClientFactory;
import org.dows.pay.weixin.mp.base.AppSetting;
import org.dows.pay.weixin.mp.base.WxEndpoint;
import org.dows.pay.weixin.mp.care.bean.SessionLog;
import org.dows.pay.weixin.mp.care.bean.WaitingSessions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客服会话管理
 */
@Slf4j
public class Sessions {

    

    private WxClient wxClient;

    public static Sessions defaultSessions() {
        return with(AppSetting.defaultSettings());
    }

    public static Sessions with(AppSetting appSetting) {
        Sessions sessions = new Sessions();
        sessions.setWxClient(MpWxClientFactory.getInstance().with(appSetting));
        return sessions;
    }

    public void setWxClient(WxClient wxClient) {
        this.wxClient = wxClient;
    }

    /**
     * 创建回话
     *
     * @param care   客服账号
     * @param openId openid
     * @param text   消息
     */
    public void create(String care, String openId, String text) {
        String url = WxEndpoint.get("url.care.session.create");
        Map<String, String> request = new HashMap<>();
        request.put("kf_account", care);
        request.put("openid", openId);
        if (!(text == null || "".equals(text))) {
            request.put("text", text);
        }

        String json = JsonMapper.nonEmptyMapper().toJson(request);
        log.debug("create session: {}", json);
        wxClient.post(url, json);
    }

    /**
     * 关闭回话
     *
     * @param care   客服账号
     * @param openId openid
     * @param text   消息
     */
    public void close(String care, String openId, String text) {
        String url = WxEndpoint.get("url.care.session.close");
        Map<String, String> request = new HashMap<>();
        request.put("kf_account", care);
        request.put("openid", openId);
        if (!(text == null || "".equals(text))) {
            request.put("text", text);
        }

        String json = JsonMapper.nonEmptyMapper().toJson(request);
        log.debug("close session: {}", json);
        wxClient.post(url, json);
    }

    /**
     * 获取客户回话状态
     *
     * @param openId
     * @return
     */
    public Session get(String openId) {
        String url = WxEndpoint.get("url.care.session.get");

        String response = wxClient.get(String.format(url, openId));
        log.debug("get session {} for user: {}", response, openId);
        return JsonMapper.defaultMapper().fromJson(response, Session.class);
    }

    /**
     * 获取某客服人员会话列表
     *
     * @param account 客服账号
     * @return
     */
    public List<Session> getSessionsByAccount(String account) {
        String url = WxEndpoint.get("url.care.session.list.byaccount");
        String response = wxClient.get(String.format(url, account));
        log.debug("list care sessions by care account :{}", response);
        SessionList sessionList = JsonMapper.defaultMapper().fromJson(response, SessionList.class);
        return sessionList.getSessions();
    }

    /**
     * 获取未接入会话列表
     *
     * @return
     */
    public WaitingSessions getWaitingSessions() {
        String url = WxEndpoint.get("url.care.session.listwait");
        String response = wxClient.get(url);
        log.debug("list care waiting sessions :{}", response);
        WaitingSessions sessionList = JsonMapper.defaultMapper().fromJson(response, WaitingSessions.class);
        return sessionList;
    }

    /**
     * 获取客服聊天记录
     *
     * @param start 开始时间
     * @param end   结束时间
     * @param index 查询第几页
     * @param size  每页大小
     * @return 聊天记录
     */
    public List<SessionLog> listSessionLogs(Date start, Date end, int index, int size) {
        String url = WxEndpoint.get("url.care.session.logs");
        Map<String, Object> request = new HashMap<>();
        request.put("starttime", start.getTime() / 1000);
        request.put("endtime", end.getTime() / 1000);
        request.put("pageindex", index);
        request.put("pagesize", size);

        String json = JsonMapper.nonEmptyMapper().toJson(request);
        log.debug("get session logs: {}", json);
        String response = wxClient.post(url, json);
        SessionLogList sessionLogList = JsonMapper.defaultMapper().fromJson(response, SessionLogList.class);
        return sessionLogList.getLogs();
    }

    public static class SessionList {

        @JsonProperty("sessionlist")
        private List<Session> sessions;

        public List<Session> getSessions() {
            return sessions;
        }

        public void setSessions(List<Session> sessions) {
            this.sessions = sessions;
        }
    }

    public static class SessionLogList {

        @JsonProperty("sessionlist")
        private List<SessionLog> logs;

        public List<SessionLog> getLogs() {
            return logs;
        }

        public void setLogs(List<SessionLog> logs) {
            this.logs = logs;
        }
    }
}
