package com.springcloud.common.captcha.image;

import org.junit.Test;

/**
 * @author yueli
 * @date 2020/9/14 17:34
 */
public class ImageCodeTest {

    @Test
    public void testGeneratorImageCode() {
        ImageCodeGenerator build = new ImageCodeGenerator.Builder().build();
        ImageCode imageCode = (ImageCode) build.generator();
        String base64Image = ImageCodeUtils.getBase64Image(imageCode);
        System.out.println(base64Image);
    }


}
