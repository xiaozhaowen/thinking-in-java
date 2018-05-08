package com.xiaozhao.annotation.office;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 注解处理器
 *
 * @author xiaozhao
 */
public class UseCaseTracker {
    /**
     * 1、利用反射获取到类中所有的方法
     * 2、循环每一个方法，得到方法对应的注解
     * 3、打印这个注解的信息
     *
     * @param cases
     * @param clazz
     */
    public static void trackUseCase(List<Integer> cases, Class<?> clazz) {
        for (Method m : clazz.getDeclaredMethods()) {
            UseCase useCase = m.getAnnotation(UseCase.class);
            if (useCase != null) {
                System.out.println(useCase.id() + ":" + useCase.description());
                cases.remove(new Integer(useCase.id()));
            }
        }
        for (int index : cases) {
            System.out.println("没有实现的方法是：" + index);
        }
    }

    public static void main(String[] args) {
        List<Integer> cases = new ArrayList<Integer>();
        Collections.addAll(cases, 47, 48, 49, 50);
        trackUseCase(cases, PasswordUtils.class);
    }
}
