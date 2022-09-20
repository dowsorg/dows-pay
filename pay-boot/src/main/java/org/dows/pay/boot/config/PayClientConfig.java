package org.dows.pay.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "dows.pay")
public class PayClientConfig {
    private List<PayClientProperties> clientConfigs;
}