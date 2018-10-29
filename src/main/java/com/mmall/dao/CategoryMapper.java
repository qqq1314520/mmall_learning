package com.mmall.dao;

import com.mmall.pojo.Category;
import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    //通过父分类获取同一级的分类  返回为List，在xml中可以用BaseResultMap来代替
    List<Category> selectCategoryChildrenByParentId(Integer parentId);
}