package com.hzm.boot.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hzm.boot.demo.IDubboDemoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Dubbo
 *
 * @author xiaoqian.wen
 * @create 2016-11-29 15:38
 **/
@RestController
public class DemoController {

    @Reference
    private IDubboDemoService demoService;

    @RequestMapping("/sayHello/{uname}")
    public String sayHello(@PathVariable String uname){
        return demoService.sayHello(uname);
    }
}
