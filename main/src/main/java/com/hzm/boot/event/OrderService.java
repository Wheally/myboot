package com.hzm.boot.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class OrderService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void createOrder(int orderId) {
        System.out.println("Order Created");
        OrderEvent event = new OrderEvent(this, orderId);
        System.out.println("Publishing Order Event");
        publisher.publishEvent(event);
    }

    public void addUser(String userId, String userName){
        UserEvent userEvent = new UserEvent(this, userId, userName);
        publisher.publishEvent(userEvent);
    }
}