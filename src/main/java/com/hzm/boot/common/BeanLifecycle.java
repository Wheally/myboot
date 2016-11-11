package com.hzm.boot.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Bean生命周打印
 *
 * @author xiaoqian.wen
 * @create 2016-11-09 10:53
 **/
@Component
public class BeanLifecycle implements InitializingBean,Lifecycle,ApplicationContextAware, DisposableBean {

    private final Logger LOGGER = LoggerFactory.getLogger(BeanLifecycle.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.debug("BeanLifecycle InitializingBean.afterPropertiesSet正在被实例化");
    }

    @Override
    public void start() {
        LOGGER.debug("BeanLifecycle Lifecycle.start 初始化前打印");
    }

    @Override
    public void stop() {
        LOGGER.debug("BeanLifecycle Lifecycle.stop初始化完成后打印");
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @PostConstruct
    public void postConstrutor(){
        LOGGER.debug("BeanLifecycle postConstrutor初始化前打印");
    }

    @PreDestroy
    public void predestroy(){
        LOGGER.debug("BeanLifecycle predestroy 销毁前打印");
    }

    @Override
    public void destroy() throws Exception {
        LOGGER.debug("BeanLifecycle DisposableBean.destroy 销毁前打印");
    }
}
