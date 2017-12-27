import com.xiaozhao.oop.PolymorphicDemo;
import com.xiaozhao.oop.PolymorphicSon;

public class Main {

    public static void main(String[] args) {
        PolymorphicDemo polymorphicDemo = new PolymorphicSon();
        System.out.println("父类的年龄字段:" + polymorphicDemo.age + ",父类使用方法获取：" + polymorphicDemo.getAge());

        PolymorphicSon polymorphicSon = new PolymorphicSon();
        System.out.println("子类的年龄字段："
                + polymorphicSon.age + ",子类使用方法获取："
                + polymorphicSon.getAge()
                + "，父类方法得到："
                + polymorphicSon.getParentAge());


        System.out.println("-------------------------------");

        System.out.println(PolymorphicDemo.staticFunc());
        System.out.println(polymorphicDemo.dynamicFunc());

    }
}
