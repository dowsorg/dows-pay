package org.dows.pay.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.dows.pay.api.response.PayIsvResponse;

/**
 *
 */
@Data
@ToString
@Accessors(chain = true)
@NoArgsConstructor
public class PayQueryIsvRequest extends AbstractPayRequest<PayIsvResponse> {

    @ApiModelProperty("申请单号")
    private String batch_no;
    @ApiModelProperty("应用ID")
    private String appid;

}
