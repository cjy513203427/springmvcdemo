package org.format.demo.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/28 14:15
 * @Description: 自定义参数注解
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestObj {
    //参数别名
    String value() default "";
}