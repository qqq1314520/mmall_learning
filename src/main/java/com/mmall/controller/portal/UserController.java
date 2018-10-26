package com.mmall.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

/**
 * 用户模块开发
 */
//指定是controller
@Controller
//给该类的url添加前缀
@RequestMapping("/user/")
public class UserController {

    /**
     * 用户登录方法--login
     * @param username
     * @param password
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public Object login(String username, String password, HttpSession session) {
        //调用service

        return null;
    }



}
