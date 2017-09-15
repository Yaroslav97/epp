package com.epam.poliakov.util.captcha;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.poliakov.util.ContextTypeCons.*;

public class CaptchaManager {

    private HttpServletRequest req;
    private HttpServletResponse resp;
    private String id;

    public CaptchaManager(HttpServletRequest req, HttpServletResponse resp, String id) {
        this.req = req;
        this.resp = resp;
        this.id = id;
    }

    public void typeHandle(String type) {
        if (type.equals(CONTEXT_TYPE_SESSION)) {
            req.getSession().setAttribute(CONTEXT_CAPTCHA, id);
        } else if (type.equals(CONTEXT_TYPE_COOKIES)) {
            Cookie cookie = new Cookie(CONTEXT_CAPTCHA, String.valueOf(id));
            resp.addCookie(cookie);
        }
    }
}
