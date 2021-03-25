package com.commontest.demo.annotation;


import java.lang.annotation.*;

/**
 * @author Cristianoxm
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoResponseAdvice {
}
