package com.xiaozhao.newthing;


/**
 * 比较新鲜的东西
 */
public class Person {

    private int age;

    /**
     * 非静态代码块，里面的代码每次实例化对象的时候都会执行，而且早于构造函数，晚于实例变量
     */

    {
        age = 25;
    }

    public Person() {
        System.out.println(age);

    }

    public int getAge() {
        return age;
    }


}
