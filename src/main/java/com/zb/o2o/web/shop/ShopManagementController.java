package com.zb.o2o.web.shop;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.Constants;
import com.zb.o2o.dto.ShopExecution;
import com.zb.o2o.entity.Area;
import com.zb.o2o.entity.PersonInfo;
import com.zb.o2o.entity.Shop;
import com.zb.o2o.entity.ShopCategory;
import com.zb.o2o.enums.ShopStateEnum;
import com.zb.o2o.service.AreaService;
import com.zb.o2o.service.ShopCategoryService;
import com.zb.o2o.service.ShopService;
import com.zb.o2o.util.AttributesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(ShopManagementController.class);
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private ShopService shopService;

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
    public Map<String,Object> registerShop(@RequestParam(value = "shopStr",required = true) String shopStr,
                                           @RequestParam(value = "verifyCode",required = true) String verifyCode,
                                           @RequestParam(value = "shopImg",required = true) MultipartFile file
                                            ){

        Map<String,Object> modelMap = new HashMap<>();
        String verifyCodeExpected = (String)AttributesUtil.getSessionAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(!verifyCodeExpected.toLowerCase().equals(verifyCode)){
            modelMap.put("success",false);
            modelMap.put("errMsg","验证码错误");
            return modelMap;
        }
        Shop shop = JSONObject.parseObject(shopStr,Shop.class);
        if (shop == null){
            modelMap.put("success",false);
            modelMap.put("errMsg","店铺信息填写错误");
            return modelMap;
        }
        //应该从session获取
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1l);
        shop.setOwner(personInfo);

        ShopExecution shopExecution = shopService.addShop(shop, file);
        if (shopExecution==null || shopExecution.getState() != ShopStateEnum.CHECK.getState()){
            modelMap.put("success",false);
            modelMap.put("errMsg","店铺注册错误");
            return modelMap;
        }
        modelMap.put("success",true);
        return  modelMap;
    }



}
