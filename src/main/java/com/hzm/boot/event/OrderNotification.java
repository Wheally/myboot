package com.hzm.boot.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderNotification {

    private int notificationId;

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    @EventListener
    public void processOrderEvent(OrderEvent event) {
        System.out.println("OrderEvent for Order Id : " + event.getOrderId());
    }

    @EventListener(classes = UserEvent.class)
    public void processUserEvent(UserEvent event){
        System.out.println("UserEvent for userId:" + event.getUserId() + " userName:"+event.getUserName());
    }
}