package com.xiaozhao.annotation.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据表的数据类：整型
 *
 * 注解中也可以使用注解，可以设定值，如果不设定，则所有的为默认值
 *
 * @author xiaozhao
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
    /**
     * 列的名称
     */
    String name() default "";

    /**
     * 列的约束
     */
    Constraints constraints() default @Constraints;

}
