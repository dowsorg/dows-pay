package org.dows.pay.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.bo.WxFastMaCategoryBo;

import java.util.List;


@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "WxFastMaCategoryForm 表单对象", description = " 支付宝/微信添加类目")
@Data
public class WxFastMaCategoryForm implements BizForm {

    @ApiModelProperty("平台应用ID")
    private String appId;

    // 通道code
    @ApiModelProperty("通道code")
    private String channel;

    // 账号
    @ApiModelProperty("账号")
    private String account;


    // 应用名称
    @ApiModelProperty("申请应用名称")
    private String appName;

    /**
     * 一级类目ID.
     */
    @ApiModelProperty("一级类目ID")
    private int first;

    /**
     * 二级类目ID.
     */
    @ApiModelProperty("二级类目ID")
    private int second;

    /**
     * 资质信息.
     */
    @ApiModelProperty("资质信息")
    private List<WxFastMaCategoryBo.Certificate> certicates;

    /**
     * 二级类目ID.
     */
    @ApiModelProperty("接口调用凭证，该参数为 URL 参数，非 Body 参数。使用authorizer_access_token")
    private String authorizerAccessToken;

    @Data
    public static class Certificate {
        @ApiModelProperty("key")
        private String key;
        @ApiModelProperty( "value")
        private String value;
    }

}
