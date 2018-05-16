package com.zb.o2o.service;

import com.zb.o2o.BaseTest;
import com.zb.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Test
    public void testgetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        Assert.assertEquals("西区",areaList.get(0).getAreaName());
    }
}
