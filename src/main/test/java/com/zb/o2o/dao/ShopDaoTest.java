package com.zb.o2o.dao;

import com.zb.o2o.BaseTest;
import com.zb.o2o.entity.Area;
import com.zb.o2o.entity.PersonInfo;
import com.zb.o2o.entity.Shop;
import com.zb.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop(){
        Shop shop = new Shop();
        shop.setShopName("店铺1");
        shop.setAdvice("审核中");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(0);
        shop.setLastEditTime(new Date());
        shop.setPhone("123456789");
        shop.setPriority(0);
        shop.setShopAddr("二楼");
        shop.setShopDesc("测试");
        shop.setShopImg("xxxx");
        Area area = new Area();
        area.setAreaId(2l);
        shop.setArea(area);
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1l);
        shop.setOwner(personInfo);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1l);
        shop.setShopCategory(shopCategory);

        int i = shopDao.insertShop(shop);
        Assert.assertEquals(i,1);
    }

    @Test
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(1l);
        shop.setShopImg("imgtest");
        shop.setPhone("phonetest");
        shop.setLastEditTime(new Date());
        int i = shopDao.updateShop(shop);
        Assert.assertEquals(i,1);
    }
}
