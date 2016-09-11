package com.hzm.boot.common;

import com.hzm.boot.api.HelloAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.RestAdapter;

/**
 * Created by wxq-mac on 16/8/14.
 */
@Configuration
public class HelloAPIConfig {

    @Autowired
    private RestAdapter restAdapter;

    @Bean
    public HelloAPI getHelloAPI(){
        return restAdapter.create(HelloAPI.class);
    }
    
}
