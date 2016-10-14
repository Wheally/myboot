package com.hzm.boot.controller;

import com.hzm.boot.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by WXQ on 2016/10/14.
 */
@RestController
public class HomeController {

    private AtomicLong count = new AtomicLong();

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        System.out.println("hello:111");

        while(count.get() < 10000000000000L){
            count.addAndGet(1);
        }

        System.out.println("hello:222");
        return "Hello World";
    }
}
