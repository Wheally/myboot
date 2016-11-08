package com.hzm.boot.common;

/**
 * Created by WXQ on 2016/11/8.
 */
public enum ErrorCode {

    SUCCESS("10000","操作成功"),
    ERROR("20000","操作失败"),
    ERROR_METHOD("20001", "参数非法"),
    EXPIRED("20002", "操作超时");

    private String code;
    private String msg;

    private ErrorCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


