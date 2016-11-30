package com.hzm.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan
public class Application implements EmbeddedServletContainerCustomizer {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);

        logger.info(">>>>>>>>>>>>>>>服务启动执行主程序加载完毕<<<<<<<<<<<<<");
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer config) {
        //test11
        //test22
        //test33
        //test44
        //test55
        //test66
        //test77
    }


}
