package org.dows.pay.form;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付流水(PayWater)表单
 *
 * @author lait.zhang
 * @since 2022-09-25 09:35:53
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PayWaterForm 表单对象", description = "支付流水")
public class PayWaterForm implements Serializable {
    private static final long serialVersionUID = -30136357050748753L;
    private Long id;

    private Boolean deleted;

    private Date dt;


}

