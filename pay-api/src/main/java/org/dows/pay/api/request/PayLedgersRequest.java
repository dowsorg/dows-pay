package org.dows.pay.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.response.PayLedgersResponse;

@EqualsAndHashCode
@Data
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PayLedgersRequest对象", description = "分账配置请求对象")
public class PayLedgersRequest extends AbstractPayRequest<PayLedgersResponse> {

}
