package com.hzm.boot.event;

import org.springframework.context.ApplicationEvent;

public class OrderEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private int orderId;

    public OrderEvent(Object source, int id) {
        super(source);
        this.orderId = id;
        System.out.println("Order Event Created!!");
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}