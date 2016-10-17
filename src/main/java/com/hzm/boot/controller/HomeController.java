package com.hzm.boot.controller;

import com.hzm.boot.domain.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by WXQ on 2016/10/14.
 */
@RestController
public class HomeController {

    private static Map<String,Thread> threadMap = new ConcurrentHashMap<String, Thread>();

    private AtomicLong count = new AtomicLong();

    @RequestMapping(value = "/wait",method = RequestMethod.GET)
    public String wait(@PathVariable String userId){
        Thread currentThread = Thread.currentThread();
        threadMap.put(userId, currentThread);
        try {
            currentThread.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello World";
    }

    @RequestMapping(value = "/notify",method = RequestMethod.GET)
    public String notify(@PathVariable String userId){

        threadMap.get(userId).notify();
        return "Hello World";
    }
}
