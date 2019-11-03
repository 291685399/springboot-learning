package com.wyj.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author wyj
 * @date 2019-10-30 09:49
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface AccessLimit {

    int seconds();

    int maximum();

    boolean needLogin() default true;

}
