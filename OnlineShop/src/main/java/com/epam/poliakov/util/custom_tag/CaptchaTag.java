package com.epam.poliakov.util.custom_tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CaptchaTag extends SimpleTagSupport {

    private long CAPTCHA_ID = System.currentTimeMillis();

    private String getCaptchaPNG() {
        return "<img src=\"/OnlineShop/captcha?id=" + CAPTCHA_ID + "\">";
    }

    private String getHidden() {
        return "<input type=\"hidden\" name=\"captchaID\" value=\"" + CAPTCHA_ID + "\">\n";
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write(getCaptchaPNG() + getHidden());
    }
}
