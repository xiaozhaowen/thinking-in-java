package com.xiaozhao.array;

import java.util.Arrays;

/**
 * 数组使用示例
 * 1、创建数组可以new的形式，也可以使用大括号
 * 2、如果请求的下标超出了索引的长度，则会报一个 ArrayIndexOutOfBoundsException 的异常
 * 3、 java.utils.Arrays 类中一共了一套针对数组有帮助的静态方法
 *    3.1）toString 数组转字符串
 *    3.2）equals 比较2个数组是否相等
 *    3.3）sort 数组排序
 *    3.4）binarySearch 在已排序数组中查找
 *    3.5）hashCode 产生散列码
 * 4、数组的复制，使用System.arraycopy()方法，比for循环复制要快得多.数组的类型必须一致或者兼容
 */
public class ArrayDemo {

    /**
     * Arrays 的实用方法
     */
    public void arraysUtil() {
        int[] arr1 = new int[7];
        Arrays.fill(arr1,47);                       // 用一个数填充数组
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * 几种实例化的方式
     */
    public void getInstances() {
        Player[] players_a;                             // 只是数组的引用
        Player[] players_all_null = new Player[5];      // 对象数组中默认填充 null
        int[] ints_all_0 = new int[5];                  // 整数数组中默认填充 0
        Player[] players_init = {
                new Player(),
                new Player(),
                new Player()
        };

        System.out.println(Arrays.toString(players_all_null));
        System.out.println(Arrays.toString(ints_all_0));
    }


    /**
     * 越界异常
     */
    public void outOfRange() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }

        for (int item : arr) {
            System.out.println(item);
        }
        // 如果索引超出范围会报错：ArrayIndexOutOfBoundsException
        // System.out.println(arr[11]);
    }

    public static void main(String[] args) {
        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.arraysUtil();
    }
}


class Player {

}