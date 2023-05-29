package org.dows.sdk.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ApiScan(scanPackages = {"org.dows.sdk.weixin.ams", "org.dows.sdk.weixin.cloudrun"}, urlLocations = {})
public class ClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class);
    }

}
