package com.hzm.boot.controller;

import com.hzm.boot.exception.BaseException;
import com.hzm.boot.exception.ShopStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * springboot + thymeleaf
 * @author Created by WXQ on 2016/10/18.
 */

@Controller
@RequestMapping("/index")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 问候
     * @param name  用户姓名
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "world") String name,
                           Model model, HttpServletRequest request) {

        model.addAttribute("xname", name + " ---fff");
        logger.info("xname:"+name);
        return "index";
    }


    @ResponseBody
    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public String ajax(@RequestParam("username") String username) {
        return username;
    }


    /**
     * 测试全局异常处理
     * @return
     */
    @ApiIgnore
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public int zeroException(@RequestParam int param) throws BaseException{

        if(param == 1){
            throw new ShopStatusException("10002", "操作超时");
        }

        return 100/0;
    }


}
