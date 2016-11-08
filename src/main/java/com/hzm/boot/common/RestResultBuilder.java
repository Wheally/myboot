package com.hzm.boot.common;

public class RestResultBuilder<T> {

    private String errorCode = ErrorCode.SUCCESS.getCode();
    private String message = ErrorCode.SUCCESS.getMsg();

    private T data ;

    protected RestResultBuilder<T> setErrorCode(String errorCode){
        this.errorCode = errorCode;
        return this;
    }

    public RestResultBuilder<T> setMessage(String message){
        this.message = message;
        return this;
    }

    public RestResultBuilder<T> setData(T data){
        this.data = data;
        return this;
    }

    public RestResult<T> build(){
        return new RestResult<T>(errorCode,message,data);
    }


}