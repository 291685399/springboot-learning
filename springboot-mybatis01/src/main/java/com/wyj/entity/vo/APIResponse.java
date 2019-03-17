package com.wyj.entity.vo;

import java.io.Serializable;

/**
 * @author wyj
 * @create 2019-03-17 22:41
 */
public class APIResponse implements Serializable {

    private String msg;
    private Object data;

    public APIResponse() {
    }

    public APIResponse(Object data) {
        this.data = data;
    }

    public APIResponse(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public static APIResponse success(Object date) {
        return new APIResponse(date);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
