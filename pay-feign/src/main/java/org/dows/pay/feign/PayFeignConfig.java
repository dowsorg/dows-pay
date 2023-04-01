package org.dows.pay.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients
@Configuration
@ComponentScan("org.dows.pay.feign")
public class PayFeignConfig {
}
