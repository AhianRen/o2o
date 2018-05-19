package com.zb.o2o.service.impl;

import com.zb.o2o.Exceptions.ShopException;
import com.zb.o2o.dao.ShopDao;
import com.zb.o2o.dto.ShopExecution;
import com.zb.o2o.entity.Shop;
import com.zb.o2o.enums.ShopStateEnum;
import com.zb.o2o.service.ShopService;
import com.zb.o2o.util.FileUtil;
import com.zb.o2o.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, MultipartFile file) {
        shop.setPriority(0);
        shop.setEnableStatus(0);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        if (effectedNum <= 0){
            throw new RuntimeException("店铺创建失败");
        }else {
            String s = null;
            try {
                s = ImageUtil.generateThumbnail(file, FileUtil.getShopImgPath(shop.getShopId()));
            } catch (Exception e) {
                throw new ShopException("图片保存失败"+e.toString());
            }
            shop.setShopImg(s);
            effectedNum = shopDao.updateShop(shop);
            if (effectedNum <= 0){
                throw new ShopException("创建图片地址失败");
            }else {
                return new ShopExecution(ShopStateEnum.CHECK,shop);
            }
        }
    }

    private void addShopImg(Shop shop, MultipartFile file) {


    }
}
