package org.dows.sdk.client;

import feign.Headers;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

public interface ApiClient {
    @GetMapping(consumes = "application/json")
    @Headers(value = "Content-Type:application/json")
    String get(URI uri, @RequestHeader Map<String, String> headers);

    @PostMapping
    @Headers(value = "Content-Type:application/json")
    String post(URI uri, @RequestHeader Map<String, String> headers, @RequestBody Map<String, Object> request);

    @DeleteMapping
    @Headers(value = "Content-Type:application/json")
    String delete(URI uri, @RequestHeader Map<String, String> headers, @RequestBody Map<String, Object> request);

    @PutMapping
    @Headers(value = "Content-Type:application/json")
    String put(URI uri, @RequestHeader Map<String, String> headers, @RequestBody Map<String, Object> request);
}
