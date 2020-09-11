package com.springcloud.common.exception;

/**
 * 定义业务异常
 *
 * @author yueli
 * @date 2020/9/11 15:24
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String errorCode;

    public BizException() {
    }

    public BizException(Throwable ex) {
        super(ex);
    }

    public BizException(int errorCode) {
        this.errorCode = String.valueOf(errorCode);
    }

    public BizException(String errorCode) {
        this.errorCode = errorCode;
    }

    public BizException(int errorCode, String msg) {
        super(msg);
        this.errorCode = String.valueOf(errorCode);
    }


    public BizException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public BizException(int errorCode, Throwable ex) {
        super(ex);
        this.errorCode = String.valueOf(errorCode);
    }

    public BizException(String errorCode, Throwable ex) {
        super(ex);
        this.errorCode = errorCode;
    }

    public BizException(int errorCode, String msg, Throwable ex) {
        super(msg, ex);
        this.errorCode = String.valueOf(errorCode);
    }

    public int getErrorCode() {
        return Integer.parseInt(this.errorCode);
    }

    public String getErrorCodeStr() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = String.valueOf(errorCode);
    }
}
