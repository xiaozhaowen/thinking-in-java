package com.xiaozhao.access;

/**
 * 访问修饰符
 */
public class Student {
    private String s;
    private int i;
    private String name = "Kobe";

    public Student() {
        System.out.println("构造函数");
        System.out.println(i);
        System.out.println(name);
        s = "Student";
    }

    {
        i = 47;
    }

    @Override
    public String toString() {
        return s;
    }
}

