package com.xiaozhao.annotation.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库中的表
 *
 * @author xiaozhao
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {

    /**
     * 数据表的名称
     *
     * @return
     */
    public String name() default "";
}
