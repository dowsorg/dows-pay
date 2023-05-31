package org.dows.pay.spider.extract;

public enum WeixinApiBeanInfoEnum {

    // 基础支付
    JSAPI支付("", "pay", "JsPay", "JSAPI支付", "https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_1.shtml,https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_2.shtml,......"),
    App支付("", "pay", "AppPay", "App支付", "https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_2_1.shtml,https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_2_2.shtml,......"),
    H5支付("", "pay", "H5Pay", "H5支付", ""),
    Native支付("", "pay", "NativePay", "Native支付", ""),
    小程序支付("", "pay", "MpPay", "小程序支付", ""),
    合单支付("", "pay", "MergePay", "合单支付", ""),
    付款码付款("", "pay", "CodePay", "付款码付款", ""),


    // 经营能力
    退款结果通知("", "business", "PayScoreCommon", "微信支付分（公共API）", ""),
    申请交易账单("", "business", "PayScoreNoPermissions", "微信支付分（免确认预授权模式）", ""),
    申请资金账单("", "business", "PayScorePermissions", "微信支付分（需确认模式）", ""),
    下载账单("", "business", "SmartGuide", "支付即服务 ", ""),


    // 行业方案
    智慧商圈("", "solution", "BusinessCircle", "智慧商圈", ""),
    微信支付分停车服务("", "solution", "Vehicle", "微信支付分停车服务", ""),
    电子发票("", "solution", "Invoice", "电子发票", ""),


    //营销工具
    代金券("", "marketing", "Favor", "代金券", ""),
    商家券("", "marketing", "Busifavor", "商家券", ""),
    委托营销("", "marketing", "Partnerships", "委托营销", ""),
    支付有礼("", "marketing", "PayGiftActivity", "支付有礼", ""),
    小程序发券插件("", "marketing", "MpIssueCoupons", "小程序发券插件", ""),
    H5发券("", "marketing", "H5IssueCoupons", "H5发券", ""),
    图片上传("", "marketing", "ImgUpload", "图片上传(营销专用)", ""),
    现金红包("", "marketing", "RedPack", "现金红包", ""),


    //资金应用
    商家转账到零钱("", "capital", "MerchantTransfer", "商家转账到零钱", ""),
    分账("", "capital", "ProfitSharing", "分账", ""),


    // 其他能力


    ;

    private String module;

    private String pkg;

    private String beanName;

    private String descr;

    private String docUrls;

    WeixinApiBeanInfoEnum(String module, String pkg, String beanName, String descr, String docUrls) {
        this.module = module;
        this.pkg = pkg;
        this.beanName = beanName;
        this.descr = descr;
        this.docUrls = docUrls;
    }
}
