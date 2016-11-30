package com.hzm.boot.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info(">>>>>>>>>>>>>>>服务启动执行Demo2<<<<<<<<<<<<<");
    }

}
