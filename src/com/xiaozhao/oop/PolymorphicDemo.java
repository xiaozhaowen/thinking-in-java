package com.xiaozhao.oop;

/**
 * 如果父类有一个私有方法，然后子类也声明了同样名称的方法。如果父类声明指向一个子类实例，Parent parent = new Son();
 * 在父类私有方法可见的作用域中调用 parent.privateMethod()时，结果却是父类的方法，而并非是子类的方法。
 *
 * 解决方案：为了解决这种问题，最好是在子类中声明不同的方法名
 *
 */
public class PolymorphicDemo {
    private void privateMethod() {
        System.out.println("父类私有方法");
    }

    public static void main(String[] args) {
        PolymorphicDemo polymorphicDemo = new PolymorphicSon();
        polymorphicDemo.privateMethod();
    }
}

class PolymorphicSon extends PolymorphicDemo {
    public void privateMethod() {
        System.out.println("这里是子类");
    }
}



