package com.zb.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class ImageUtil {
    public static String generateThumbnail(MultipartFile file,String path) throws Exception{
        makeDir(path);
        String extension = getFileExtension(file.getOriginalFilename());
        String relativePath = path + FileUtil.getRandomFileName() + extension;
        String realPath = FileUtil.getImgBasePath() + relativePath;
        try {
            Thumbnails.of(file.getInputStream()).size(200,200).outputQuality(0.25f).toFile(realPath);
        } catch (IOException e) {
            throw new RuntimeException("创建缩略图失败" + e.toString());
        }
        return relativePath;
    }



    public static String getFileExtension(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static void makeDir(String path){
        String realPath = FileUtil.getImgBasePath() + path;
        File filePath = new File(realPath);
        if (!filePath.exists()){
            filePath.mkdirs();
        }
    }








}


