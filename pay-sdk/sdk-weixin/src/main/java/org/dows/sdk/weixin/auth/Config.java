package org.dows.sdk.weixin.auth;

import org.dows.sdk.weixin.auth.base.Credential;
import org.dows.sdk.weixin.auth.base.Validator;
import org.dows.sdk.weixin.auth.cipher.PrivacyDecryptor;
import org.dows.sdk.weixin.auth.cipher.PrivacyEncryptor;
import org.dows.sdk.weixin.auth.cipher.Signer;

/**
 * 调用微信支付服务的所需配置
 */
public interface Config {

    /**
     * 创建敏感信息加密器
     *
     * @return 敏感信息加密器
     */
    PrivacyEncryptor createEncryptor();

    /**
     * 创建敏感信息解密器
     *
     * @return 敏感信息解密器
     */
    PrivacyDecryptor createDecryptor();

    /**
     * 创建认证凭据生成器
     *
     * @return 认证凭据生成器
     */
    Credential createCredential();

    /**
     * 创建请求验证器
     *
     * @return 请求验证器
     */
    Validator createValidator();

    /**
     * 创建签名器
     *
     * @return 签名器
     */
    Signer createSigner();
}
