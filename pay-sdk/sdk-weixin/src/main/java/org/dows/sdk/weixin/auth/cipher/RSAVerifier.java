package org.dows.sdk.weixin.auth.cipher;


import org.dows.sdk.client.certificate.CertificateProvider;

import static org.dows.sdk.weixin.auth.cipher.Constant.SHA256WITHRSA;

/**
 * RSA验签器
 */
public final class RSAVerifier extends AbstractVerifier {

    public RSAVerifier(CertificateProvider provider) {
        super(SHA256WITHRSA, provider);
    }
}
