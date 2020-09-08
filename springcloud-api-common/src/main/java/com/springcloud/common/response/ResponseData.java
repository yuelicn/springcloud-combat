package com.springcloud.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yueli
 * @date 2020/9/8 14:37
 */
@Data
public class ResponseData<T> implements Serializable {

    /**
     * 响应编码
     */
    private Integer code = 200;
    /**
     * 响应信息描述
     */
    private String msg = "SUCCESS";

    /**
     * 响应实体
     */
    private T result;

    /**
     * 私有化，禁止外部直接实列化
     */
    private ResponseData() {
    }

    /**
     * @param result 响应实体
     */
    private ResponseData(T result) {
        this.result = result;
    }

    /**
     * @param code 响应编码
     * @param msg  响应编码描述
     */
    private ResponseData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 响应成功实体封装
     * @param result 响应参数
     * @param <T>
     * @return
     */
    public static <T> ResponseData success(T result) {
        return new ResponseData(result);
    }

    /**
     * 响应失败实体封装
     * @param code 编码
     * @param msg 描述
     * @return
     */
    public static ResponseData fail(Integer code, String msg) {
        return new ResponseData(code, msg);
    }
}

