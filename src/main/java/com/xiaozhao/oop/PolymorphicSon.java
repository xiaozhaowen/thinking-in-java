package com.xiaozhao.oop;

/**
 * 多态子类
 */
public class PolymorphicSon extends PolymorphicDemo {

    public int age = 50;

    @Override
    public int getAge() {
        return age;
    }

    public int getParentAge() {
        return super.age;
    }

    public void privateMethod() {
        System.out.println("这里是子类");
    }

    // 静态方法不具有多态性
    public static String staticFunc() {
        return "**子类静态方法";
    }

    public String dynamicFunc() {
        return "**子类--普通--方法";
    }

}