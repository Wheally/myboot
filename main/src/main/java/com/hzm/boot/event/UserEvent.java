package com.hzm.boot.event;

import org.springframework.context.ApplicationEvent;

/**
 * 用户事件
 *
 * @author xiaoqian.wen
 * @create 2016-11-24 17:49
 **/
public class UserEvent extends ApplicationEvent{

    private static final long serialVersionUID = 1L;
    private String userId;
    private String userName;

    public UserEvent(Object source, String userId, String userName) {
        super(source);
        this.userId = userId;
        this.userName = userName;
        System.out.println("UserEvent user:"+userId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
