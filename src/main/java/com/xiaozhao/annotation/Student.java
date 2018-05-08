package com.xiaozhao.annotation;

/**
 * 实体类
 *
 * @author xiaozhao
 */
public class Student {

    @FieldMeta(id = true, name = "学号", editable = false)
    private int id;

    @FieldMeta(name = "姓名")
    private String name;

    @FieldMeta(name = "年龄")
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
