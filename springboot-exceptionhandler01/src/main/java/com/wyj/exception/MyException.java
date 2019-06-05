package com.wyj.exception;

/**
 * 自定义异常
 *
 * @author wyj
 * @date 2019-05-27 11:00
 */
public class MyException extends Exception {

    private String code;
    private String msg;

    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public MyException(String code, String msg) {
        super(code);
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
