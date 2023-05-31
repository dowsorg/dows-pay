package org.dows.sdk.weixin.pay.基础支付.H5支付;

/**
 * @description 
 * @author lait.zhang@gmail.com
 * @date  2023年5月31日 上午11:18:23
 */
public interface H5支付Api{

    /**
     * description: 发起商家转账API
最新更新时间：2022.04.24

商户可以通过该接口同时向多个用户微信零钱进行转账操作。










     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_1.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/transfer/batches

     * 
     * @param h5下单Request
     * 
     */
    H5下单Response h5下单(H5下单Request h5下单Request);

    /**
     * description: 微信批次单号查询批次单API
最新更新时间：2022.4.6

商户可以通过该接口查询转账批次单以及指定状态的转账明细单。







     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_2.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/transfer/batches/batch-id/{batch_id}

     * 
     * @param 查询订单Request
     * 
     */
    查询订单Response 查询订单(查询订单Request 查询订单Request);

    /**
     * description: 微信明细单号查询明细单API
最新更新时间：2022.08.09

商户可以通过该接口查询单笔转账明细单。






     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_3.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/transfer/batches/batch-id/{batch_id}/details/detail-id/{detail_id}

     * 
     * @param 关闭订单Request
     * 
     */
    关闭订单Response 关闭订单(关闭订单Request 关闭订单Request);

    /**
     * description: H5调起支付API
最新更新时间：2020.05.26

商户后台系统先调用微信支付的
接口，微信后台系统返回链接参数h5_url，用户使用微信外部的浏览器访问该h5_url地址调起微信支付中间页

     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_4.shtml
     * api: 
     * 
     * @param h5调起支付Request
     * 
     */
    H5调起支付Response h5调起支付(H5调起支付Request h5调起支付Request);

    /**
     * description: 商家批次单号查询批次单API
最新更新时间：2022.4.6

商户可以通过该接口查询转账批次单以及指定状态的转账明细单。







     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_5.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/transfer/batches/out-batch-no/{out_batch_no}

     * 
     * @param 支付通知Request
     * 
     */
    支付通知Response 支付通知(支付通知Request 支付通知Request);

    /**
     * description: 转账明细电子回单受理API
最新更新时间：2021.10.26

受理转账明细电子回单接口，商户通过该接口可以申请受理转账明细单电子回单服务。






     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_9.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/transfer-detail/electronic-receipts

     * 
     * @param 申请退款Request
     * 
     */
    申请退款Response 申请退款(申请退款Request 申请退款Request);

    /**
     * description: 查询转账明细电子回单受理结果API
最新更新时间：2021.10.26

查询转账明细电子回单受理结果接口，商户通过该接口可以查询电子回单受理进度信息，包括电子回单据信息，电子回单文件的hash值，电子回单文件的下载地址等。

     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_10.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/transfer-detail/electronic-receipts

     * 
     * @param 查询单笔退款Request
     * 
     */
    查询单笔退款Response 查询单笔退款(查询单笔退款Request 查询单笔退款Request);

    /**
     * description: 下载电子回单API
最新更新时间：2021.10.26

下载电子回单API为通用接口，商家转账等业务电子回单均可通过该接口进行下载。







     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_11.shtml
     * api: 
通过申请账单接口获取到“download_url”，URL有效期10min

     * 
     * @param 退款结果通知Request
     * 
     */
    退款结果通知Response 退款结果通知(退款结果通知Request 退款结果通知Request);

    /**
     * description: 商家明细单号查询明细单API
最新更新时间：2022.08.09

商户可以通过该接口查询单笔转账明细单。






     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_6.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/transfer/batches/out-batch-no/{out_batch_no}/details/out-detail-no/{out_detail_no}

     * 
     * @param 申请交易账单Request
     * 
     */
    申请交易账单Response 申请交易账单(申请交易账单Request 申请交易账单Request);

    /**
     * description: 转账电子回单申请受理API
最新更新时间：2021.10.26

转账电子回单申请受理接口，商户通过该接口可以申请受理电子回单服务。






     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_7.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/transfer/bill-receipt

     * 
     * @param 申请资金账单Request
     * 
     */
    申请资金账单Response 申请资金账单(申请资金账单Request 申请资金账单Request);

    /**
     * description: 
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_12.shtml
     * api: 
     * 
     * @param 申请单个子商户资金账单Request
     * 
     */
    申请单个子商户资金账单Response 申请单个子商户资金账单(申请单个子商户资金账单Request 申请单个子商户资金账单Request);

    /**
     * description: 查询转账电子回单API
最新更新时间：2021.10.26

查询转账电子回单接口，商户通过该接口可以查询电子回单受理进度信息，包括电子回单据信息，电子回单文件的hash值，电子回单文件的下载地址等




     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_8.shtml
     * api: 
https://api.mch.weixin.qq.com/v3/transfer/bill-receipt/{out_batch_no}

     * 
     * @param 下载账单Request
     * 
     */
    下载账单Response 下载账单(下载账单Request 下载账单Request);
}