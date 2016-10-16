package com.hzm.boot.service;

import com.hzm.boot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wxq-mac on 16/6/22.
 */
@Service
public class UserService {

    private AtomicLong count = new AtomicLong();

    @Autowired
    private User user;

    public User getUser(){
        return user;
    }
}
