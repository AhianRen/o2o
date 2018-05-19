package com.zb.o2o.service;

import com.zb.o2o.dto.ShopExecution;
import com.zb.o2o.entity.Shop;
import org.springframework.web.multipart.MultipartFile;

public interface ShopService {

    ShopExecution addShop(Shop shop, MultipartFile file);
}
