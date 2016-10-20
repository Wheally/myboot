package com.hzm.boot.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @desc 服务启动执行
 * Created by WXQ on 2016/10/19.
 */
@Component
@Order(2)
public class Demo2CommandRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行Demo2<<<<<<<<<<<<<");
    }

}
