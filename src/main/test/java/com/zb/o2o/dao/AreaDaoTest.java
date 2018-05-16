package com.zb.o2o.dao;

import com.zb.o2o.BaseTest;
import com.zb.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaDaoTest extends BaseTest{
    @Autowired
    private AreaDao areaDao;
    @Test
    public void testqueryArea(){
        List<Area> areas = areaDao.queryArea();
        Assert.assertEquals(2,areas.size());
    }
}
