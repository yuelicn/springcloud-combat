package com.springcloud.common.captcha.image;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author yueli
 * @date 2020/9/14 17:10
 */
@Data
public class ImageCode extends ValidateCode {
    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireTime) {
        super(code, expireTime);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }
}
