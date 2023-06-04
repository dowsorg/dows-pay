package org.dows.sdk.weixin.auth.notification;

import org.dows.sdk.client.certificate.CertificateProvider;
import org.dows.sdk.client.cipher.AeadCipher;
import org.dows.sdk.client.util.PemUtil;
import org.dows.sdk.weixin.auth.certificate.InMemoryCertificateProvider;
import org.dows.sdk.weixin.auth.cipher.AeadAesCipher;

import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.dows.sdk.weixin.auth.notification.Constant.AES_CIPHER_ALGORITHM;
import static org.dows.sdk.weixin.auth.notification.Constant.RSA_SIGN_TYPE;

/**
 * 签名类型为RSA的通知配置参数
 */
public final class RSANotificationConfig extends AbstractNotificationConfig {

    private RSANotificationConfig(CertificateProvider certificateProvider, AeadCipher aeadCipher) {
        super(RSA_SIGN_TYPE, AES_CIPHER_ALGORITHM, certificateProvider, aeadCipher);
    }

    public static class Builder {

        private List<X509Certificate> certificates;
        private byte[] apiV3Key;

        public Builder certificates(X509Certificate... certificates) {
            this.certificates = Arrays.asList(certificates);
            return this;
        }

        public Builder certificates(String... certificates) {
            List<X509Certificate> certificateList = new ArrayList<>();
            for (String certificateString : certificates) {
                X509Certificate x509Certificate = PemUtil.loadX509FromString(certificateString);
                certificateList.add(x509Certificate);
            }
            this.certificates = certificateList;
            return this;
        }

        public Builder certificatesFromPath(String... certificatePaths) {
            List<X509Certificate> certificateList = new ArrayList<>();
            for (String certificatePath : certificatePaths) {
                X509Certificate x509Certificate = PemUtil.loadX509FromPath(certificatePath);
                certificateList.add(x509Certificate);
            }
            this.certificates = certificateList;
            return this;
        }

        public Builder apiV3Key(String apiV3Key) {
            this.apiV3Key = apiV3Key.getBytes(StandardCharsets.UTF_8);
            return this;
        }

        public RSANotificationConfig build() {
            CertificateProvider certificateProvider = new InMemoryCertificateProvider(certificates);
            return new RSANotificationConfig(
                    certificateProvider, new AeadAesCipher(requireNonNull(apiV3Key)));
        }
    }
}
