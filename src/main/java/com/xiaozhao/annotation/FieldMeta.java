package com.xiaozhao.annotation;

import java.lang.annotation.*;

/**
 * 表字段的注解
 *
 * @author xiaozhao
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface FieldMeta {
    /**
     * 是否为主键列
     *
     * @return
     */
    boolean id() default false;

    /**
     * 字段名称
     *
     * @return
     */
    String name() default "";

    /**
     * 是否可编辑
     *
     * @return
     */
    boolean editable() default true;


}
