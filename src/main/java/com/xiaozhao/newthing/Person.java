package com.xiaozhao.newthing;


import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 比较新鲜的东西
 * <p>
 * 1、代码块
 * 2、transient关键字。在类实现了Serializable接口时，实例变量被此关键字修饰后，不会被序列化。保护敏感信息
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

    public static void main(String[] args) {
        Son son = new Son();
        son.setId(1);
        son.setName("Jim Green");
        son.setPassword("123456");

        String result = JSONObject.toJSONString(son);
        System.out.println(result);
    }


}

class Son implements Serializable {
    private int id;
    private String name;
    private transient String password;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


