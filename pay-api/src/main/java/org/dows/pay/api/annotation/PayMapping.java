package org.dows.pay.api.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PayMapping {
    String method();

    String argNames();
}
