package com.xiaozhao.base;

import java.util.Calendar;

/**
 * final使用示例
 * <p>
 * java中const作为保留字，但是目前不能使用
 * final方法是编译期间静态绑定，而不是动态绑定
 * private的方法都是final的，不会动态绑定。印证上一条原则
 * 将类，方法，变量声明为final能够提高性能，这样JVM就有机会进行估计，然后优化，但是更应该以设计为主。
 */


/**
 * 修饰变量
 * 1、final修饰的成员变量，必须通过以下3种方式显式的指定初始值：
 * （1.1）定义成员变量时赋值
 * （1.2）非静态块中赋值
 * （1.3）构造函数中赋值
 * <p>
 * 2、final修饰的 !!!静态!!! 成员变量，必须通过以下2种方式显式指定初始值：
 * （2.1）定义 !!!静态!!!成员变量时赋值
 * （2.2）静态代码块中赋值
 * <p>
 * 3、final修饰的变量，赋值后不可更改
 * （3.1）基本类型不可再变（数值恒定不变）
 * （3.2）引用类型的引用不可再变，但是对象内容可变（引用恒定不变）
 * <p>
 * 4、编译期间常量（宏替换）
 * 一个final变量，不管是成员变量，局部变量还是静态变量，在定义时直接赋值（非方法赋值），这样就会变成了直接量或者宏。编译期间进行宏替换。
 * （4.1）必须在定义变量的之处赋值（代码块，构造函数不行）
 * （4.2）不可使用方法的返回值赋值
 */
public class FinalDemo {


    private final int age = 20;                                 // 定义时赋值
    private final boolean isMale;                               // 代码块赋值
    private final String name;                                  // 构造函数赋值
    private final FinalValueObj finalValueObj = new FinalValueObj(24, "科比");

    /**
     * 非静态块中赋值
     */ {
        isMale = true;
    }

    /**
     * 三个编译期间的常量
     */
    private final int compileConstant_1 = 10;
    private static final int COMPILE_CONSTANT_2 = 20;
    public static final int COMPILE_CONSTANT_PUBLIC = 20;       // 对外公共常量的典型写法


    final static String clubName = "湖人队";                     // 定义时赋值
    final static String address;                                // 静态代码块赋值

    static {
        address = "洛杉矶";
    }


    /**
     * 编译期间不能确定的值
     */
    private final int realAge = computeAge();

    public FinalDemo() {
        /**
         * 编译错误，不能为final成员变量再次赋值
         age = 25;
         isMale = false;
         this.finalValueObj =  new FinalValueObj(3, "韦德");
         */

        /**构造函数赋值*/
        name = "丁春秋";

        System.out.println(this.finalValueObj);
        // 引用类型的引用不可变，但是对象内容可变
        this.finalValueObj.setName("Kobe Bryant");
        System.out.println(this.finalValueObj);
    }

    /**
     * 局部变量说明
     */
    public void localVariableTest() {
        final boolean isChina;
        // 局部变量被final修饰，初始化后不能再次被赋值
        final String name = "Kobe";
        System.out.println(name);
        // 编译错误，不能为final局部不变量再次赋值
//        name = "James";
    }

    /**
     * 动态计算年龄
     *
     * @return
     */
    private int computeAge() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) - 1985;
    }

    private void compileVar() {
        String str1 = "HelloWorld";
        String str2 = "Hello" + "World";
        System.out.println(str1 == str2);                   // true

        String s1 = "Hello";
        String s2 = "World";
        String str3 = s1 + s2;
        System.out.println(str1 == str3);                   // false

        /**
         * final修饰的变量，编译期间会进行查找替换
         */
        final String m1 = "Hello";
        final String m2 = "World";
        String str4 = m1 + m2;
        System.out.println(str1 == str4);                   // true
    }

    public static void main(String[] args) {
        FinalDemo finalDemo = new FinalDemo();
//        System.out.println(finalDemo.computeAge());
        finalDemo.compileVar();
    }
}

/**
 * 引用类型测试类
 */
class FinalValueObj {
    private int id;
    private String name;

    public FinalValueObj(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FinalSon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


/**
 * 修饰类和方法
 * 1、final修饰的类不可再被继承
 * 2、final修饰的方法，子类不能覆盖此方法
 * 3、final修饰方法的参数，参数在方法内部不可修改
 */
class FinalParent {
    protected final void sayHello(String name) {
        System.out.println("父类说：你好" + name);
    }

    /**
     * 方法参数为值类型
     */
    public void testValueParam(final int a) {
        /** 编译错误
         a = 10;
         */
    }

    public void testReferenceParam(final FinalValueObj finalValueObj) {

        /** 编译错误
         finalValueObj = new FinalValueObj(1,"");
         */

        finalValueObj.setName("AAAA");
    }
}

/**
 * 子类
 */
class FinalSon extends FinalParent {

    /**
     * 父类方法用final修饰后，子类不能覆盖此方法
     *
     * @Override protected void sayHello(String name) {
     * System.out.println("子类说：你好" + name);
     * }
     */

    public static void main(String[] args) {
        FinalSon finalSon = new FinalSon();
        finalSon.sayHello("张无忌");
        // 输出：父类说：你好张无忌
    }
}

