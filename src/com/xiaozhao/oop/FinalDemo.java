package com.xiaozhao.oop;

/**
 * Created by xiaozhao on 2017/12/26.
 * 1） final 关键字可以修饰类，如果类修饰为final的话，则不能被继承
 * 2） java中const作为保留字，但是目前不能使用
 * 3） 声明常量方法为static final
 */
public class FinalDemo {

    // 如果成员变量被final修饰，则初始化后，不可再被赋值
    private final int age = 20;

    public FinalDemo() {
        // 编译错误，不能为final成员变量再次赋值
        //age = 25;
    }


    public void test() {
        // 局部变量被final修饰，初始化后不能再次被赋值
        final String name = "Kobe";
        // 编译错误，不能为final局部不变量再次赋值
//        name = "James";
    }


}

