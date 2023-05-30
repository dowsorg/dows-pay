package org.dows.pay.spider;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WexinOpenField {
    String value();
}
