package com.springcloud.common.captcha.image;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yueli
 * @date 2020/9/14 17:08
 */
@Data
public class ValidateCode {
    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireTime) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
    }

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * 判断时间是否过期
     *
     * @return
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
