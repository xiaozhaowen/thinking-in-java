package com.xiaozhao.base;

/**
 * static使用示例
 *
 * 1、静态成员不具有多态性
 * 2、构造函数也是静态的，只不过是隐式的声明
 * 3、不存在静态构造函数，但是有静态块
 * 4、静态方法可以被类的实例访问，但是推荐是使用 "类名.静态方法名" 的写法
 */
public class StaticDemo {

    private static int age;

    public StaticDemo() {

    }

    /**
     * 这种写法是非法的
     public static StaticDemo(int a) {

     }
     */

    static {
        age = 25;
    }
}
