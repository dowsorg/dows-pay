package org.dows.pay.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * @since 2022-09-25 10:14:05
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
    private static final long serialVersionUID = 261357933734408479L;
    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Boolean deleted;

    @JsonIgnore
    private Date dt;


}

