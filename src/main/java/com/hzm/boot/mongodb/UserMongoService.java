package com.hzm.boot.mongodb;

import com.hzm.boot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WXQ on 2016/10/20.
 */
@Service
public class UserMongoService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public User findUser(int userId){
        return userRepository.findById(userId);
    }

}
