package com.xiaozhao.annotation.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 列的约束
 *
 * @author xiaozhao
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    /**
     * 是否主键
     */
    boolean primaryKey() default false;

    /**
     * 是否允许空
     */
    boolean allowNull() default true;

    /**
     * 是否唯一
     */
    boolean unique() default false;
}
