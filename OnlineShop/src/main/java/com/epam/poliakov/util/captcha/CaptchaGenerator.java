package com.epam.poliakov.util.captcha;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CaptchaGenerator {
    private static String id;
    private static Map<String, String> map = new HashMap();

    public CaptchaGenerator(String id) {
        this.id = id;
    }

    public void generateCaptcha(HttpServletResponse resp) throws ServletException, IOException {

        int width = 250;
        int height = 100;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();

        Font font = new Font("Georgia", Font.BOLD, 35);
        g2d.setFont(font);

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(renderingHints);

        GradientPaint paint = new GradientPaint(0, 0, Color.blue, 0, height / 2, Color.black, true);

        g2d.setPaint(paint);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(new Color(255, 246, 248));

        Random random = new Random();

        int x = 0;
        int y = 0;

        map.put(id, String.valueOf(new Random().nextInt(8999) + 1000));

        char[] code = map.get(String.valueOf(id)).toCharArray();

        for (int i = 0; i < code.length; i++) {
            x += 40 + (Math.abs(random.nextInt()) % 15);
            y = 50 + Math.abs(random.nextInt()) % 20;

            g2d.drawChars(map.get(String.valueOf(id)).toCharArray(), i, 1, x, y);
        }

        g2d.dispose();

        resp.setContentType("image/png");
        OutputStream os = resp.getOutputStream();
        ImageIO.write(bufferedImage, "png", os);
        os.close();
    }

    public static boolean isExistValidCaptcha() {
        return !map.isEmpty();
    }

    public static String getCodeById(String id) {
        return map.get(id);
    }

    public static Map<String, String> getMap() {
        return map;
    }
}
