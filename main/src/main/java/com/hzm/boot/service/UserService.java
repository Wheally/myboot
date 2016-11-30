package com.hzm.boot.service;

import com.hzm.boot.domain.User;
import com.hzm.boot.jdbc.UserDao;
import com.hzm.boot.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wxq-mac on 16/6/22.
 */
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private AtomicLong count = new AtomicLong();

    @Autowired
    private User user;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDao userDao;

    /*@Cacheable(value = "user", key = "'user-'+#userId")
    @Caching(cacheable = {
            @Cacheable(value = "user", key = "'user-'+#user.getName()")
    })*/
    public User getUser(int userId){
        logger.info("无缓存的时候调用这里");
        //使用mybatis查询
        //return userMapper.findUserById(userId);
        return userDao.getUserById(userId);
    }

    @CachePut(value = "user", key = "'user-'+#userId")
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
