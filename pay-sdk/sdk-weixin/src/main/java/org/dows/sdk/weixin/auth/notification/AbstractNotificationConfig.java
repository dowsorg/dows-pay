package org.dows.sdk.weixin.auth.notification;

import org.dows.sdk.client.certificate.CertificateProvider;
import org.dows.sdk.client.cipher.AeadCipher;
import org.dows.sdk.client.cipher.Verifier;
import org.dows.sdk.weixin.auth.cipher.RSAVerifier;

public abstract class AbstractNotificationConfig implements NotificationConfig {

    public final String signType;
    private final String cipherAlgorithm;
    private final CertificateProvider certificateProvider;
    private final AeadCipher aeadCipher;

    protected AbstractNotificationConfig(
            String signType,
            String cipherAlgorithm,
            CertificateProvider certificateProvider,
            AeadCipher aeadCipher) {
        this.signType = signType;
        this.cipherAlgorithm = cipherAlgorithm;
        this.certificateProvider = certificateProvider;
        this.aeadCipher = aeadCipher;
    }

    @Override
    public String getSignType() {
        return signType;
    }

    @Override
    public String getCipherType() {
        return cipherAlgorithm;
    }

    @Override
    public Verifier createVerifier() {
        return new RSAVerifier(certificateProvider);
    }

    @Override
    public AeadCipher createAeadCipher() {
        return aeadCipher;
    }
}
