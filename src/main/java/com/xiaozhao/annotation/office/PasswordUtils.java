package com.xiaozhao.annotation.office;

/**
 * 使用注解的测试类
 *
 * @author xiaozhao
 */
public class PasswordUtils {
    @UseCase(id = 47, description = "密码必须包含一个数字")
    public boolean vlidatePassword(String password) {
        return true;
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return "";
    }

    @UseCase(id = 49, description = "新密码与旧密码不能相同")
    public boolean checkForNewPassword(String password) {
        return true;
    }
}

