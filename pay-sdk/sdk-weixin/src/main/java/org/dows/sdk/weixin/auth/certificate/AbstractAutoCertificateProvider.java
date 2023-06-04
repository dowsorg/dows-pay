package org.dows.sdk.weixin.auth.certificate;

import lombok.extern.slf4j.Slf4j;
import org.dows.sdk.client.certificate.CertificateHandler;
import org.dows.sdk.client.certificate.CertificateProvider;
import org.dows.sdk.client.cipher.AeadCipher;
import org.dows.sdk.client.http.*;
import org.dows.sdk.client.util.PemUtil;
import org.dows.sdk.weixin.auth.certificate.model.Data;
import org.dows.sdk.weixin.auth.certificate.model.DownloadCertificateResponse;
import org.dows.sdk.weixin.auth.certificate.model.EncryptCertificate;

import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 自动更新平台证书提供器抽象类
 */
@Slf4j
public abstract class AbstractAutoCertificateProvider implements CertificateProvider {
    // 定时更新时间，60分钟，即1小时
    protected static final int UPDATE_INTERVAL_MINUTE = 60;
    // 安全的单线程定时执行器实例
    protected final SafeSingleScheduleExecutor executor = SafeSingleScheduleExecutor.getInstance();
    // http请求
    private final HttpRequest httpRequest;
    // 证书map
    private final Map<String, Map<String, X509Certificate>> certificateMap;
    // 商户号
    protected String merchantId;
    // 证书处理器
    protected CertificateHandler certificateHandler;
    // 解密平台证书的aeadCipher;
    protected AeadCipher aeadCipher;
    // 下载平台证书的httpClient
    protected HttpClient httpClient;
    // 自动更新次数
    private int updateCount;
    // 成功次数
    private int succeedCount;

    protected AbstractAutoCertificateProvider(String requestUrl, CertificateHandler certificateHandler,
                                              AeadCipher aeadCipher, HttpClient httpClient, String merchantId,
                                              Map<String, Map<String, X509Certificate>> wechatPayCertificateMap) {
        this(requestUrl, certificateHandler, aeadCipher, httpClient, merchantId, wechatPayCertificateMap,
                UPDATE_INTERVAL_MINUTE * 60);
    }

    protected AbstractAutoCertificateProvider(
            String requestUrl,
            CertificateHandler certificateHandler,
            AeadCipher aeadCipher,
            HttpClient httpClient,
            String merchantId,
            Map<String, Map<String, X509Certificate>> wechatPayCertificateMap,
            int updateInterval) {
        this.merchantId = merchantId;
        synchronized (AbstractAutoCertificateProvider.class) {
            if (!wechatPayCertificateMap.containsKey(merchantId)) {
                wechatPayCertificateMap.put(merchantId, new HashMap<>());
            } else {
                throw new IllegalStateException(
                        "The corresponding provider for the merchant already exists.");
            }
        }

        this.certificateHandler = certificateHandler;
        this.aeadCipher = aeadCipher;
        this.httpClient = httpClient;
        this.certificateMap = wechatPayCertificateMap;
        httpRequest = new HttpRequest.Builder()
                .httpMethod(HttpMethod.GET)
                .url(requestUrl)
                .addHeader(Constant.ACCEPT, " */*")
                .addHeader(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON.getValue())
                .build();
        // 下载证书，如果失败会抛出异常
        downloadAndUpdate(wechatPayCertificateMap);

        Runnable runnable =
                () -> {
                    log.info(
                            "Begin update Certificates.merchantId:{},total updates:{}", merchantId, updateCount);
                    try {
                        updateCount++;
                        downloadAndUpdate(wechatPayCertificateMap);
                        succeedCount++;
                    } catch (Exception e) {
                        // 已经有证书了，失败暂时忽略
                        log.error("Download and update WechatPay certificates failed.", e);
                    }

                    log.info(
                            "Finish update Certificates.merchantId:{},total updates:{}, succeed updates:{}",
                            merchantId,
                            updateCount,
                            succeedCount);
                };
        executor.scheduleAtFixedRate(runnable, updateInterval, updateInterval, TimeUnit.SECONDS);
    }

    /**
     * 下载并更新证书
     *
     * @param wechatPayCertificateMap 存放多商户对应证书的Map
     */
    protected void downloadAndUpdate(
            Map<String, Map<String, X509Certificate>> wechatPayCertificateMap) {
        HttpResponse<DownloadCertificateResponse> httpResponse = downloadCertificate(httpClient);

        Map<String, X509Certificate> downloaded = decryptCertificate(httpResponse);
        validateCertificate(downloaded);
        wechatPayCertificateMap.put(merchantId, downloaded);
    }

    /**
     * 下载证书
     *
     * @param httpClient 下载使用的HttpClient
     * @return httpResponse
     */
    protected HttpResponse<DownloadCertificateResponse> downloadCertificate(HttpClient httpClient) {
        HttpResponse<DownloadCertificateResponse> httpResponse;
        httpResponse = httpClient.execute(httpRequest, DownloadCertificateResponse.class);
        return httpResponse;
    }

    protected void validateCertificate(Map<String, X509Certificate> certificates) {
        certificates.forEach((serialNo, cert) -> certificateHandler.validateCertPath(cert));
    }

    /**
     * 从应答报文中解密证书
     *
     * @param httpResponse httpResponse
     * @return 应答报文解密后，生成X.509证书对象的Map
     */
    protected Map<String, X509Certificate> decryptCertificate(HttpResponse<DownloadCertificateResponse> httpResponse) {
        List<Data> dataList = httpResponse.getServiceResponse().getData();
        Map<String, X509Certificate> downloadCertMap = new HashMap<>();
        for (Data data : dataList) {
            EncryptCertificate encryptCertificate = data.getEncryptCertificate();
            X509Certificate certificate;
            String decryptCertificate =
                    aeadCipher.decrypt(
                            encryptCertificate.getAssociatedData().getBytes(StandardCharsets.UTF_8),
                            encryptCertificate.getNonce().getBytes(StandardCharsets.UTF_8),
                            Base64.getDecoder().decode(encryptCertificate.getCiphertext()));
            certificate = certificateHandler.generateCertificate(decryptCertificate);
            downloadCertMap.put(PemUtil.getSerialNumber(certificate), certificate);
        }
        return downloadCertMap;
    }

    public X509Certificate getAvailableCertificate(Map<String, X509Certificate> certificateMap) {
        // 假设拿到的都是可用的，选取一个能用最久的
        X509Certificate longest = null;
        for (X509Certificate item : certificateMap.values()) {
            if (longest == null || item.getNotAfter().after(longest.getNotAfter())) {
                longest = item;
            }
        }
        return longest;
    }

    @Override
    public X509Certificate getCertificate(String serialNumber) {
        return certificateMap.get(merchantId).get(serialNumber);
    }

    @Override
    public X509Certificate getAvailableCertificate() {
        return getAvailableCertificate(certificateMap.get(merchantId));
    }
}
