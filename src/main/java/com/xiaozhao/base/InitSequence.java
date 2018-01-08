package com.xiaozhao.base;

/**
 * 初始化执行顺序，单个类的情况下：
 *
 *
 * 静态变量 > 静态块 > 实例变量 > 非静态块 > 构造函数
 */
public class InitSequence {

    int age = getAge();
    static String name = getName();

    {
        System.out.println("非静态块执行1--   （5）");
        age = 35;
    }

    {
        System.out.println(age);
        System.out.println("非静态块执行2--   （6）");
        age = 55;
    }

    static {
        System.out.println("---静态块执行1---   （2）");
        System.out.println(name);
    }

    static {
        System.out.println("---静态块执行2---   （3）");
    }


    public InitSequence() {
        System.out.println("构造函数执行--   （7）");
        System.out.println(age);
    }

    static String  getName(){
        System.out.println("静态变量--初始化--   （1）");
        return "张三丰";
    }

    int getAge(){
        System.out.println("实例变量--初始化--   （4）");
        return 25;
    }

    public static void main(String[] args) {
        InitSequence initSequence = new InitSequence();
    }
}

/**--------------------------------------继承的情况下----------------------------------------------*/

/**
 * 首先加载 子类 InitSon的编译代码，加载中发现有父类 InitParent，于是继续加载父类编译代码。
 */
class InitParent {
    private int i = 9;
    protected int j;

    public InitParent() {
        System.out.println("i=" + i + ",j=" + j);
        j = 39;
    }

    private static int x1 = printAndInit("父类.x1初始化");

    static int printAndInit(String s) {
        System.out.println(s);
        return 47;
    }

}

class InitSon extends InitParent {
    private int k = printAndInit("子类.k 初始化");

    public InitSon() {
        System.out.println("k=" + k);
        System.out.println("j=" + j);
    }

    private static int x2 = printAndInit("子类.x2 初始化");

    public static void main(String[] args) {
        System.out.println("子类构造函数");
        InitSon initSon = new InitSon();
    }
}
