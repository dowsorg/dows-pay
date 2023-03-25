package org.dows.pay.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.ChannelBizModel;
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
public class PaySubWithDrawTransactionBo implements ChannelBizModel {

    /**
     * <pre>
     * 字段名：二级商户号
     * 变量名：sub_mchid
     * 是否必填：是
     * 类型：string（32）
     * 描述：
     *  电商平台二级商户号，由微信支付生成并下发。
     * 示例值：1900000109
     * </pre>
     */
    @WeixinApiField(name = "sub_mchid")
    @ApiModelProperty("二级商户号")
    private String subMchid;

    /**
     * <pre>
     * 字段名：商户提现单号
     * 变量名：out_request_no
     * 是否必填：是
     * 类型：string（32）
     * 描述：
     *  必须是字母数字
     * 示例值： 20190611222222222200000000012122
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
     *  提现金额（单位：分）
     * 示例值：100
     * </pre>
     */
    @WeixinApiField(name = "out_request_no")
    @ApiModelProperty("商户提现单号")
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
     * 示例值：微信支付提现
     * </pre>
     */
    @WeixinApiField(name = "bank_memo")
    @ApiModelProperty("银行附言")
    private String bankMemo;


}

