package org.dows.sdk.client.feign;

import org.dows.sdk.client.ApiClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url="http://127.0.0.1",name = "feignClientDispatcher", configuration = ApiFeignClientConfig.class)
public interface ApiFeignClient extends ApiClient {


}