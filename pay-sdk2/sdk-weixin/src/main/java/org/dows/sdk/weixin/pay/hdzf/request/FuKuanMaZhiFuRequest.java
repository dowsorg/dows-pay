package org.dows.sdk.weixin.pay.hdzf.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/index.shtml#menu00
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午5:32:39
 */
@Data
@Schema(name = "付款码支付Request", title = "付款码支付Request")
public class FuKuanMaZhiFuRequest{
}

