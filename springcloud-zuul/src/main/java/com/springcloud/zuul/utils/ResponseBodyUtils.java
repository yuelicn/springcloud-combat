package com.springcloud.zuul.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author yueli
 * @date 2020/9/10 16:20
 */
public class ResponseBodyUtils {
    public static String tokenIsNull() {
        JSONObject result = new JSONObject();
        result.put("errorCode", "000001");
        result.put("errorMsg", "no permissions");
        result.put("result", null);
        return result.toJSONString();
    }

    public static String filterError() {
        JSONObject result = new JSONObject();
        result.put("errorCode", "000002");
        result.put("errorMsg", "系统异常");
        result.put("result", null);
        return result.toJSONString();
    }

    public static String fallBack() {
        JSONObject result = new JSONObject();
        result.put("errorCode", "0000003");
        result.put("errorMsg", "服务不可用");
        result.put("result", null);
        return result.toJSONString();
    }
}
