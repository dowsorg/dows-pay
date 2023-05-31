package org.dows.sdk.weixin.pay.基础支付.合单支付;

/**
 * @description 
 * @author lait.zhang@gmail.com
 * @date  2023年5月31日 上午11:18:23
 */
public interface 合单支付Api{

    /**
     * description: 合单APP下单API
最新更新时间：2022.05.31

使用合单支付接口，用户只输入一次密码，即可完成多个订单的支付。目前最少一次可支持2笔，最多一次10笔订单进行合单支付。

     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_1.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/combine-transactions/app

     * 
     * @param 合单APP下单Request
     * 
     */
    合单APP下单Response 合单APP下单(合单APP下单Request 合单APP下单Request);

    /**
     * description: 合单H5下单API
最新更新时间：2022.05.31

使用合单支付接口，用户只输入一次密码，即可完成多个订单的支付。目前最少一次可支持2笔，最多一次10笔订单进行合单支付。

     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_2.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/combine-transactions/h5

     * 
     * @param 合单H5下单Request
     * 
     */
    合单H5下单Response 合单H5下单(合单H5下单Request 合单H5下单Request);

    /**
     * description: 合单JSAPI下单API
最新更新时间：2022.05.31

使用合单支付接口，用户只输入一次密码，即可完成多个订单的支付。目前最少一次可支持2笔，最多一次10笔订单进行合单支付。

     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_3.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/combine-transactions/jsapi

     * 
     * @param 合单JSAPI下单Request
     * 
     */
    合单JSAPI下单Response 合单JSAPI下单(合单JSAPI下单Request 合单JSAPI下单Request);

    /**
     * description: 合单小程序下单API
最新更新时间：2022.05.31

使用合单支付接口，用户只输入一次密码，即可完成多个订单的支付。目前最少一次可支持2笔，最多一次10笔订单进行合单支付。

     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_4.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/combine-transactions/jsapi

     * 
     * @param 合单小程序下单Request
     * 
     */
    合单小程序下单Response 合单小程序下单(合单小程序下单Request 合单小程序下单Request);

    /**
     * description: 合单Native下单API
最新更新时间：2022.05.31

使用合单支付接口，用户只输入一次密码，即可完成多个订单的支付。目前最少一次可支持2笔，最多一次10笔订单进行合单支付。

     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_5.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/combine-transactions/native

     * 
     * @param 合单Native下单Request
     * 
     */
    合单Native下单Response 合单Native下单(合单Native下单Request 合单Native下单Request);

    /**
     * description: APP调起支付API
最新更新时间：2020.09.29

通过APP下单接口获取到发起支付的必要参数prepay_id，可以按照接口定义中的规则，使用微信支付提供的SDK调起小程序支付。

     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_6.shtml
     * api: 
     * 
     * @param aPP调起支付Request
     * 
     */
    APP调起支付Response aPP调起支付(APP调起支付Request aPP调起支付Request);

    /**
     * description: H5调起支付API
最新更新时间：2020.05.26

商户后台系统先调用微信支付的
接口，微信后台系统返回链接参数h5_url，用户使用微信外部的浏览器访问该h5_url地址调起微信支付中间页

     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_7.shtml
     * api: 
     * 
     * @param h5调起支付Request
     * 
     */
    H5调起支付Response h5调起支付(H5调起支付Request h5调起支付Request);

    /**
     * description: JSAPI调起支付API
最新更新时间：2023.05.18

通过JSAPI下单接口获取到发起支付的必要参数prepay_id，然后使用微信支付提供的前端JS方法调起公众号支付。






     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_8.shtml
     * api: 
     * 
     * @param jSAPI调起支付Request
     * 
     */
    JSAPI调起支付Response jSAPI调起支付(JSAPI调起支付Request jSAPI调起支付Request);

    /**
     * description: 小程序调起支付API
最新更新时间：2020.05.26

通过JSAPI下单接口获取到发起支付的必要参数prepay_id，然后使用微信支付提供的小程序方法调起小程序支付。

     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_9.shtml
     * api: 
     * 
     * @param 小程序调起支付Request
     * 
     */
    小程序调起支付Response 小程序调起支付(小程序调起支付Request 小程序调起支付Request);

    /**
     * description: Native调起支付API
最新更新时间：2020.04.29

商户后台系统先调用微信支付的
接口，微信后台系统返回链接参数code_url，商户后台系统将code_url值生成二维码图片，用户使用微信客户端扫码后发起支付。




     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_10.shtml
     * api: 
     * 
     * @param native调起支付Request
     * 
     */
    Native调起支付Response native调起支付(Native调起支付Request native调起支付Request);

    /**
     * description: 合单查询订单API
最新更新时间：2021.04.21

商户通过合单查询订单API查询订单状态，完成下一步的业务逻辑。




     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_11.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/combine-transactions/out-trade-no/{combine_out_trade_no}

     * 
     * @param 合单查询订单Request
     * 
     */
    合单查询订单Response 合单查询订单(合单查询订单Request 合单查询订单Request);

    /**
     * description: 合单关闭订单API
最新更新时间：2022.05.18

合单支付订单只能使用此合单关单api完成关单。




     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_12.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/combine-transactions/out-trade-no/{combine_out_trade_no}/close

     * 
     * @param 合单关闭订单Request
     * 
     */
    合单关闭订单Response 合单关闭订单(合单关闭订单Request 合单关闭订单Request);

    /**
     * description: 支付通知API
最新更新时间：2019.09.10

微信支付通过支付通知接口将用户支付成功消息通知给商户







     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_13.shtml
     * api: 通知url必须为直接可访问的url，不能携带参数。示例： “https://pay.weixin.qq.com/wxpay/pay.action”

     * 
     * @param 支付通知Request
     * 
     */
    支付通知Response 支付通知(支付通知Request 支付通知Request);

    /**
     * description: 申请退款API
最新更新时间：2022.08.29

当交易发生之后一年内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付金额退还给买家，微信支付将在收到退款请求并且验证成功之后，将支付款按原路退还至买家账号上。












退款状态转变如下：



     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_14.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/refund/domestic/refunds

     * 
     * @param 申请退款Request
     * 
     */
    申请退款Response 申请退款(申请退款Request 申请退款Request);

    /**
     * description: 查询单笔退款API
最新更新时间：2022.08.29

提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，建议在提交退款申请后1分钟发起查询退款状态，一般来说零钱支付的退款5分钟内到账，银行卡支付的退款1-3个工作日到账。

     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_15.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/refund/domestic/refunds/{out_refund_no}

     * 
     * @param 查询单笔退款Request
     * 
     */
    查询单笔退款Response 查询单笔退款(查询单笔退款Request 查询单笔退款Request);

    /**
     * description: 退款结果通知API
最新更新时间：2021.01.15

退款状态改变后，微信会把相关退款结果发送给商户。









     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_16.shtml
     * api: 通知url必须为直接可访问的url，不能携带参数。示例：“https://pay.weixin.qq.com/wxpay/pay.action”

     * 
     * @param 退款结果通知Request
     * 
     */
    退款结果通知Response 退款结果通知(退款结果通知Request 退款结果通知Request);

    /**
     * description: 申请交易账单API
最新更新时间：2021.12.10

微信支付按天提供交易账单文件，商户可以通过该接口获取账单文件的下载地址。文件内包含交易相关的金额、时间、营销等信息，供商户核对订单、退款、银行到账等情况。






     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_17.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/bill/tradebill

     * 
     * @param 申请交易账单Request
     * 
     */
    申请交易账单Response 申请交易账单(申请交易账单Request 申请交易账单Request);

    /**
     * description: 申请资金账单API
最新更新时间：2021.12.10

微信支付按天提供微信支付账户的资金流水账单文件，商户可以通过该接口获取账单文件的下载地址。文件内包含该账户资金操作相关的业务单号、收支金额、记账时间等信息，供商户进行核对。





     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_18.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/bill/fundflowbill

     * 
     * @param 申请资金账单Request
     * 
     */
    申请资金账单Response 申请资金账单(申请资金账单Request 申请资金账单Request);

    /**
     * description: 
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_20.shtml
     * api: 
     * 
     * @param 申请单个子商户资金账单Request
     * 
     */
    申请单个子商户资金账单Response 申请单个子商户资金账单(申请单个子商户资金账单Request 申请单个子商户资金账单Request);

    /**
     * description: 下载账单API
最新更新时间：2021.12.10

下载账单API为通用接口，交易/资金账单都可以通过该接口获取到对应的账单。







     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_19.shtml
     * api: 
通过申请账单接口获取到“download_url”，URL有效期30s

     * 
     * @param 下载账单Request
     * 
     */
    下载账单Response 下载账单(下载账单Request 下载账单Request);

    /**
     * description: 
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/index.shtml#menu00
     * api: 
     * 
     * @param 付款码支付Request
     * 
     */
    付款码支付Response 付款码支付(付款码支付Request 付款码支付Request);
}