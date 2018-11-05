package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.vo.OrderVo;

import java.util.Map;

/**
 * 订单操作的service接口
 */
public interface IOrderService {

    //用户付款
    ServerResponse pay(Long orderNo, Integer userId, String path);

    //支付宝回调
    ServerResponse aliCallback(Map<String, String> params);

    //查询订单支付状态
    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);
/*
    //创建订单
    ServerResponse createOrder(Integer userId, Integer shippingId);

    //取消订单
    ServerResponse<String> cancel(Integer userId, Long orderNo);

    //
    ServerResponse getOrderCartProduct(Integer userId);

    //查询订单的详细信息
    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    //分页获取 所有订单
    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);*/


    //backend
    /*
    //后台分页显示所有订单
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    //后台显示订单的具体信息
    ServerResponse<OrderVo> manageDetail(Long orderNo);

    //后台分页查询
    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

    //后台设置商品已发货
    ServerResponse<String> manageSendGoods(Long orderNo);*/


}
