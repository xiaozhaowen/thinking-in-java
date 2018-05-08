package com.xiaozhao.annotation.table;

/**
 * JavaBean
 *
 * @author xiaozhao
 */
@DBTable(name = "member")
public class Member {
    String firstName;
    String lastName;

    void hello() {
    }
}
