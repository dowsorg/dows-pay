package org.dows.sdk.weixin.auth.notification;

import org.dows.sdk.client.util.GsonUtil;

/**
 * 通知数据
 */
public class Resource {

    private String algorithm;
    private String ciphertext;
    private String associatedData;
    private String nonce;
    private String originalType;

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public String getAssociatedData() {
        return associatedData;
    }

    public void setAssociatedData(String associatedData) {
        this.associatedData = associatedData;
    }

    public String createNonce() {
        return nonce;
    }

    public String getOriginalType() {
        return originalType;
    }

    public void setOriginalType(String originalType) {
        this.originalType = originalType;
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
