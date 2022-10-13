package org.dows.pay.api.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AlipayApiField {


    /**
     * 字段名称
     *
     * @return
     */
    String name();

    /**
     * 默认值
     *
     * @return
     */
    String def() default "";

}
