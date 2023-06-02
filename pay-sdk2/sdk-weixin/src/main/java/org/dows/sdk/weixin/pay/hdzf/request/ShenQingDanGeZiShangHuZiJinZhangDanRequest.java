package org.dows.sdk.weixin.pay.hdzf.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_20.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午5:32:39
 */
@Data
@Schema(name = "申请单个子商户资金账单Request", title = "申请单个子商户资金账单Request")
public class ShenQingDanGeZiShangHuZiJinZhangDanRequest{
}

