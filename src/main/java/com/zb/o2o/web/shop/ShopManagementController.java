package com.zb.o2o.web.shop;

import com.alibaba.fastjson.JSONObject;
import com.zb.o2o.entity.Area;
import com.zb.o2o.entity.Shop;
import com.zb.o2o.entity.ShopCategory;
import com.zb.o2o.service.AreaService;
import com.zb.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopManagementController {
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    @RequestMapping(path = "/getshopinitinfo",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getShopInitInfo(){
        Map<String,Object> modelMap = new HashMap<>();
        List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
        List<Area> areaList = new ArrayList<Area>();
        try {
            //categoryCondition != null && categoryCondition.parent.shopCategoryId == null
            //查询parentId != null 的shopCategory
            shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
            areaList = areaService.getAreaList();
        } catch (Exception e) {
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
        }
        modelMap.put("success",true);
        modelMap.put("shopCategoryList",shopCategoryList);
        modelMap.put("areaList",areaList);
        return modelMap;
    }

    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> registerShop(@RequestParam("shopStr") String shopStr,
                                           @RequestParam("shopImg") MultipartFile file
                                            ){
        Map<String,Object> modelMap = new HashMap<>();
        /*if (shopStr == null){
            modelMap.put("success",false);
            modelMap.put("errMsg","商铺信息不能为空");
        }
        if(file == null){
            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
        }*/


        //应该从session获取
        //PersonInfo personInfo = new PersonInfo();
        //personInfo.setUserId(1l);
        //shop.setOwner(personInfo);

        try {
            System.out.println("====" + shopStr);
            Shop shop = JSONObject.parseObject(shopStr,Shop.class);
            System.out.println("name" + shop.getShopName()+shop.getShopAddr());
            System.out.println(file.getOriginalFilename() + file.getSize());
        } catch (Exception e) {
            e.printStackTrace();
        }

        modelMap.put("success",true);

        return  modelMap;
    }



}
