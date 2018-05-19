package com.zb.o2o.service;

import com.zb.o2o.BaseTest;
import com.zb.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShopCategoryServiceTest extends BaseTest{
    @Autowired
    private ShopCategoryService shopCategoryService;

    @Test
    public void testgetShopCategoryList(){
        List<ShopCategory> list = new ArrayList<>();
        //list = shopCategoryService.getShopCategoryList(null);
        //Assert.assertEquals(3,list.size());
        //list = shopCategoryService.getShopCategoryList(new ShopCategory());
        //Assert.assertEquals(2,list.size());
        ShopCategory shop = new ShopCategory();
        shop.setShopCategoryId(1l);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setParent(shop);
        list = shopCategoryService.getShopCategoryList(shopCategory);
        Assert.assertEquals("烧烤",list.get(0).getShopCategoryName());
    }
}
