package com.zb.o2o.dto;

import com.zb.o2o.entity.Shop;
import com.zb.o2o.enums.ShopStateEnum;

import java.util.List;

public class ShopExecution {

    private int state;
    private String stateInfo;
    private int count;
    private Shop shop;
    private List<Shop> shopList;

    public ShopExecution() {
    }

    public ShopExecution(ShopStateEnum stateEnum){
        state = stateEnum.getState();
        stateInfo = stateEnum.getStateInfo();
    }
    public ShopExecution(ShopStateEnum stateEnum,Shop shop){
        state = stateEnum.getState();
        stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }
    public ShopExecution(ShopStateEnum stateEnum,List<Shop> shopList){
        state = stateEnum.getState();
        stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
