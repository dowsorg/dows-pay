package org.dows.pay.api;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PayHandler {
    String channelCode();
}
