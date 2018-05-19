package com.zb.o2o.service;

import com.zb.o2o.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory categoryCondition);
}
