package org.dows.pay.alipay.constants;


/**
 * 支付宝服务窗环境常量（demo中常量只是参考，需要修改成自己的常量值）
 */
public class AlipayServiceEnvConstants {

    /**
     * 支付宝公钥-从支付宝生活号详情页面获取
     */
    public static final String ALIPAY_PUBLIC_KEY = "";

    /**
     * 签名编码-视支付宝服务窗要求
     */
    public static final String SIGN_CHARSET = "GBK";

    /**
     * 字符编码-传递给支付宝的数据编码
     */
    public static final String CHARSET = "GBK";

    /**
     * 签名类型-视支付宝服务窗要求
     */
    public static final String SIGN_TYPE = "RSA2";

    /**
     * 开发者账号PID
     */
    public static final String PARTNER = "";

    /**
     * 服务窗appId
     */
    //TODO !!!! 注：该appId必须设为开发者自己的生活号id  
    public static final String APP_ID = "";

    //TODO !!!! 注：该私钥为测试账号私钥  开发者必须设置自己的私钥 , 否则会存在安全隐患 
    public static final String PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCIMtRtArevU4WGinHSDGY0XEXmtMyWYuUcAE6lWFuJMpJIkDjBvaz1Y6U86p/5DQzd1Hc8rn6qB7ljMLiCQFJkeM8VlzM9kwQ8ATRNkbP8Zbw/bpTCjKNk/I6cHKy5GM36JEV5JJaiislrnU6c8EhWlQwbq2UZGSGoC8T2QF3XP4wISVE/jyKYWSmhdwe3NRClPbM0sDpEyTKy1TBulMUgXOSDmbINkYD+q4bd9Gx3PfbUJuDA9CdQUkofjj4R7+7qVCXY01gGcpOC8q8pE7yXVJgsvk9T8Yb1II58tZWGXP72wSZdADl0o5vyXA5YDSY2JJxpb4Tu1T5glTFFDuJpAgMBAAECggEAVj65vX3nCyL8fsHUaYpofeegbAM5OlHNevnG03UsIajgcQrCpgySJaG/1N9OBct5xk7wYoCsvMa/YkxLyk8o3W6S0703OVqLZ+PrVuNY8g8KMbC4iqm8Hgq/06NkzKEkba3iQGAm8y6ndXnbeg2+APXJAQx7rHT5lww84SLJSa+KEUK5J06HIyRsk9mX/WpweGtAzgcGNJsOES6NufIuACYCjIhBRxeWJJCXkevojc8+jUVwgxhsfUXgTZGgxomJQSfaU4/Pmu2D2l7Un2KgHUCnb3En8Wfo8qTLPV3yKSYoYa7hSBmGwSL20F/AOSNEy5QzMKPgRsN7wMdIIHj3MQKBgQDPk4L3V4Yn7zJ8zjvBaiG+ZERdT7mMco1YWCZEaEkVDpXQl16izw2QLSEGNfdF/sC330zGUXRPLIIuE8XRyWElYJjYVJpu0DdttJUdlShwsjuWiVRb7ng7IKvG1KZtKg9nkrkzIdA8YW9VTWZv+tUt3sNbxxAllQIGY/aSsoiQvwKBgQCn+KGrcZk2XPuk5yFw8e/T0+OKS6kmT2BH7uAt7Xk2geyRFPOKheTa9K+DhxN3Mhf0PQA29MlNrgBWwCSeLLXfjlB27JuXGitDwwxFkOnX/6SWQOJXqJcDw5e1KWvdCMb7QA9VkPB7o8mO5V6IIHKvFtlzVelSs36Rpy1VEWUu1wKBgEIVNByKQKt1+xzAi0WIBDYYtar/NpL/5P+7EHO2v410lz1Q80/hmu/LbjgL9izSbYgcDtUUGXMbOFZy9QdUlRjRJ9e3F3Mv1nWWh+JjGfzGwTGrhq+9u4kXXZhvGoymV0Eh9NPSb/jJDCib+4Cq2jNAN/F/7iQIzBw8tsL9E30BAoGALpe+KLNbH4RNXWGrmgvSTbzx2hPAuNq9x1ZQowzDWcZSW7AnGh6n68CBywc19BNWJ66gF55xFHYWq/mibqnSTU/JrCNXyWM96w74oXdgFkVYX0FiR5SBR08DDwKNZAOiRmFvn3mT64f0Sgn/3dy6Uy0QZnjHPuSBUF/CKF2p5oMCgYA01L2I2xlqz6Mvku1VT5s697XOIcoFW9srwP4clxcOhoKlWrNl6qEjfE1boLYVqXCdfRa7n4BUhvx2zK/brSrW6cVgr33SNwhPI1d0MTyWzMxetr7FilhfJ3FL3tROBmr9fcUaCTFOXc544fu51NwFoIyCuSK4Xpfa1RLu2oZbyA==";

    //TODO !!!! 注：该公钥为测试账号公钥  开发者必须设置自己的公钥 ,否则会存在安全隐患
    public static final String PUBLIC_KEY = "";
    /**
     * 支付宝网关
     */
    public static final String ALIPAY_GATEWAY = "https://openapi.alipay.com/gateway.do";

    /**
     * 授权访问令牌的授权类型
     */
    public static final String GRANT_TYPE = "authorization_code";
}