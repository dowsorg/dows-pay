package org.dows.pay.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.resonse.PayIsvResponse;

/**
 *
 */
@Data
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayIsvRequest extends AbstractPayRequest<PayIsvResponse> {

//    @ApiModelProperty("租户或商户编号")
//    private String tenantId;
//    @ApiModelProperty("appId")
//    private String appId;
//    @ApiModelProperty("通道名")
//    private String channel;
//    @ApiModelProperty("业务方法")
//    private String method;
//    @ApiModelProperty("业务模型")
//    private ChannelBizModel channelBizModel;
//    private Class<PayIsvResponse> responseClass;

}
