package com.hzm.boot.service;

import com.hzm.boot.domain.User;
import com.hzm.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wxq-mac on 16/6/22.
 */
@Service
public class UserService {

    private AtomicLong count = new AtomicLong();

    @Autowired
    private User user;
    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "user", key = "'user-'+#userId")
    public User getUser(int userId){
        System.out.println("无缓存的时候调用这里");
        return user;
    }

    public User findUser(int userId){
        return userMapper.findUserById(userId);
    }

    @Transactional
    public int saveUser(User user){
        return userMapper.insertUser(user.getName(), user.getPassword());
    }

    @Transactional
    public int saveUserBackId(User user){
        return userMapper.insertUserWithBackId(user);
    }


}
