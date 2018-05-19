package com.zb.o2o.service;

import com.zb.o2o.BaseTest;
import com.zb.o2o.dto.ShopExecution;
import com.zb.o2o.entity.Area;
import com.zb.o2o.entity.PersonInfo;
import com.zb.o2o.entity.Shop;
import com.zb.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;

public class ShopServiceTest extends BaseTest{
    @Autowired
    private ShopService shopService;
    @Test
    public void testAddShop(){
        Shop shop = new Shop();
        shop.setShopName("测试店铺2");
        shop.setPhone("测试号码");
        shop.setShopDesc("测试2");
        shop.setShopAddr("测试");
        Area area = new Area();
        area.setAreaId(1l);
        shop.setArea(area);
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1l);
        shop.setOwner(personInfo);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(3l);
        shop.setShopCategory(shopCategory);
        File file = new File("D:\\upload\\o2o1.png");
        ShopExecution shopExecution = null;

        try {
            FileInputStream inputStream = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile(file.getName(),file.getName(),"image/png",inputStream);
            shopExecution = shopService.addShop(shop, multipartFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("======================"+shopExecution.getShop().getShopId());

    }
}
