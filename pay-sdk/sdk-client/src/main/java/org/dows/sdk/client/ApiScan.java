package org.dows.sdk.client;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ApiScannerRegistrar.class)
public @interface ApiScan {


    String[] scanPackages();

    String[] urlLocations();
}
