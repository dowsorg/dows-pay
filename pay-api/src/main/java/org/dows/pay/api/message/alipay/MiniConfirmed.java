package org.dows.pay.api.message.alipay;

import lombok.Builder;
import lombok.Data;

/**
 * @Author longhui.shi
 * @Date 2023/7/4 10:30
 * @PackageName:org.dows.pay.api.message.alipay
 * @ClassName: MiniConfirmed
 * @Description: TODO 支付宝小程序 结果
 * @Version 1.0
 */
@Builder
@Data
public class MiniConfirmed {
    private String order_no;
    private String out_order_no;
    private String min_app_id;
    private String status;
    private String pid;
}
