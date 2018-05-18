package com.zb.o2o.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FileUtil {
    private static String seperator = System.getProperty("file.separator");
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random = new Random();

    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/upload/o2o/";
        }else {
            basePath = "/home/upload/o2o/";
        }
        return basePath.replace("/",seperator);
    }

    public static String getShopImgPath(long shopId){
        String path = "/shop/" + shopId +"/";
        return path.replace("/",seperator);
    }

    public static String getRandomFileName(){
        return sDateFormat.format(new Date()) + (random.nextInt(89999) + 10000);
    }







}
