package org.dows.pay.weixin.utils;

import cn.hutool.core.util.RandomUtil;
import com.wechat.pay.java.core.util.PemUtil;
import okhttp3.HttpUrl;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class WeChatSignUtil {

    private static String privateKey = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDS/txxpRy9c085\n" +
            "8vOs6aJMLyjixIi5l4glkLqCbkwzSa+jrdPA97zY0QkQEkwjGJn33lxv0/WWREWc\n" +
            "TlqFDyM1jl9PsdF9F32WMYC1V7q0QWMHSc9DFDGYxEbgAtrHSwvjmWkCPVEKT8ay\n" +
            "5ur9gnzzrvNnR4fGyS90QWpHQhau5sbIlwVwyDuzGBNcOYElto5X5P8htjpxESX9\n" +
            "fnNYLDl3D4ecNYXBqBQ/BCJNYHJ7KW8F87HJXqn+I+Z2YY2MVq2VWXTGfZLiSZXP\n" +
            "+UklLbtFbGJZvCBjRmC7xYIWIfP8uWcwn0xhdnMAW4oeQTcTSUJxPU8zeaiBh1JF\n" +
            "a5ob787TAgMBAAECggEBAILjZT7+jUCdGoW5SB545JxcGQHrp2FyNhwPlxO4dn7O\n" +
            "dC2WdKjdRgI+Ul/s6dxPs5vHDhK1K0EnYwNeu9qVFGNxyYB3r5vpCZg1Z0GXhZOy\n" +
            "iEsKJ4/WJBo/kDQAsVU2Ic7z6OdhwDckW/+5LgdLflXwrr/f6MORJGX6+oHv5oBi\n" +
            "OWkh8S5O3hAHLhCD8LHbaPy0aLDPMSbDZ5OOijFE6DXdvicXKRSjwlDLTF7pnqsY\n" +
            "Cr234Z09GrO1AuUq+hdaEL9UgSsjp9hHXyA+JHi08W2M56YKDH5Zdp9CFKfT22FP\n" +
            "JIT6wYd8366Y5+/WJBkPREKyBCNabzU7Q6AHTOq27vECgYEA/hRBYtidhGkZjLhQ\n" +
            "d82Drxxg/8HFB3VVliSPLhS9jS8q0Xpkob5ha95ouuwq5VbPi2eRgZy7I44yBp9d\n" +
            "0YbZbcb4kbVeMJrMeEOKu3aGwa/K9gNP+IVM6eNy8jQd29csDfFqr3JEQV0pJFCg\n" +
            "OUl/QU4TrlZXFh6IqzKROy8R+ykCgYEA1Jc4xkb8sI7uWUEUooSCXwbwvglxTAha\n" +
            "u4XaT07ivy3hmcWfCx4juQ3plb+pnkPZmO0vaHFO4F7hzqX00mEu/areZLc8UXXu\n" +
            "52kMRf48awuGbVuoN+i3nI8PYY6nkQiGyDQfCwCfkd0S/ETdw1bZhJkFDQEWMEiF\n" +
            "B3VRY32LdZsCgYBE326+AaPpMagoWgoN/5qTjCjLC1aCaA70LSLWxe5/5+o+cGP4\n" +
            "6Cd2WwqeqMgT9M07p65sqPSddb0fyHFhC6HCvS3CKZzHph6I9x4TJNTwiduFhm5W\n" +
            "GqQ3vlz5RKFXZ2NcwDVAK8ROx5cQbf6QqNii9iwllOf0agB4D7QIjADeyQKBgQDF\n" +
            "+9dqAK5QF6yt/sgi2lk3+pS1xsF218j4Hx5DAep1tVsHBF6r0fPe4bAKQCbNN88s\n" +
            "dqfSEsQsfPC6rR+l1dAXecwH7AYGr1hAtzow7SaDYoZcziGJf/ePnEPszRgNH+22\n" +
            "AaRvcLMq+sI1okUNKJMGxCNKCxsI+GC7o2yaxU7dxQKBgCdN0CzAT9YYBPbZ4cJe\n" +
            "l/pCjWPD+0NaqIYpme55oNPWvVsZKsbSnVeCZCUChTwk3O31wWnkJ6TCd3QV1g1x\n" +
            "waqp81ih7E+Uvl0dQAFLLdbuDBJcySi1W71Ui6X7KBEuEQIi2THsclYSPB7DhSQV\n" +
            "/ZJFOO4fEn3soVs52Ep/nq+K\n" +
            "-----END PRIVATE KEY-----\n";


    public static String getAuthorization(String method, String url, String body) {
        String nonceStr = RandomUtil.randomString(32).toUpperCase();;
        long timestamp = System.currentTimeMillis() / 1000;
        HttpUrl parse = HttpUrl.parse(url);
        String message = buildMessage(method, parse, timestamp, nonceStr, body);
        String signature = sign(message.getBytes(StandardCharsets.UTF_8));

        return "mchid=\"" + "1604404392" + "\","
                + "nonce_str=\"" + nonceStr + "\","
                + "timestamp=\"" + timestamp + "\","
                + "serial_no=\"" + "286E17940AA08D8020EEC1C60B4CF9B2EBCAF50C" + "\","
                + "signature=\"" + signature + "\"";
    }

    public static String sign(byte[] message) {
        try {
            PrivateKey merchantPrivateKey = PemUtil.loadPrivateKeyFromString(privateKey);
            Signature sign = Signature.getInstance("SHA256withRSA");
            sign.initSign(merchantPrivateKey);
            sign.update(message);
            return Base64.getEncoder().encodeToString(sign.sign());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String buildMessage(String method, HttpUrl url, long timestamp, String nonceStr, String body) {
        String canonicalUrl = url.encodedPath();
        if (url.encodedQuery() != null) {
            canonicalUrl += "?" + url.encodedQuery();
        }

        return method + "\n"
                + canonicalUrl + "\n"
                + timestamp + "\n"
                + nonceStr + "\n"
                + body + "\n";
    }
}
