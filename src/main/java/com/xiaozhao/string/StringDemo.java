package com.xiaozhao.string;

import java.util.Scanner;

/**
 * 字符串使用示例：
 * 1、字符串是不可变对象
 * 2、Java重载了+和+=操作符，编译器会隐式的使用StringBuilder来优化
 * 3、如果涉及到循环体，还是显式的声明和使用StringBuilder
 * 4、如果在StringBuilder内部使用的时候，还是尽量减少使用+=
 * 5、StringBuffer是线程安全的，和StringBuilder的接口基本一致，但是几乎无使用的场景
 * 6、防止无意间的递归，类的toString方法中如果把this处理成字符串，就会递归调用
 */
public class StringDemo {

    /**
     * 常用方法的基本用法
     */
    public void baseUse() {
        String str1 = "Hello World";

        // 取得指定索引处的字符  --output 'o'
        char char_4 = str1.charAt(4);
        System.out.println(char_4);

        String str2 = "ABCD";
        String str3 = "abCd";

        // 比较字符串内容  --output false
        boolean isEquals = str2.equals(str3);
        System.out.println(isEquals);

        // 比较字符串内容，忽略大小写  --output true
        boolean isEqualsIgnoreCase = str2.equalsIgnoreCase(str3);
        System.out.println(isEqualsIgnoreCase);

        // 是否包含子串  --output true
        String subStr = "orl";
        boolean isContains = str1.contains(subStr);
        System.out.println(isContains);

        System.out.println("--------startsWith,endsWith-----------");
        System.out.println(str1.startsWith("He"));// 是否指定的字符串开头  --output true
        System.out.println(str1.endsWith("ld"));// 是否指定的字符串结尾  --output true

        System.out.println("--------indexOf-----------");
        System.out.println(str1.indexOf("World"));// 子串在父串中的起始位置  --output 6
        System.out.println(str1.lastIndexOf("ld"));// 从父串结尾开始子串在父串中起始的位置  --output 9

        System.out.println("--------replace-----------");
        System.out.println(str1.replace("World", "Java"));// 替换  --output Hello Java
        System.out.println(str1);

        System.out.println("--------trim-----------");
        String name = " Kobe Bryant   ";
        System.out.println(name.trim());// 去掉2端空白字符  --output Kobe Bryant

        System.out.println("--------toUpperCase-----------");
        System.out.println(name.trim().toUpperCase());// 转为大写字母  --output KOBE BRYANT
    }

    /**
     * 一些特殊用法
     */
    public void specialUse() {
        /**
         * 1、可以使用占位符加指定参数索引位，拼接模板
         * */
        System.out.println("--------String.format-----------");
        String template = "My name is %s,and I'm %d years old. 我还是 %s";
        String result = String.format(template, "科比", 33, "科比");
        System.out.println(result);

        String template2 = "My name is %1$s,and I'm %2$d years old. 我还是 %1$s";
        String result2 = String.format(template2, "科比", 33);
        System.out.println(result2);

        /**
         * 2、split用法，注意：. | * 等为转义字符，必须使用双反斜杠 \\
         * 也就是说只要是正则中的关键字都得使用转义，有： . | * $ +
         * 其他的也许还有，如果得不到想要的结果，尝试加上双反斜线
         * */

        String str1 = "Hello World";
        System.out.println("空格拆分");
        for (String retval: str1.split(" ")){
            System.out.println(retval);
        }

        // 必须使用 \\.  否则得不到想要的结果
        String str2 = "www.baidu.com";
        System.out.println("点拆分");
        for (String retval: str2.split("\\.")){
            System.out.println(retval);
        }

        // 必须使用 \\|  否则得不到想要的结果
        String str3 = "www|baidu|com";
        System.out.println("竖线拆分");
        for (String retval: str3.split("\\|")){
            System.out.println(retval);
        }


        // 必须使用 \\*  否则得不到想要的结果
        String str4 = "Java,Python,Swift";
        System.out.println("星号拆分");
        for (String retval: str4.split(",")){
            System.out.println(retval);
        }
    }

    /**
     * 从控制台得到输入值
     */
    public void readFromConsole() {
        System.out.println("输入");
        Scanner scanner = new Scanner(System.in);
        String read = scanner.nextLine();
        System.out.println("输入数据：" + read);
    }

    public static void main(String[] args) {
        StringDemo stringDemo = new StringDemo();
        stringDemo.specialUse();
    }
}
