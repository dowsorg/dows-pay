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
 * 支付通道实例(PayInstance)表单
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
@ApiModel(value = "PayInstanceForm 表单对象", description = "支付通道实例")
public class PayInstanceForm implements Serializable {
    private static final long serialVersionUID = -67623628940191763L;
    @JsonIgnore
    private Long id;

    @ApiModelProperty("支付通道实例编号")
    private String instanceNo;

    @ApiModelProperty("通道编号(全局唯一)")
    private String channelNo;

    @ApiModelProperty("通道码（alipay|weixin|......）")
    private String channelCode;

    @ApiModelProperty("通道应用ID")
    private String channelAppId;

    @ApiModelProperty("网关URL")
    private String serviceUrl;

    @ApiModelProperty("消息推送URL")
    private String msgUrl;

    @ApiModelProperty("字符集")
    private String charset;

    @ApiModelProperty("格式")
    private String format;

    @ApiModelProperty("验证模式(公钥模式：psk:0,证书模式：crt:1)")
    private String certModel;

    @ApiModelProperty("私钥")
    private String privateKey;

    @ApiModelProperty("公钥")
    private String payPublicKey;

    @ApiModelProperty("应用公钥证书路径")
    private String appCertPath;

    @ApiModelProperty("公钥证书文件路径")
    private String payCertPath;

    @ApiModelProperty("CA根证书文件路径")
    private String payRootCertPath;

    @ApiModelProperty("加密签名密钥")
    private String secretKey;

    @ApiModelProperty("环境（dev|test|ped|....)")
    private String env;

    @ApiModelProperty("平台商户号")
    private String merchantNo;

    @ApiModelProperty("账号")
    private String accountNo;

    @ApiModelProperty("应用ID")
    private String appId;

    @ApiModelProperty("租户号")
    private String tenantId;

    @ApiModelProperty("状态")
    private Integer state;

    @JsonIgnore
    private Date dt;

    @JsonIgnore
    private Boolean deleted;


}

