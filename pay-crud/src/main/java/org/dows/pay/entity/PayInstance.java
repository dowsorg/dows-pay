package org.dows.pay.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.framework.crud.mybatis.CrudEntity;

import java.util.Date;

/**
 * 支付通道实例(PayInstance)实体类
 *
 * @author lait.zhang
 * @since 2022-09-25 10:13:09
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PayInstance对象", description = "支付通道实例")
public class PayInstance implements CrudEntity {
    private static final long serialVersionUID = -75137209491140632L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键ID")
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

    @ApiModelProperty("时间戳")
    private Date dt;

    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

}

