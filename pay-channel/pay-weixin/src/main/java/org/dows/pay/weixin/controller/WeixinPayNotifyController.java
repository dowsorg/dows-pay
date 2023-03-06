/**
 * @ProjectName:zhyt_contract
 * @PackageName:com.zhyt.contract.controller
 * @Description: 地址管理业务请求分发
 *
 * @author gaozh
 * @Date: 2022年11月10日
 *
 * @Company: crudoil
 * @Copyright: Copyright (c) 2021-2050
 */
package org.dows.pay.weixin.controller;


import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.bean.ecommerce.PartnerTransactionsNotifyResult;
import com.github.binarywang.wxpay.bean.ecommerce.RefundNotifyResult;
import com.github.binarywang.wxpay.bean.ecommerce.SignatureHeader;
import com.github.binarywang.wxpay.bean.profitsharingV3.ProfitSharingNotifyData;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.EcommerceService;
import com.github.binarywang.wxpay.service.WxPayService;
import com.sun.deploy.net.HttpUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.bean.message.WxOpenXmlMessage;
import org.dows.pay.api.util.HttpRequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: WeixinPayNotifyController
 * @Description: 微信支付回调
 *
 * @Date 2022年11月10日
 * @author tqhuang
 */
@RestController
@RequestMapping("notify")
public class WeixinPayNotifyController
{

    @Resource
    private EcommerceService ecommerceService;
    @Resource
    private WxPayService wxPayService;
    @Resource
    private WxOpenService wxOpenService;

    /**
     * 微信支付回调
     *
     * @author tqhuang
     * @Date 2022年11月10日
     */

    @PostMapping("/payNotify")
    public PartnerTransactionsNotifyResult wxPayNotify(HttpServletRequest request, HttpServletResponse response)
    {
        String notifyData = HttpRequestUtils.getRequestParam(request).toString();
        String requestHeader = request.getHeader("WECHAT_PAY_SIGNATURE");
        SignatureHeader header = JSONObject.parseObject(requestHeader,SignatureHeader.class);

        PartnerTransactionsNotifyResult partnerTransactionsNotifyResult = null;
        try{
             partnerTransactionsNotifyResult = ecommerceService.parsePartnerNotifyResult(notifyData,header);
        }catch (WxPayException e) {
            e.printStackTrace();
        }
        return partnerTransactionsNotifyResult;
    }

    /**
     * 微信退款回调
     *
     * @author tqhuang
     * @Date 2022年11月10日
     */

    @PostMapping("/refundNotify")
    public RefundNotifyResult wxPayRefundNotify(HttpServletRequest request, HttpServletResponse response)
    {
        String notifyData = HttpRequestUtils.getRequestParam(request).toString();
        String requestHeader = request.getHeader("WECHAT_PAY_SIGNATURE");
        SignatureHeader header = JSONObject.parseObject(requestHeader,SignatureHeader.class);


        RefundNotifyResult refundNotifyResult = null;
        try{
            refundNotifyResult = ecommerceService.parseRefundNotifyResult(notifyData,header);
        }catch (WxPayException e) {
            e.printStackTrace();
        }
        return refundNotifyResult;
    }

    /**
     * 微信分账动账通知
     *
     * @author tqhuang
     * @Date 2022年11月10日
     */

    @PostMapping("/profitSharingNotify")
    public ProfitSharingNotifyData wxPaySharingNotify(String notifyData, SignatureHeader header)
    {
        ProfitSharingNotifyData profitSharingNotifyData = null;
        try{
            profitSharingNotifyData = wxPayService.getProfitSharingV3Service().getProfitSharingNotifyData(notifyData,header);
        }catch (WxPayException e) {
            e.printStackTrace();
        }
        return profitSharingNotifyData;
    }

    /**
     * 服务商代商户申请小程序通知（授权事件接收）
     * @author tqhuang
     * @Date 2022年11月10日
     */

    @PostMapping("/authNotify")
    public String wxAuthNotify(@RequestBody WxOpenXmlMessage wxMessage)
    {
        String route = "";
        try {
             route = wxOpenService.getWxOpenComponentService().route(wxMessage);
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return route;
    }
}
