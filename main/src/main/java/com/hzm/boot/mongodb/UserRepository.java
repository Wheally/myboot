package com.hzm.boot.mongodb;

import com.hzm.boot.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by WXQ on 2016/10/20.
 */
public interface UserRepository extends MongoRepository<User, String> {

    public User findById(int userId);


}
