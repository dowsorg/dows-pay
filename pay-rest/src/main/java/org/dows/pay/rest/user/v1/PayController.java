package org.dows.pay.rest.user.v1;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dows.framework.api.Response;
import org.dows.pay.alipay.BizDispatcher;
import org.dows.pay.alipay.constants.AlipayServiceEnvConstants;
import org.dows.pay.alipay.executor.ActionExecutor;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.request.PayIsvRequest;
import org.dows.pay.gateway.PayDispatcher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Api(tags = "支付接口")
@RestController
@RequestMapping(value = "/v1")
@Slf4j
@RequiredArgsConstructor
public class PayController {


    private final PayDispatcher payDispatcher;

    /**
     * http://3ujk4u.natappfree.cc/
     */
    @PostMapping
    @ApiOperation(value = "支付网关")
    public void gateway(HttpServletRequest request, HttpServletResponse response) {
        //支付宝响应消息
        String responseMsg = "";

        //1. 解析请求参数
        Map<String, String> params = getRequestParams(request);

        //打印本次请求日志，开发者自行决定是否需要
        log.info("支付宝请求串:{}", params);

        try {
            //2. 验证签名
            //this.verifySign(params);

            //3. 获取业务执行器   根据请求中的 service, msgType, eventType, actionParam 确定执行器
            ActionExecutor executor = BizDispatcher.getExecutor(params);

            //4. 执行业务逻辑
            responseMsg = executor.execute();

        } /*catch (AlipayApiException alipayApiException) {
            //开发者可以根据异常自行进行处理
            alipayApiException.printStackTrace();

        } */catch (Exception exception) {
            //开发者可以根据异常自行进行处理
            exception.printStackTrace();

        } finally {
            //5. 响应结果加签及返回
            try {

                //对响应内容加签
                responseMsg = encryptAndSign(responseMsg,
                        AlipayServiceEnvConstants.ALIPAY_PUBLIC_KEY,
                        AlipayServiceEnvConstants.PRIVATE_KEY, AlipayServiceEnvConstants.CHARSET,
                        false, true, AlipayServiceEnvConstants.SIGN_TYPE);

                //http 内容应答
                response.reset();
                response.setContentType("text/xml;charset=GBK");
                PrintWriter printWriter = response.getWriter();
                printWriter.print(responseMsg);
                response.flushBuffer();

                //开发者自行决定是否要记录，视自己需求
                log.info("开发者响应串:{}", responseMsg);
            } catch (AlipayApiException alipayApiException) {
                //开发者可以根据异常自行进行处理
                alipayApiException.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @PostMapping("/test")
    @ApiOperation(value = "支付路由")
    public Response<PayResponse> dispatcher(@RequestBody PayIsvRequest payRequest) {
        return payDispatcher.dispatcher(payRequest);
    }


    /**
     * 获取所有request请求参数key-value
     *
     * @param request
     * @return
     */
    public static Map<String, String> getRequestParams(HttpServletRequest request) {

        Map<String, String> params = new HashMap<String, String>();
        if (null != request) {
            Set<String> paramsKey = request.getParameterMap().keySet();
            for (String key : paramsKey) {
                params.put(key, request.getParameter(key));
            }
        }
        return params;
    }


    /**
     * 验签
     *
     * @return
     */
    private void verifySign(Map<String, String> params) throws AlipayApiException {

        if (!AlipaySignature.rsaCheckV2(params, AlipayServiceEnvConstants.ALIPAY_PUBLIC_KEY,
                AlipayServiceEnvConstants.SIGN_CHARSET, AlipayServiceEnvConstants.SIGN_TYPE)) {
            throw new AlipayApiException("verify sign fail.");
        }
    }


    public static String encryptAndSign(String bizContent, String alipayPublicKey, String cusPrivateKey, String charset,
                                        boolean isEncrypt, boolean isSign, String signType) throws AlipayApiException {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isEmpty(charset)) {
            charset = AlipayConstants.CHARSET_GBK;
        }
        sb.append("<?xml version=\"1.0\" encoding=\"" + charset + "\"?>");
        if (isEncrypt) {// 加密
            sb.append("<alipay>");
            String encrypted = AlipaySignature.rsaEncrypt(bizContent, alipayPublicKey, charset);
            sb.append("<response>" + encrypted + "</response>");
            sb.append("<encryption_type>AES</encryption_type>");
            if (isSign) {
                String sign = AlipaySignature.rsaSign(encrypted, cusPrivateKey, charset, signType);
                sb.append("<sign>" + sign + "</sign>");
                sb.append("<sign_type>");
                sb.append(signType);
                sb.append("</sign_type>");
            }
            sb.append("</alipay>");
        } else if (isSign) {// 不加密，但需要签名
            sb.append("<alipay>");
            sb.append("<response>" + bizContent + "</response>");
            sb.append("<app_cert_sn>92993f2227e9282e8e00b35e126b2828</app_cert_sn>");
            String sign = AlipaySignature.rsaSign(bizContent, cusPrivateKey, charset, signType);
            sb.append("<sign>" + sign + "</sign>");
            sb.append("<sign_type>");
            sb.append(signType);
            sb.append("</sign_type>");
            sb.append("</alipay>");
        } else {// 不加密，不加签
            sb.append(bizContent);
        }
        return sb.toString();
    }

}
