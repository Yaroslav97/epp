package com.epam.poliakov.util.avatar;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class UploadImage {

    private static final String IMAGE_NAME = "fileName";
    private static final String DEFAULT_AVATAR = "avatar.jpg";
    private static final String LOGIN = "login";

    public static String upload(HttpServletRequest req, String contextPath) throws IOException, ServletException {

        Part avatar = req.getPart(IMAGE_NAME);
        InputStream inputStream = avatar.getInputStream();
        Image image = ImageIO.read(inputStream);
        if (image == null) {
            return DEFAULT_AVATAR;
        }
        String imageName = req.getParameter(LOGIN) + ".jpg";
        ImageIO.write((RenderedImage) image, "jpg", new File(contextPath + imageName));
        return imageName;
    }
}
