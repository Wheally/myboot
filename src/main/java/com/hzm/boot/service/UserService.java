package com.hzm.boot.service;

import com.hzm.boot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wxq-mac on 16/6/22.
 */
@Service
public class UserService {
    @Autowired
    private User user;

    public User getUser(){
        return user;
    }
}
