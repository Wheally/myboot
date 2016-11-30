package com.hzm.boot.exception;

/**
 * 基类Exception
 *
 * @author xiaoqian.wen
 * @create 2016-11-08 17:40
 **/
public class BaseException extends RuntimeException{

    private String errorCode;
    private String message;

    public BaseException(String errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
