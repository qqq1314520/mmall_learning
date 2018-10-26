package com.mmall.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录的service处理：
     *     先调用dao验证用户名是否存在
     *     验证密码是否正确
     * @param username
     * @param password
     * @param session
     * @return
     */
    @Override
    public ServerResponse<User> login(String username, String password) {

        int resultCount = userMapper.checkUsername(username);
        //如果返回用户名不存在
        if (resultCount == 0){
            return ServerResponse.createByErrorMessage("用户名不存在！");
        }
        //否则返回该扩展类
        return ServerResponse.createBySuccess();
    }

}
