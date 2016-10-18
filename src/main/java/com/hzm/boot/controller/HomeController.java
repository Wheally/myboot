package com.hzm.boot.controller;

import com.hzm.boot.common.ThreadUtilities;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WXQ on 2016/10/14.
 */
@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @RequestMapping(value = "/wait",method = RequestMethod.GET)
    public String wait(@RequestParam String userId){
        Thread currentThread = Thread.currentThread();
        currentThread.setName("thread-" + userId);
        synchronized(currentThread) {
            try {
                currentThread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Hello World";
    }

    @RequestMapping(value = "/notify",method = RequestMethod.GET)
    public String notify(@RequestParam String userId){
        Thread thread = ThreadUtilities.getThread("thread-"+userId);
        if(thread != null){
            synchronized(thread) {
                thread.notify();
            }
        }
        return "Hello World";
    }
}
