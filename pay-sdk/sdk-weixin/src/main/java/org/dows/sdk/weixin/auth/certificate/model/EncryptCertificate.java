package org.dows.sdk.weixin.auth.certificate.model;

import org.dows.sdk.client.util.GsonUtil;

public class EncryptCertificate {

    private String algorithm;
    private String nonce;
    private String associatedData;
    private String ciphertext;

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAssociatedData() {
        return associatedData;
    }

    public void setAssociatedData(String associatedData) {
        this.associatedData = associatedData;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
}
