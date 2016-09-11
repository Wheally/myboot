package com.hzm.boot.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.RestAdapter;

@Configuration
public class RestAdapterConfig {

    /**
     * 获取RestAdapter
     * @return
     */
    @Bean
    public RestAdapter getRestAdapter(){
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://localhost:9090").build();

        return adapter;
    }

}
