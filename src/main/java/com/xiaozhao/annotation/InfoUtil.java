package com.xiaozhao.annotation;

import java.lang.reflect.Field;

/**
 * 解析注解
 *
 * @author xiaozhao
 */
public class InfoUtil {
    @Deprecated
    public static void getStudentInfo(Class<?> clazz) {
        Field[] fileds = clazz.getDeclaredFields();
        for (Field field : fileds) {
            if (field.isAnnotationPresent(FieldMeta.class)) {
                FieldMeta fieldMeta = (FieldMeta) field.getAnnotation(FieldMeta.class);
                String columnName = fieldMeta.name();
                System.out.println(columnName);
            }
        }
    }
}
