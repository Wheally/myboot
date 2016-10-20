package com.hzm.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * springboot + thymeleaf
 * @author Created by WXQ on 2016/10/18.
 */

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "world") String name,
                           Model model, HttpServletRequest request) {

        name = (String) request.getSession().getAttribute("hello");
        model.addAttribute("xname", name);
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
    @RequestMapping("/exception")
    public int zeroException(){
        return 100/0;
    }


}
