package org.dows.sdk.weixin.pay.jczf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_1.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:50
 */
@Data
@Schema(name = "H5下单Request", title = "H5下单Request")
public class H5XiaDanRequest {
    @Schema(title = "")
    private String appid;
    @Schema(title = "")
    private String out_batch_no;
    @Schema(title = "")
    private String batch_name;
    @Schema(title = "")
    private String batch_remark;
    @Schema(title = "")
    private Integer total_amount;
    @Schema(title = "")
    private Integer total_num;
    @Schema(title = "")
    private List transfer_detail_list;
    @Schema(title = "商户系统内部区分转账批次单下不同转账明细单的唯一标识，要求此参数只能由数字、大小写字母组成")
    private String out_detail_no;
    @Schema(title = "转账金额单位为分")
    private Integer transfer_amount;
    @Schema(title = "单条转账备注（微信用户会收到该备注），UTF8编码，最多允许32个字符")
    private String transfer_remark;
    @Schema(title = "openid是微信用户在公众号appid下的唯一用户标识（appid不同，则获取到的openid就不同），可用于永久标记一个用户")
    private String openid;
    @Schema(title = "1、明细转账金额 >= 2,000元，收款用户姓名必填；")
    private String user_name;
    @Schema(title = "该批次转账使用的转账场景，可在「商家转账到零钱 - 产品设置」中查看详情，如不填写则使用商家的默认转账场景")
    private String transfer_scene_id;
}

