package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;

/**
 * 收货地址管理模块开发
 */
public interface IShippingService {

    //添加收货地址
    ServerResponse add(Integer userId, Shipping shipping);

    //通过收货地址的编号id，删除收货地址
    ServerResponse<String> del(Integer userId, Integer shippingId);

    //更新收货地址
    ServerResponse update(Integer userId, Shipping shipping);

    //查询 该收货地址 详细信息
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);

    //查询所有收货地址，并分页
    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);

}
