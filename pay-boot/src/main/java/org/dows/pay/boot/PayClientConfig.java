package org.dows.pay.boot;

import lombok.Data;
import org.dows.pay.boot.properties.PayClientProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "dows.pay")
public class PayClientConfig {
    private List<PayClientProperties> clientConfigs;
}