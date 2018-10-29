package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**
 * Created by geely
 */
public interface ICategoryService {

    //添加分类
    ServerResponse addCategory(String categoryName, Integer parentId);

    //更新分类的类名
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    //通过父分类获取同一级的分类
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    //查询本节点的id及孩子节点的id
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

}
