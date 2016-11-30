package com.hzm.boot.exception;

public class StatusSuccess extends Exception{
    private static String msg = "操作成功";
    private Object data;
    public StatusSuccess(){
        super(msg);
    }

    public StatusSuccess(String msg) {
        super(msg);
    }

    public StatusSuccess(Object data) {
        super(msg);
        this.data = data;
    }

    public StatusSuccess(String message, Object data) {
        super(message);
        this.data = data;
    }

    public static String getMsg() {
        return msg;
    }

    public static void setMsg(String msg) {
        StatusSuccess.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}