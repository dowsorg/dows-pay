package org.dows.pay.form;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 支付交易(PayTransaction)表单
 *
 * @author lait.zhang
 * @since 2022-09-25 10:14:06
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PayTransactionForm 表单对象", description = "支付交易")
public class PayTransactionForm implements Serializable, BizForm {
    private static final long serialVersionUID = 835909251980690170L;
    @JsonIgnore
    private Long id;

    @ApiModelProperty("交易号")
    private String transactionNo;

    @ApiModelProperty("交易名称")
    private String transactionName;

    @ApiModelProperty("支付通道")
    private String payChannel;

    @ApiModelProperty("订单号")
    private String orderId;

    @ApiModelProperty("订单标题")
    private String orderTitle;

    @ApiModelProperty("商户号")
    private String merchantNo;

    @ApiModelProperty("商户名称")
    private String merchantName;

    @ApiModelProperty("交易form方(accountNO)")
    private String dealForm;

    @ApiModelProperty("交易to方(accountNo)")
    private String dealTo;

    @ApiModelProperty("交易金额")
    private BigDecimal amount;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("应用AppId")
    private String appId;

    @ApiModelProperty("租户号")
    private String tenantId;

    @ApiModelProperty("交易状态")
    private Integer status;

    @ApiModelProperty("交易时间")
    private Date transactionTime;

    @ApiModelProperty("用户登录子账户授权openId")
    private String subOpenid;

    @JsonIgnore
    private Date dt;

    @JsonIgnore
    private Boolean deleted;

    // 通道code
    @ApiModelProperty("通道code")
    private String channel;

    // 下单交易类型(APP/JSAPI/NATIVE/MWEB)
    @ApiModelProperty("下单交易类型")
    private String tradeType;

    @ApiModelProperty("付款码")
    private String authCode;

    @ApiModelProperty("微信支付商户号")
    private String mchId;

    @ApiModelProperty(value = "劵信息")
    private List<StoreCouponInfo> couponInfoList;

    @ApiModelProperty(value = "商品类型 1:商品 2:储存卡")
    private Integer transactionType;

    @Data
    public static class StoreCouponInfo {

        @ApiModelProperty(value = "劵id")
        private String couponId;

        @ApiModelProperty(value = "劵金额")
        private BigDecimal amount;
    }

}

