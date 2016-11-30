package com.hzm.boot.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Spring工具类
 *
 * @author xiaoqian.wen
 * @create 2016-11-08 13:49
 **/
public class SpringUtils implements BeanFactoryPostProcessor {

    // Spring应用上下文环境
    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * 根据名字获取Spring实体bean
     * @param name
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name){
        return (T) beanFactory.getBean(name);
    }

    /**
     * 根据class类型获取Spring实体bean
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> tClass){
        return beanFactory.getBean(tClass);
    }


}
