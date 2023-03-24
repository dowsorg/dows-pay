package org.dows.pay.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 支付交易(PayTransaction)表单
 *
 * @author lait.zhang
 * @since 2022-09-25 10:14:06
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PayPartnerTransactionForm 表单对象", description = "支付交易")
public class PayPartnerTransactionForm implements Serializable, BizForm {
    private static final long serialVersionUID = -1550405819444680465L;
    @JsonIgnore
    private Long id;

    @ApiModelProperty("交易号")
    private String transactionNo;

    @ApiModelProperty("交易名称")
    private String transactionName;

    @ApiModelProperty("支付通道")
    private String payChannel;

    @ApiModelProperty("订单号")
    private String orderId;

    @ApiModelProperty("订单标题")
    private String orderTitle;

    @ApiModelProperty("应用id")
    private String appId;

    @ApiModelProperty("租户号")
    private String tenantId;

    @ApiModelProperty("交易状态")
    private Integer status;

    @ApiModelProperty("交易时间")
    private Date transactionTime;

    @JsonIgnore
    private Date dt;

    @JsonIgnore
    private Boolean deleted;


    /**
     * <pre>
     * 字段名：服务商公众号ID
     * 变量名：sp_appid
     * 是否必填：是
     * 类型：string（32）
     * 描述：
     *  服务商申请的公众号或移动应用appid
     *  示例值：wx8888888888888888
     * </pre>
     */
    @ApiModelProperty("服务商公众号ID")
    private String spAppid;
    /**
     * <pre>
     * 字段名：服务商户号
     * 变量名：sp_mchid
     * 是否必填：是
     * 类型：string（32）
     * 描述：
     *  服务商户号，由微信支付生成并下发
     *  示例值：1230000109
     * </pre>
     */
    @ApiModelProperty("服务商户号")
    private String spMchid;
    /**
     * <pre>
     * 字段名：子商户公众号ID
     * 变量名：sub_appid
     * 是否必填：否
     * 类型：string（32）
     * 描述：
     *  子商户申请的公众号或移动应用appid。
     *  示例值：wxd678efh567hg6999
     * </pre>
     */
    @ApiModelProperty("子商户公众号ID")
    private String subAppid;
    /**
     * <pre>
     * 字段名：二级商户号
     * 变量名：sub_mchid
     * 是否必填：是
     * 类型：string（32）
     * 描述：
     *  二级商户的商户号，有微信支付生成并下发。
     *  示例值：1900000109
     * </pre>
     */
    @ApiModelProperty("二级商户号")
    private String subMchid;
    /**
     * <pre>
     * 字段名：商品描述
     * 变量名：description
     * 是否必填：是
     * 类型：string（127）
     * 描述：
     *  商品描述
     *  示例值：Image形象店-深圳腾大-QQ公仔
     * </pre>
     */
    @ApiModelProperty("商品描述")
    private String description;
    /**
     * <pre>
     * 字段名：商户订单号
     * 变量名：out_trade_no
     * 是否必填：是
     * 类型：string（127）
     * 描述：
     *  商户系统内部订单号, 只能是数字、大小写字母_-*且在同一个商户号下唯一，详见【商户订单号】
     *  特殊规则：最小字符长度为6
     *  示例值：1217752501201407033233368018
     * </pre>
     */
    @ApiModelProperty("商户订单号")
    private String outTradeNo;
    /**
     * <pre>
     * 字段名：交易结束时间
     * 变量名：time_expire
     * 是否必填：否
     * 类型：string(14)
     * 描述：
     *  订单失效时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
     *  示例值：2019-12-31T15:59:60+08:00
     * </pre>
     */
    @ApiModelProperty("交易结束时间")
    private String timeExpire;
    /**
     * <pre>
     * 字段名：附加数据
     * 变量名：attach
     * 是否必填：否
     * 类型：string(128)
     * 描述：
     *  附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
     *  示例值：自定义数据
     * </pre>
     */
    @ApiModelProperty("附加数据")
    private String attach;
    /**
     * <pre>
     * 字段名：通知地址
     * 变量名：notify_url
     * 是否必填：是
     * 类型：string（127）
     * 描述：
     *  通知URL必须为直接可访问的URL，不允许携带查询串。
     *  示例值：https://www.weixin.qq.com/wxpay/pay.php
     * </pre>
     */
    @ApiModelProperty("通知地址")
    private String notifyUrl;
    /**
     * <pre>
     * 字段名：订单优惠标记
     * 变量名：goods_tag
     * 是否必填：否
     * 类型：string（32）
     * 描述：
     *  订单优惠标记
     *  示例值：WXG
     * </pre>
     */
    @ApiModelProperty("订单优惠标记")
    private String goodsTag;
    /**
     * <pre>
     * 字段名：电子发票入口开放标识
     * 变量名：support_fapiao
     * 是否必填：否
     * 类型：boolean
     * 描述：传入true时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效。
     * </pre>
     */
    @ApiModelProperty("电子发票入口开放标识")
    private Boolean supportFapiao;
    /**
     * <pre>
     * 字段名：+结算信息
     * 变量名：settle_info
     * 是否必填：否
     * 类型：Object
     * 描述：结算信息
     * </pre>
     */
    @ApiModelProperty("结算信息")
    private SettleInfo settleInfo;
    /**
     * <pre>
     * 字段名：订单金额
     * 变量名：amount
     * 是否必填：是
     * 类型：object
     * 描述：
     *  订单金额信息
     * </pre>
     */
    @ApiModelProperty("订单金额")
    private Amount amount;
    /**
     * <pre>
     * 字段名：优惠功能
     * 变量名：detail
     * 是否必填：否
     * 类型：object
     * 描述：
     *  优惠功能
     * </pre>
     */
    @ApiModelProperty("优惠功能")
    private Discount detail;
    /**
     * <pre>
     * 字段名：支付者
     * 变量名：payer
     * 是否必填：是（仅JSAPI支付必传）
     * 类型：object
     * 描述：
     *  支付者信息
     * </pre>
     */
    @ApiModelProperty("支付者")
    private Payer payer;
    /**
     * <pre>
     * 字段名：场景信息
     * 变量名：scene_info
     * 是否必填：是（仅H5支付必传）
     * 类型：object
     * 描述：
     *  支付场景描述
     * </pre>
     */
    @ApiModelProperty("场景信息")
    private SceneInfo sceneInfo;

    @Data
    @NoArgsConstructor
    public static class Discount implements Serializable {
        private static final long serialVersionUID = 1090134053810201492L;

        /**
         * <pre>
         * 字段名：订单原价
         * 变量名：cost_price
         * 是否必填：否
         * 类型：int64
         * 描述：
         *  1、商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的交易金额。
         *  2、当订单原价与支付金额不相等，则不享受优惠。
         *  3、该字段主要用于防止同一张小票分多次支付，以享受多次优惠的情况，正常支付订单不必上传此参数。
         *  示例值：608800
         * </pre>
         */
        @ApiModelProperty("订单原价")
        private Integer costPrice;
        /**
         * <pre>
         * 字段名：商品小票ID
         * 变量名：invoice_id
         * 是否必填：否
         * 类型：string（32）
         * 描述：
         *  商品小票ID
         *  示例值：微信123
         * </pre>
         */
        @ApiModelProperty("商品小票ID")
        private String invoiceId;
        /**
         * <pre>
         * 字段名：单品列表
         * 变量名：goods_detail
         * 是否必填：否
         * 类型：array
         * 描述：
         *  单品列表信息
         *  条目个数限制：【1，undefined】
         * </pre>
         */
        @ApiModelProperty("单品列表")
        private List<GoodsDetail> goodsDetails;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Amount implements Serializable {
        private static final long serialVersionUID = -4967636398225864273L;

        /**
         * <pre>
         * 字段名：总金额
         * 变量名：total
         * 是否必填：是
         * 类型：int64
         * 描述：
         *  订单总金额，单位为分。
         *  示例值：100
         * </pre>
         */
        @ApiModelProperty("总金额")
        private Integer total;
        /**
         * <pre>
         * 字段名：币类型
         * 变量名：currency
         * 是否必填：否
         * 类型：string(16)
         * 描述：
         *  CNY：人民币，境内商户号仅支持人民币。
         *  示例值：CNY
         * </pre>
         */
        @ApiModelProperty("币类型")
        private String currency;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payer implements Serializable {
        private static final long serialVersionUID = -3946401119476159971L;

        /**
         * <pre>
         * 字段名：用户服务标识
         * 变量名：sp_openid
         * 是否必填：是
         * 类型：string(128)
         * 描述：
         *  用户在服务商appid下的唯一标识。
         *  示例值：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
         * </pre>
         */
        @ApiModelProperty("用户服务标识")
        private String spOpenid;
        /**
         * <pre>
         * 字段名：用户子标识
         * 变量名：sub_openid
         * 是否必填：否
         * 类型：string(128)
         * 描述：
         *  用户在子商户appid下的唯一标识。
         *  示例值：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
         * </pre>
         */
        @ApiModelProperty("用户子标识")
        private String subOpenid;
    }

    @Data
    @NoArgsConstructor
    public static class SettleInfo implements Serializable {
        private static final long serialVersionUID = 4438958789491671746L;

        /**
         * <pre>
         * 字段名：是否指定分账
         * 变量名：profit_sharing
         * 是否必填：否
         * 类型：bool
         * 描述：
         *  是否分账，与外层profit_sharing同时存在时，以本字段为准。
         *  true：是
         *  false：否
         *  示例值：true
         * </pre>
         */
        @ApiModelProperty("是否指定分账")
        private Boolean profitSharing;
        /**
         * <pre>
         * 字段名：补差金额
         * 变量名：subsidy_amount
         * 是否必填：否
         * 类型：int64
         * 描述：
         *  SettleInfo.profit_sharing为true时，该金额才生效。
         *    注意：单笔订单最高补差金额为5000元
         *  示例值：10
         * </pre>
         */
        @ApiModelProperty("补差金额")
        private BigDecimal subsidyAmount;
    }

    @Data
    @NoArgsConstructor
    public static class GoodsDetail implements Serializable {
        private static final long serialVersionUID = -2574001236925022932L;

        /**
         * <pre>
         * 字段名：商户侧商品编码
         * 变量名：merchant_goods_id
         * 是否必填：是
         * 类型：string(32)
         * 描述：
         *  由半角的大小写字母、数字、中划线、下划线中的一种或几种组成。
         * 示例值：商品编码
         * </pre>
         */
        @ApiModelProperty("商户侧商品编码")
        private String merchantGoodsId;
        /**
         * <pre>
         * 字段名：微信侧商品编码
         * 变量名：wechatpay_goods_id
         * 是否必填：否
         * 类型：string(32)
         * 描述：
         *  微信支付定义的统一商品编号（没有可不传）
         * 示例值：1001
         * </pre>
         */
        @ApiModelProperty("微信侧商品编码")
        private String wechatpayGoodsId;
        /**
         * <pre>
         * 字段名：商品名称
         * 变量名：goods_name
         * 是否必填：否
         * 类型：string(256)
         * 描述：
         *  商品的实际名称
         * 示例值：iPhoneX 256G
         * </pre>
         */
        @ApiModelProperty("商品名称")
        private String goodsName;
        /**
         * <pre>
         * 字段名：商品数量
         * 变量名：quantity
         * 是否必填：是
         * 类型：int64
         * 描述：
         *  用户购买的数量
         * 示例值：1
         * </pre>
         */
        @ApiModelProperty("商品数量")
        private Integer quantity;
        /**
         * <pre>
         * 字段名：商品单价
         * 变量名：unit_price
         * 是否必填：是
         * 类型：int64
         * 描述：
         *  商品单价，单位为分
         * 示例值：828800
         * </pre>
         */
        @ApiModelProperty("商品单价")
        private Integer unitPrice;
    }

    @Data
    @NoArgsConstructor
    public static class SceneInfo implements Serializable {
        private static final long serialVersionUID = 4678263124015070957L;

        /**
         * <pre>
         * 字段名：商户端设备号
         * 变量名：device_id
         * 是否必填：否
         * 类型：string(16)
         * 描述：
         *  终端设备号（门店号或收银设备ID）。
         *  特殊规则：长度最小7个字节
         *  示例值：POS1:1
         * </pre>
         */
        @ApiModelProperty("商户端设备号")
        private String deviceId;
        /**
         * <pre>
         * 字段名：用户终端IP
         * 变量名：payer_client_ip
         * 是否必填：是
         * 类型：string(45)
         * 描述：
         *  用户端实际ip
         *  格式: ip(ipv4+ipv6)
         *  示例值：14.17.22.32
         * </pre>
         */
        @ApiModelProperty("用户终端IP")
        private String payerClientIp;
        /**
         * <pre>
         * 字段名：H5场景信息
         * 变量名：h5_info
         * 是否必填：否(H5支付必填)
         * 类型：object
         * 描述：
         *  H5场景信息
         * </pre>
         */
        @ApiModelProperty("H5场景信息")
        private H5Info h5Info;
        /**
         * <pre>
         * 字段名：商户门店信息
         * 变量名：store_info
         * 是否必填：否(H5支付必填)
         * 类型：object
         * 描述：
         *  商户门店信息
         * </pre>
         */
        @ApiModelProperty("商户门店信息")
        private StoreInfo storeInfo;
    }

    @Data
    @NoArgsConstructor
    public static class H5Info implements Serializable {
        private static final long serialVersionUID = -6865738707329486532L;

        /**
         * <pre>
         * 字段名：场景类型
         * 变量名：type
         * 是否必填：是
         * 类型：string(32)
         * 描述：
         *  场景类型，枚举值：
         *  iOS：IOS移动应用；
         *  Android：安卓移动应用；
         *  Wap：WAP网站应用；
         *  示例值：iOS
         * </pre>
         */
        @ApiModelProperty("场景类型")
        private String type;
        /**
         * <pre>
         * 字段名：应用名称
         * 变量名：app_name
         * 是否必填：否
         * 类型：string(64)
         * 描述：
         *  应用名称
         *  示例值：王者荣耀
         * </pre>
         */
        @ApiModelProperty("应用名称")
        private String appName;
        /**
         * <pre>
         * 字段名：网站URL
         * 变量名：app_url
         * 是否必填：否
         * 类型：string(128)
         * 描述：
         *  网站URL
         *  示例值：https://pay.qq.com
         * </pre>
         */
        @ApiModelProperty("网站URL")
        private String appUrl;
        /**
         * <pre>
         * 字段名：iOS平台BundleID
         * 变量名：bundle_id
         * 是否必填：否
         * 类型：string(128)
         * 描述：
         *  iOS平台BundleID
         *  示例值：com.tencent.wzryiOS
         * </pre>
         */
        @ApiModelProperty("iOS平台BundleID")
        private String bundleId;
        /**
         * <pre>
         * 字段名：Android平台PackageName
         * 变量名：package_name
         * 是否必填：否
         * 类型：string(128)
         * 描述：
         *  Android平台PackageName
         *  示例值：com.tencent.tmgp.sgame
         * </pre>
         */
        @ApiModelProperty("Android平台PackageName")
        private String packageName;
    }

    @Data
    @NoArgsConstructor
    public static class StoreInfo implements Serializable {
        private static final long serialVersionUID = -8002411737407580701L;

        /**
         * <pre>
         * 字段名：门店编号
         * 变量名：id
         * 是否必填：否
         * 类型：string(32)
         * 描述：
         *  商户侧门店编号
         * 示例值：0001
         * </pre>
         */
        @ApiModelProperty("门店编号")
        private String id;
        /**
         * <pre>
         * 字段名：门店名称
         * 变量名：name
         * 是否必填：是
         * 类型：string(256)
         * 描述：
         *  商户侧门店名称
         * 示例值：腾讯大厦分店
         * </pre>
         */
        @ApiModelProperty("门店名称")
        private String name;
        /**
         * <pre>
         * 字段名：地区编码
         * 变量名：area_code
         * 是否必填：是
         * 类型：string(32)
         * 描述：
         *  地区编码，详细请见省市区编号对照表(https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/ecommerce/applyments/chapter4_1.shtml)。
         * 示例值：440305
         * </pre>
         */
        @ApiModelProperty("地区编码")
        private String areaCode;
        /**
         * <pre>
         * 字段名：详细地址
         * 变量名：address
         * 是否必填：是
         * 类型：string(512)
         * 描述：
         *  详细的商户门店地址
         * 示例值：广东省深圳市南山区科技中一道10000号
         * </pre>
         */
        @ApiModelProperty("详细地址")
        private String address;
    }


}

