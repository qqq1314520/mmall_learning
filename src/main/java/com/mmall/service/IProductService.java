package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

/**
 *
 */
public interface IProductService {

    //新增商品或更新商品的方法
    ServerResponse saveOrUpdateProduct(Product product);

    //更新商品状态
    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    //后台获取商品详情
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    //获取商品列表并分页
    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    //查询商品
    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

    //前台获取商品
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    //通过关键字或分类的类名，查询商品集合
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);



}
