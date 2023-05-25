package org.dows.pay.weixin.mp.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
public class Order {

    @JsonProperty("order_id")
    private String id;

    @JsonProperty("order_status")
    private int status;

    @JsonProperty("order_total_price")
    private long totalPrice;

    @JsonProperty("order_create_time")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    private Date created;

    @JsonProperty("order_express_price")
    private long expressPrice;

    @JsonProperty("buyer_openid")
    private String buyerOpenId;

    @JsonProperty("buyer_nick")
    private String buyerNickName;

    @JsonProperty("receiver_name")
    private String receiverName;

    @JsonProperty("receiver_province")
    private String receiverProvince;

    @JsonProperty("receiver_city")
    private String receiverCity;

    @JsonProperty("receiver_zone")
    private String receiverZone;

    @JsonProperty("receiver_address")
    private String receiverAddress;

    @JsonProperty("receiver_mobile")
    private String receiverMobile;

    @JsonProperty("receiver_phone")
    private String receiverPhone;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("product_price")
    private long productPrice;

    @JsonProperty("product_sku")
    private String productSku;

    @JsonProperty("product_count")
    private int productCount;

    @JsonProperty("product_img")
    private String productImage;

    @JsonProperty("delivery_id")
    private String deliveryId;

    @JsonProperty("delivery_company")
    private String deliveryCompany;

    @JsonProperty("trans_id")
    private String transactionId;

}
