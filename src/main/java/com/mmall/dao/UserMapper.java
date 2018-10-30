package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //通过主键删除用户
    int deleteByPrimaryKey(Integer id);

    //插入用户
    int insert(User record);

    //插入用户且数据都不能为空
    int insertSelective(User record);

    //通过主键查询用户
    User selectByPrimaryKey(Integer id);

    //通过主键更新用户消息，且数据都不能为空
    int updateByPrimaryKeySelective(User record);

    //通过主键更新用户消息
    int updateByPrimaryKey(User record);

    //查询用户名是否存在
    int checkUsername(String username);

    int checkEmail(String email);

    //通过用户名和密码（MD5形式）查找用户
    User selectLogin(@Param("username") String username,@Param("password") String password);

    String selectQuestionByUsername(String username);

    //多个参数parameterType用java.util.Map
    int checkAnswer(@Param("username")String username,@Param("question")String question,@Param("answer")String answer);

    //通过用户名更新密码（MD5形式）
    int updatePasswordByUsername(@Param("username")String username,@Param("passwordNew")String passwordNew);

    //验证密码
    int checkPassword(@Param(value="password")String password,@Param("userId")Integer userId);

    //验证email
    int checkEmailByUserId(@Param(value="email")String email,@Param(value="userId")Integer userId);

    //测试接口
    User selectByUserId(@Param(value="id") Integer id);

    /*ServerResponse checkAdminRole(User user);*/
}