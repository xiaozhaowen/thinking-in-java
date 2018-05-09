package com.xiaozhao.reflect;

/**
 * 类型信息示例
 *
 * @author xiaozhao
 */
public class Person {

}

class Student extends Person {

}


class JuniorStudent extends Student {

}

class TestIt {
    public static void main(String[] args) {
        Person oneObj = new Student();

        // 包括继承的判断
        System.out.println("x instanceof JuniorStudent  " + (oneObj instanceof JuniorStudent));
        System.out.println("x instanceof Student  " + (oneObj instanceof Student));
        System.out.println("x instanceof Person  " + (oneObj instanceof Person));
        System.out.println();

        System.out.println("x isInstance JuniorStudent  " + (JuniorStudent.class.isInstance(oneObj)));
        System.out.println("x isInstance Student  " + (Student.class.isInstance(oneObj)));
        System.out.println("x isInstance Person  " + (Person.class.isInstance(oneObj)));
        System.out.println();

        //准确的判断，不包括继承
        System.out.println("x.getClass() == Person.class " + (oneObj.getClass() == Person.class));
        System.out.println("x.getClass() == Student.class " + (oneObj.getClass() == Student.class));
        System.out.println("x.getClass() == JuniorStudent.class " + (oneObj.getClass() == JuniorStudent.class));
        System.out.println();

        System.out.println("x.getClass() equals Person.class " + (oneObj.getClass().equals(Person.class)));
        System.out.println("x.getClass() equals Student.class " + (oneObj.getClass().equals(Student.class)));
        System.out.println("x.getClass() equals JuniorStudent.class " + (oneObj.getClass().equals(JuniorStudent.class)));


    }
}