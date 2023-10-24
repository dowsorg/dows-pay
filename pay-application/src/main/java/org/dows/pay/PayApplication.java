package org.dows.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.mybatis.spring.annotation.MapperScan;

@EnableScheduling
@SpringBootApplication(scanBasePackages = {"org.dows.*"})
@MapperScan("org.dows.marketing.dao")
public class PayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }
}
