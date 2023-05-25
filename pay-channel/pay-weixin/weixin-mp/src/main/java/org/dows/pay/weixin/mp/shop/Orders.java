package org.dows.pay.weixin.mp.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.weixin.mp.MpWxClientFactory;
import org.dows.pay.weixin.mp.base.AppSetting;
import org.dows.pay.weixin.mp.base.WxEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单管理相关接口
 */
@Slf4j
public class Orders {

    
    private WxClient wxClient;

    public static Orders defaultOrders() {
        return with(AppSetting.defaultSettings());
    }

    public static Orders with(AppSetting appSetting) {
        Orders orders = new Orders();
        orders.setWxClient(MpWxClientFactory.getInstance().with(appSetting));
        return orders;
    }

    public void setWxClient(WxClient wxClient) {
        this.wxClient = wxClient;
    }

    public Order get(String id) {
        String url = WxEndpoint.get("shop.order.get");
        String body = String.format("{\"order_id\":\"%s\"}", id);
        log.debug("shop: get order by id: {}", id);
        String response = wxClient.post(url, body);
        OrderWrapper orderWrapper = JsonMapper.defaultMapper().fromJson(response, OrderWrapper.class);
        return orderWrapper.getOrder();
    }

    public List<Order> query(Integer status, Date start, Date end) {
        String url = WxEndpoint.get("shop.order.query");

        Map<String, Object> map = new HashMap<>();
        if (status != null) map.put("status", status);
        if (start != null) map.put("begintime", start.getTime() / 1000);
        if (end != null) map.put("endtime", start.getTime() / 1000);

        String body = JsonMapper.defaultMapper().toJson(map);

        log.debug("shop: query orders: {}", body);
        String response = wxClient.post(url, body);
        OrderList orderList = JsonMapper.defaultMapper().fromJson(response, OrderList.class);
        return orderList.getOrders();
    }

    public static class OrderWrapper {

        private Order order;

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }
    }

    @Data
    public static class OrderList {

        private int errcode;
        private String errmsg;

        @JsonProperty("order_list")
        private List<Order> orders;
    }
}
