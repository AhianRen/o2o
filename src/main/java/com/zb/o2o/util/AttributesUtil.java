package com.zb.o2o.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AttributesUtil{

    /**
     * 获取Request
     * @return
     */
    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes() ).getRequest();

    }

    /**
     * 获取Response
     * @return
     */
    public static HttpServletResponse getResponse(){
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();

    }

    /**
     * 获取Session中key对应的值
     * @param key
     * @return
     */
    public static Object getSessionAttribute(String key){
        return RequestContextHolder.currentRequestAttributes().getAttribute(key,RequestAttributes.SCOPE_SESSION);

    }

}
