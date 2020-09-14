package com.springcloud.common.captcha.image;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author yueli
 * @date 2020/9/14 17:39
 */
@Slf4j
public class ImageCodeUtils {
    public static String BASE64_IMAGE_PREFIX = "data:image/jpg;base64,";

    public static String getBase64Image(ImageCode imageCode) {
        // io流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(imageCode.getImage(), "JPG", baos);
        } catch (IOException e) {
            log.error("[获取图片验证码]-ImageIO.write转换异常：{}", e);
            return null;
        }
        // 转换成字节
        byte[] bytes = baos.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        // 转换成base64串
        String png_base64 = encoder.encodeBuffer(bytes).trim();
        // 删除 \r\n
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");
        return BASE64_IMAGE_PREFIX + png_base64;
    }
}
