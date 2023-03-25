package org.dows.pay.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.annotation.WeixinApiField;

import java.io.Serializable;
import java.util.Date;

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
@ApiModel(value = "PaySpWithDrawTransactionForm 表单对象", description = "平台提现交易")
public class PaySpWithDrawTransactionForm implements Serializable, BizForm {
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

    @ApiModelProperty("应用id")
    private String appId;

    @ApiModelProperty("租户号")
    private String tenantId;

    @ApiModelProperty("交易状态")
    private Integer status;

    @ApiModelProperty("交易时间")
    private Date transactionTime;

    @JsonIgnore
    private Date dt;

    @JsonIgnore
    private Boolean deleted;

    /**
     * <pre>
     * 字段名：商户提现单号
     * 变量名：out_request_no
     * 是否必填：是
     * 类型：string（32）
     * 描述：
     *  商户提现单号，由商户自定义生成。
     * 示例值：20190611222222222200000000012122
     * </pre>
     */
    @WeixinApiField(name = "out_request_no")
    @ApiModelProperty("商户提现单号")
    private String outRequestNo;

    /**
     * <pre>
     * 字段名：提现金额
     * 变量名：amount
     * 是否必填：是
     * 类型：int64
     * 描述：
     *  提现金额，单位：分（RMB）
     * 示例值：1
     * </pre>
     */
    @WeixinApiField(name = "amount")
    @ApiModelProperty("提现金额")
    private Integer amount;

    /**
     * <pre>
     * 字段名：备注
     * 变量名：remark
     * 是否必填：否
     * 类型：string（56）
     * 描述：
     *  商户对提现单的备注
     * 示例值：交易提现
     * </pre>
     */
    @WeixinApiField(name = "remark")
    @ApiModelProperty("备注")
    private String remark;

    /**
     * <pre>
     * 字段名：银行附言
     * 变量名：bank_memo
     * 是否必填：否
     * 类型：string（32）
     * 描述：
     *  展示在收款银行系统中的附言，数字、字母最长32个汉字（能否成功展示依赖银行系统支持）。
     * 示例值：xx平台提现
     * </pre>
     */
    @WeixinApiField(name = "bank_memo")
    @ApiModelProperty("银行附言")
    private String bankMemo;

    /**
     * <pre>
     * 字段名：账户类型
     * 变量名：account_type
     * 是否必填：是
     * 类型：string（16）
     * 描述：
     *  枚举值：
     *    BASIC：基本账户
     *    OPERATION：运营账户
     *    FEES：手续费账户
     * 示例值：BASIC
     * </pre>
     */
    @WeixinApiField(name = "account_type")
    @ApiModelProperty("账户类型")
    private String accountType;

}

