package org.dows.sdk.client;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;

@Service
public class ApiClientImpl implements ApiClient {
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
