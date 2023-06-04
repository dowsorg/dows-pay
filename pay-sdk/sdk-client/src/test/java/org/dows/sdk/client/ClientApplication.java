package org.dows.sdk.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"org.dows.sdk.client.feign"})
@SpringBootApplication
@ApiScan(scanPackages = {"org.dows.sdk.weixin.open"}, urlLocations = {})
public class ClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class);
    }

}
