package com.mmall.dao;

import com.mmall.pojo.Cart;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CartMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    Cart selectCartByUserIdProductId(@Param("userId") Integer userId, @Param("productId")Integer productId);

    int deleteByUserIdProductIds(@Param("userId") Integer userId,@Param("productIdList")List<String> productIdList);

    //通过用户id查询购物车
    List<Cart> selectCartByUserId(Integer userId);

    //通过用户id获取被选中商品的状态
    int selectCartProductCheckedStatusByUserId(Integer userId);

    //选择或者反选所有的购物车中的商品
    int checkedOrUncheckedProduct(@Param("userId") Integer userId,@Param("productId")Integer productId,@Param("checked") Integer checked);

    //获取当前用户的购物车里面的商品总数量
    int selectCartProductCount(@Param("userId") Integer userId);

    //通过用户id查询购物车中所有已经勾选的商品信息
    List<Cart> selectCheckedCartByUserId(Integer userId);
}