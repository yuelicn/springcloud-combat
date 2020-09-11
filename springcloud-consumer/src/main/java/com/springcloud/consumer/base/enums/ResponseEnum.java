package com.springcloud.consumer.base.enums;

import org.springframework.web.bind.MissingServletRequestParameterException;

import javax.validation.ConstraintViolationException;

/**
 * @author yueli
 * @date 2020/9/11 16:37
 */
public enum ResponseEnum {

    UNKNOWN_EXCEPTION(10500, "未知异常"),
    NULL_POINTER_EXCEPTION(40040, "空指针异常"),
    CONSTRAINT_VIOLATION_EXCEPTION(40041, "参数检验失败"),
    MISSING_REQUEST_PARAMETER_EXCEPTION(40042, "确实必填参数"),
    HTTPCLIENT_ERROR_EXCEPTION(40043, "HTTPCLIENT异常"),
    REMOTE_HTTP_ERROR(40044, "基础服务升级中……,请稍后再试"),
    INVALID_FORMAT_EXCEPTION(40045, "请求序列化异常")
    ;


    private Integer code;

    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
