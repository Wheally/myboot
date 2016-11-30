package com.hzm.boot.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.hzm.boot.demo.IDubboDemoService;

@Service
public class DubboDemoServiceImpl implements IDubboDemoService {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public String sayYourAge(int age) {
        return null;
    }

}