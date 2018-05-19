package com.zb.o2o.service.impl;

import com.zb.o2o.dao.ShopCategoryDao;
import com.zb.o2o.entity.ShopCategory;
import com.zb.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory categoryCondition) {
        return shopCategoryDao.selectShopCategory(categoryCondition);
    }
}
