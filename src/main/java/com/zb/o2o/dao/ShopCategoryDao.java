package com.zb.o2o.dao;

import com.zb.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCategoryDao {
    List<ShopCategory> selectShopCategory(@Param("categoryCondition") ShopCategory categoryCondition);

}
