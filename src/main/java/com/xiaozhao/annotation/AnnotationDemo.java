package com.xiaozhao.annotation;

/**
 * 注解的基本使用
 * 1、注解的分类
 * 2、内置的注解，元注解
 * 3、自定义注解：如何使用？如何发挥注解的作用
 * 4、Spring等框架中的注解，例如@Autowired是怎么起作用的
 *
 * @author xiaozhao
 */
public class AnnotationDemo {

    public void test() {
        InfoUtil.getStudentInfo(Student.class);
    }


    public static void main(String[] args) {
        AnnotationDemo annotationDemo = new AnnotationDemo();
        annotationDemo.test();
    }
}


