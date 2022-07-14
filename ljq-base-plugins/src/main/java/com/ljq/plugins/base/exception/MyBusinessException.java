package com.ljq.plugins.base.exception;

/**
 * 异常处理类
 */
public class MyBusinessException extends RuntimeException {

    private String msg;
    private Integer httpStatus;
    public MyBusinessException (String message){
        super(message);
        this.msg = message;
    }
    public MyBusinessException (Integer httpStatus, String message){
        super(message);
        this.httpStatus = httpStatus;
        this.msg = message;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }
}
