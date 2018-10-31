package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

/**
 *
 */
public interface ICartService {

    //添加商品到购物车
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    //
    ServerResponse<CartVo> list(Integer userId);

    //选择或者反选所有的购物车中的商品
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked);
    //获取当前用户的购物车里面的商品总数量
    ServerResponse<Integer> getCartProductCount(Integer userId);

}
