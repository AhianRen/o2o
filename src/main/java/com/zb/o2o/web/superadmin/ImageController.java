package com.zb.o2o.web.superadmin;

import com.zb.o2o.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {


    @RequestMapping("/up")
    @ResponseBody
    public String img(@RequestParam("file") MultipartFile file){

       // System.out.println(priority);
        /*String path = "D:/upload/o2o/";
        File file1 = new File(path + file.getOriginalFilename());
        System.out.println(file.getSize());

        try {
            file.transferTo(file1);
            //Files.copy(file.getInputStream(),file1.toPath(),StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        String shopImgPath = FileUtil.getShopImgPath(1);
      //  String s = ImageUtil.generateThumbnail(file, shopImgPath);
        //System.out.println(s);


        return "OK";
    }

    @RequestMapping("/img")
    public String img(){

        return "index";
    }
}
