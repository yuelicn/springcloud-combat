package com.springcloud.common.utils;

/**
 * 正则校验
 * @author yueli
 * @date 2020/9/11 15:29
 */
public class PatternUtils {
    public static final String PHONE = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|" +
            "(19[89]))\\d{8})$";

    public static final String ID_NUMBER = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])" +
            "|10|20|30|31)\\d{3}[0-9Xx]$";
}
