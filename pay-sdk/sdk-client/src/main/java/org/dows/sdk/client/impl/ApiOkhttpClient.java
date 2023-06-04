package org.dows.sdk.client.impl;

import lombok.RequiredArgsConstructor;
import org.dows.sdk.client.ApiClient;
import org.dows.sdk.client.http.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;

/**
 * 通过okhttp实现
 */
@RequiredArgsConstructor
@Service
public class ApiOkhttpClient implements ApiClient {
    @Autowired(required = false)
    private HttpClient httpClient;


    @Override
    public String get(URI uri, Map<String, String> headers) {
        return null;
    }

    @Override
    public String post(URI uri, Map<String, String> headers, Map<String, Object> request) {
        return null;
    }

    @Override
    public String delete(URI uri, Map<String, String> headers, Map<String, Object> request) {
        return null;
    }

    @Override
    public String put(URI uri, Map<String, String> headers, Map<String, Object> request) {
        return null;
    }
}
