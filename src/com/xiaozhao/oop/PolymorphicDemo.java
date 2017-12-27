package com.xiaozhao.oop;

/**
 * 多态父类
 *
 *
 * 1）如果父类有一个私有方法，然后子类也声明了同样名称的方法。如果父类声明指向一个子类实例，Parent parent = new Son();
 * 在父类私有方法可见的作用域中调用 parent.privateMethod()时，结果却是父类的方法，而并非是子类的方法。
 * --解决方案：为了解决这种问题，最好是在子类中声明不同的方法名
 *
 *
 * 2）父类的字段是在编译期间确定的，因此向上转型的话也会使用父类的字段
 * --解决方案：一般父类的字段都是私有的，子类也应该声明为不同的名字
 *
 * 3）静态方法不具有多态性，向上转型会调用父类的静态方法
 */
public class PolymorphicDemo {

    // 父类的字段是在编译期间确定的，因此向上转型的话也会使用父类的字段
    public int age = 100;

    public int getAge() {
        return age;
    }

    private void privateMethod() {
        System.out.println("父类私有方法");
    }

    public static void main(String[] args) {
        PolymorphicDemo polymorphicDemo = new PolymorphicSon();
        polymorphicDemo.privateMethod();
    }

    // 静态方法不具有多态性
    public static String staticFunc() {
        return "父类静态方法";
    }

    // 普通方法
    public String dynamicFunc() {
        return "父类---普通--方法";
    }
}





