package com.zb.o2o.web.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/shop")
public class AdminController {
    @RequestMapping(value = "/shopedit",method = RequestMethod.GET)
    public String shopEdit(){
        return "/shop/shopedit";
    }






}
