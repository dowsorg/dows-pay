package org.dows.pay.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.framework.crud.mybatis.CrudEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付-分账记录(PayAllocation)实体类
 *
 * @author lait.zhang
 * @since 2022-10-13 14:16:26
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PayAllocation对象", description = "支付-分账记录")
public class PayAllocation implements CrudEntity {
    private static final long serialVersionUID = 718418705047950484L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("实际分得金额（订单实际分账金额, 单位：分（订单金额 - 商户手续费 - 已退款金额））")
    private BigDecimal allotedAmount;

    @ApiModelProperty("应分金额（计算该接收方的分账金额,单位分）")
    private BigDecimal allotAmount;

    @ApiModelProperty("订单金额,单位分")
    private BigDecimal payOrderAmount;

    @ApiModelProperty("系统支付订单号")
    private String payOrderId;

    @ApiModelProperty("分账记录ID")
    private String allotId;

    @ApiModelProperty("商户名称")
    private String merchantName;

    @ApiModelProperty("商户号")
    private String merchantNo;

    @ApiModelProperty("应用ID")
    private String appId;

    @ApiModelProperty("分账接收者ID(统一账号ID)快照")
    private String accountId;

    @ApiModelProperty("接收者账号别名快照")
    private String accountName;

    @ApiModelProperty("接收者姓名快照")
    private String userName;

    @ApiModelProperty("系统分账批次号")
    private String batchOrderId;

    @ApiModelProperty("服务商编码")
    private String channelCode;

    @ApiModelProperty("通道应用ID")
    private String channelAppId;

    @ApiModelProperty("支付订单渠道支付订单号")
    private String channelOrderNo;

    @ApiModelProperty("分账接收账号快照")
    private String channelAccountNo;

    @ApiModelProperty("分账接收账号名称快照")
    private String channelAccountName;

    @ApiModelProperty("上游分账批次号")
    private String channelBatchOrderId;

    @ApiModelProperty("类型: 1-普通商户, 2-特约商户(服务商模式)")
    private Boolean merchantType;

    @ApiModelProperty("分账接收账号类型: 0-个人(对私) 1-商户(对公)快照")
    private Boolean channelAccountType;

    @ApiModelProperty("状态: 0-待分账 1-分账成功, 2-分账失败")
    private Boolean state;

    @ApiModelProperty("分账比例快照> 配置的实际分账比例")
    private BigDecimal allocationProfit;

    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

}

