package com.xiaozhao.annotation.table;

/**
 * JavaBean
 *
 * @author xiaozhao
 */
@DBTable(name = "member")
public class Member {

    /**
     * 姓
     */
    @SQLString(30)
    String firstName;

    /**
     * 名字
     */
    @SQLString(50)
    String lastName;

    /**
     * 年龄
     */
    @SQLInteger
    Integer age;

    /**
     * 其他字段
     */
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    @Override
    public String toString() {
        return handle;
    }
}
