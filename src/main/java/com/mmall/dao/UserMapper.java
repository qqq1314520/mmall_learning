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

    //通过用户名和密码查找用户
    User selectLogin(@Param("username") String username,@Param("password") String password);
}