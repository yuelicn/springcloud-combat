package com.springcloud.common.captcha.image;


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author yueli
 * @date 2020/9/14 17:12
 */
public class ImageCodeGenerator implements ValidateCodeGenerator {


    private int width = 200;

    private int height = 80;

    private int length = 4;

    private int expireIn = 60;

    private String url;

    private static Random random = new Random();
    /**
     * 图片验证码池
     */
    public static final String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";

    public ImageCodeGenerator(Builder builder) {
        this.width = builder.width;
        this.height = builder.height;
        this.length = builder.length;
        this.expireIn = builder.expireIn;
        this.url = builder.url;
    }

    @Override
    public ValidateCode generator() {
        // 设置图片大小
        int width = this.width;
        int height = this.height;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Random random = new Random();

        Graphics2D g = image.createGraphics();
        // 设置边框色
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);

        // 设置背景
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);

        // 绘制干扰线
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int x1 = random.nextInt(6) + 1;
            int y1 = random.nextInt(12) + 1;
            g.drawLine(x, y, x + x1 + 40, y + y1 + 20);
        }

        // 添加噪点
        float yawpRate = 0.05f;// 噪声率
        int area = (int) (yawpRate * width * height);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int rgb = getRandomIntColor();
            image.setRGB(x, y, rgb);
        }

        // 使图片扭曲
        shear(g, width, height, getRandColor(200, 250));

        //设置字体
        g.setColor(getRandColor(100, 160));
        int fontSize = height - 4;
        Font font = new Font("Algerian", Font.ITALIC, fontSize);
        g.setFont(font);

        int verifySize = this.length;
        String verifyCode = generateVerifyCode(verifySize);
        char[] chars = verifyCode.toCharArray();
        for (int i = 0; i < verifySize; i++) {
            AffineTransform affine = new AffineTransform();
            affine.setToRotation(Math.PI / 4 * random.nextDouble() * (random.nextBoolean() ? 1 : -1),
                    (width / verifySize) * i + fontSize / 2, height / 2);
            g.setTransform(affine);
            g.drawChars(chars, i, 1, ((width - 10) / verifySize) * i + 5, height / 2 + fontSize / 2 - 10);
        }

        g.dispose();
        return new ImageCode(image, verifyCode, this.expireIn);
    }

    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    private static int getRandomIntColor() {
        int[] rgb = getRandomRgb();
        int color = 0;
        for (int c : rgb) {
            color = color << 8;
            color = color | c;
        }
        return color;
    }

    private static int[] getRandomRgb() {
        int[] rgb = new int[3];
        for (int i = 0; i < 3; i++) {
            rgb[i] = random.nextInt(255);
        }
        return rgb;
    }

    private static void shear(Graphics g, int w1, int h1, Color color) {
        shearX(g, w1, h1, color);
        shearY(g, w1, h1, color);
    }

    private static void shearX(Graphics g, int w1, int h1, Color color) {

        int period = random.nextInt(2);

        boolean borderGap = true;
        int frames = 1;
        int phase = random.nextInt(2);

        for (int i = 0; i < h1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period + (6.2831853071795862D * (double) phase) / (double) frames);
            g.copyArea(0, i, w1, 1, (int) d, 0);
            if (borderGap) {
                g.setColor(color);
                g.drawLine((int) d, i, 0, i);
                g.drawLine((int) d + w1, i, w1, i);
            }
        }

    }

    private static void shearY(Graphics g, int w1, int h1, Color color) {

        int period = random.nextInt(40) + 10; // 50;

        boolean borderGap = true;
        int frames = 20;
        int phase = 7;
        for (int i = 0; i < w1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period + (6.2831853071795862D * (double) phase) / (double) frames);
            g.copyArea(i, 0, 1, h1, 0, (int) d);
            if (borderGap) {
                g.setColor(color);
                g.drawLine(i, (int) d, i, 0);
                g.drawLine(i, (int) d + h1, i, h1);
            }

        }

    }

    /**
     * 使用系统默认字符源生成验证码
     *
     * @param verifySize 验证码长度
     * @return
     */
    public static String generateVerifyCode(int verifySize) {
        return generateVerifyCode(verifySize, VERIFY_CODES);
    }

    /**
     * 使用指定源生成验证码
     *
     * @param verifySize 验证码长度
     * @param sources    验证码字符源
     * @return
     */
    public static String generateVerifyCode(int verifySize, String sources) {
        if (sources == null || sources.length() == 0) {
            sources = VERIFY_CODES;
        }
        int codesLen = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for (int i = 0; i < verifySize; i++) {
            verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
        }
        return verifyCode.toString();
    }

    public static class Builder {
        private int width = 200;

        private int height = 80;

        private int length = 4;

        private int expireIn = 60;

        private String url;

        public Builder() {
            this.width = 200;
            this.height = 80;
            this.length = 4;
            this.expireIn = 60;
            this.url = null;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder length(int length) {
            this.length = length;
            return this;
        }

        public Builder expireIn(int expireIn) {
            this.expireIn = expireIn;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public ImageCodeGenerator build() {
            return new ImageCodeGenerator(this);
        }

    }


}
