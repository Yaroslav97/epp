package com.epam.poliakov.util.captcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import static com.epam.poliakov.util.ContextTypeCons.CONTEXT_REGISTRATION_TIME;
import static com.epam.poliakov.util.ContextTypeCons.CONTEXT_TYPE;

@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        long clearTime = 1000 * 10;
        int captchaTime = Integer.parseInt(getServletContext().getInitParameter(CONTEXT_REGISTRATION_TIME)) * 1000;

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(clearTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Map<String, String> map = CaptchaGenerator.getMap();

                    if (!map.isEmpty()) {
                        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
                        while (iterator.hasNext()) {
                            Map.Entry<String, String> entry = iterator.next();

                            long actualCaptchaTime = System.currentTimeMillis() - Long.valueOf(entry.getKey());
                            if (actualCaptchaTime >= captchaTime) {
                                iterator.remove();
                            }
                        }
                    }
                }
            }
        };
        thread.setName("cleaner");
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        CaptchaGenerator captchaGenerator = new CaptchaGenerator(id);
        captchaGenerator.generateCaptcha(resp);

        CaptchaManager captchaManager = new CaptchaManager(req, resp, id);
        captchaManager.typeHandle(getServletContext().getInitParameter(CONTEXT_TYPE));
    }
}
