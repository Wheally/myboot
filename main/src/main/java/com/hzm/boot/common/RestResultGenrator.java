package com.hzm.boot.common;

public class RestResultGenrator {

    public static <T> RestResult<T> build(){
        return build(null);
    }

    public static <T> RestResult<T> build(T t){
        return new RestResultBuilder<T>().setData(t).build();
    }
}