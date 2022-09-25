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

import java.util.Date;

/**
 * 支付规则(PayRule)实体类
 *
 * @author lait.zhang
 * @since 2022-09-25 10:13:09
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PayRule对象", description = "支付规则")
public class PayRule implements CrudEntity {
    private static final long serialVersionUID = -64676787144784791L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("规则编号")
    private String ruleNo;

    @ApiModelProperty("规则名称")
    private String ruleName;

    @ApiModelProperty("规则码")
    private String ruleCode;

    @ApiModelProperty("提取接口，业务方提供，参数为ruleExpr，根据cron表达式")
    private String dataApi;

    @ApiModelProperty("通道编号(全局唯一)")
    private String channelNo;

    @ApiModelProperty("商户号")
    private String merchantNo;

    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

    @ApiModelProperty("时间戳")
    private Date dt;

}

