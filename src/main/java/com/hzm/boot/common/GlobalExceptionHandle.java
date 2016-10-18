package com.hzm.boot.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc springboot全局异常处理
 * Created by WXQ on 2016/10/18.
 */
@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String defaultErrorHandle(HttpServletRequest request, Exception ex){
        ex.printStackTrace();
        System.out.println("GlobalExceptionHandle.defaultErrorHandle()");

        return "GlobalExceptionHandle.defaultErrorHandle()";
    }


}
