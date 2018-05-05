package com.feitian.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author: feitian
 * @Date: 2018-05-02  20:11
 * @description:
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface CheckAnnotation {

}
