package com.tuyendev.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Autoinjector {
    String mappedName() default "";
    String injectType() default InjectorType.REMOTE;
    String refName() default "";
}
