package com.wyj.entity.vo;

public class ApiResponse {

    private String msg;
    private int status;
    private Object data;

    public ApiResponse(int status, String msg, Object data) {
        this.msg = msg;
        this.status = status;
        this.data = data;
    }

    public ApiResponse(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public ApiResponse() {
    }

    public static ApiResponse ok() {
        return new ApiResponse(null);
    }

    public static ApiResponse ok(Object object) {
        return new ApiResponse(object);
    }

    public static ApiResponse errorException(String msg) {
        return new ApiResponse(555, msg, null);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

