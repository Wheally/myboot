package com.hzm.boot.common;

/**
 * 统一返回结果
 * @param <T>
 */
public class RestResult <T>{
    private String errorCode;
    private String message;
    private T data;

    private RestResult(){}

    protected RestResult(String errorCode, String message, T data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public RestResult setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RestResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public RestResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}