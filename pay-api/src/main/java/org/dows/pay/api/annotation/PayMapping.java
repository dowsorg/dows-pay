package org.dows.pay.api.annotation;

import org.dows.pay.api.enums.PayMethods;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PayMapping {
    PayMethods method();
}
