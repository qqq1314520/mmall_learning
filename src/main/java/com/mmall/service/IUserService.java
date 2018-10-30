package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

public interface IUserService {

    //登录接口
    ServerResponse<User> login(String username, String password);

    //注册接口
    ServerResponse<String> register(User user);

    //检验用户名和email
    ServerResponse<String> checkValid(String str,String type);

    //查询密保问题
    ServerResponse selectQuestion(String username);

    //验证密保答案
    ServerResponse<String> checkAnswer(String username,String question,String answer);

    //忘记密码并重置密码
    ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);

    //重置密码
    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer userId);

    ServerResponse checkAdminRole(User user);

    User selectByUserId(Integer id);
}
