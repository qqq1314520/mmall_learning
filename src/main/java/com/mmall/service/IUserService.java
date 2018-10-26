package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface IUserService {

    //登录接口
    ServerResponse<User> login(String username, String password);

}
