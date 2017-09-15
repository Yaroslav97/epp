package com.epam.poliakov.util.captcha;

import javax.servlet.http.HttpServletRequest;

import static com.epam.poliakov.controller.JSPCons.REGISTER_JSP;
import static com.epam.poliakov.util.ContextTypeCons.*;

public class CaptchaValidate {

    private String CAPTCHA_CODE = "captchaCode";
    private HttpServletRequest req;

    public CaptchaValidate(HttpServletRequest req) {
        this.req = req;
    }

    public boolean getParameter(String type) {
        if (!CaptchaGenerator.isExistValidCaptcha()) {
            req.setAttribute("timeOver", "Captcha is not valid");
            req.getRequestDispatcher(REGISTER_JSP);
        } else if (type.equals(CONTEXT_TYPE_HIDDEN)) {
            return CaptchaGenerator.getCodeById(String.valueOf(req.getParameter("captchaID"))).equals(req.getParameter(CAPTCHA_CODE));
        } else if (type.equals(CONTEXT_TYPE_SESSION)) {
            return CaptchaGenerator.getCodeById(String.valueOf(req.getSession().getAttribute("captcha"))).equals(req.getParameter(CAPTCHA_CODE));
        } else if (type.equals(CONTEXT_TYPE_COOKIES)) {
            return CaptchaGenerator.getCodeById(req.getCookies()[1].getValue()).equals(req.getParameter(CAPTCHA_CODE));
        }
        return false;
    }
}
