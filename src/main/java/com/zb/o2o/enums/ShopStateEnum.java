package com.zb.o2o.enums;

public enum ShopStateEnum {

    OFFLINE(-1,"非法商铺"),
    CHECK(0,"审核中"),
    SUCCESS(1,"操作成功"),
    PASS(2,"通过审核"),
    INNER_ERROR(-1001,"操作失败"),
    NULLL_SHOPID(-1002,"shopId为空");


    private final int state;
    private final String stateInfo;

    private ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public ShopStateEnum stateOf(int state){
        for (ShopStateEnum stateEnum : values()){
            if (stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }
}
