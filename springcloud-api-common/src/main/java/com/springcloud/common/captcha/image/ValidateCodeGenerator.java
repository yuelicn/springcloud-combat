package com.springcloud.common.captcha.image;

/**
 * @author yueli
 * @date 2020/9/14 17:11
 */
public interface ValidateCodeGenerator {
    /**
     * 生成验证码
     *
     * @return
     */
    ValidateCode generator();
}
