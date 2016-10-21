package com.hzm.boot.api;

import com.hzm.boot.domain.User;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by wxq-mac on 16/8/14.
 */
public interface HelloAPI {

    @GET("/user/getUser")
    public User getUser(@Query("userId") int userId);




}
