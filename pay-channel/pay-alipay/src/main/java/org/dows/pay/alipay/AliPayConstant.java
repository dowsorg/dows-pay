package org.dows.pay.alipay;


import org.dows.pay.api.util.JvmOSUtil;

public interface AliPayConstant {


     String DIST = JvmOSUtil.projectDir() + "/crt/";


    final class AppDev{

        public static final String APP_ID = "";

        public static final String PRIVATE_KEY = "";
        /**
         * 支付宝公钥  应该使用支付宝公钥，不是应用公钥
         */
        public static final String PUBLIC_KEY = "";

        public static final String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";

        public static final String APP_CERT_PATH = DIST + "dev/appCertPublicKey.crt";

        public static final String ALIPAY_CERT_PATH = DIST + "dev/alipayCertPublicKey_RSA2.crt";

        public static final String ALIPAY_ROOT_CERT_PATH = DIST + "dev/alipayRootCert.crt";


    }



}
