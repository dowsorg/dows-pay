package org.dows.pay.form;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付交易明细(PayDetails)表单
 *
 * @author lait.zhang
 * @since 2022-09-25 09:35:52
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PayDetailsForm 表单对象", description = "支付交易明细")
public class PayDetailsForm implements Serializable {
    private static final long serialVersionUID = 836604683082310060L;
    private Long id;

    private Boolean deleted;

    private Date dt;


}

