package com.mmall.dao;

import com.mmall.pojo.Order;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface OrderMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //通过用户和订单id查询 订单（防止横向越权）
    Order selectByUserIdAndOrderNo(@Param("userId")Integer userId,@Param("orderNo")Long orderNo);

    //通过订单id获取所有信息
    Order selectByOrderNo(Long orderNo);


    //通过用户id获取所有信息
    List<Order> selectByUserId(Integer userId);

    //后台：查询数据库中所有订单
    List<Order> selectAllOrder();

}