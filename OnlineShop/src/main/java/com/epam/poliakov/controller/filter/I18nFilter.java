package com.epam.poliakov.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebFilter(
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "localeType", value = "cookie"),
                @WebInitParam(name = "cookieMaxAge", value = "3600")
        }
)
public class I18nFilter implements Filter {

    private List<String> list;
    private static final String I18N = "i18n";
    public static final String LANG = "lang";
    public static final String COOKIE = "cookie";
    public static final String SESSION = "session";
    private static final String LOCALES = "locales";
    public static final String LOCALE_TYPE = "localeType";
    private static final String COOKIE_MAX_AGE_PARAMETER = "cookieMaxAge";

    private String initParameter;
    private Integer cookieMaxAge;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        initParameter = filterConfig.getInitParameter(LOCALE_TYPE);
        cookieMaxAge = Integer.valueOf(filterConfig.getInitParameter(COOKIE_MAX_AGE_PARAMETER));

        list = new ArrayList<>();
        String[] locales = filterConfig.getServletContext().getInitParameter(LOCALES).split(", ");

        for (String localeName : locales) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle(I18N, new Locale(localeName));
            if (resourceBundle.getString("login") != null) {
                list.add(localeName);
            }
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(req) {
            @Override
            public Locale getLocale() {
                return localeHandle(req, resp);
            }
        };
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {

    }

    private Locale setAvailableLocale(HttpServletRequest req, HttpServletResponse resp) {
        Enumeration<Locale> locales = req.getLocales();
        while (locales.hasMoreElements()) {
            Locale locale = locales.nextElement();
            if (list.contains(locale.toString())) {
                if (initParameter.equals(SESSION)) {
                    req.getSession().setAttribute(LANG, locale);
                } else if (initParameter.equals(COOKIE)) {
                    Cookie cookie = new Cookie(LANG, locale.toString());
                    cookie.setMaxAge(cookieMaxAge);
                    resp.addCookie(cookie);
                }
                return locale;
            }
        }
        return null;
    }

    private Locale setLocaleByParameter(HttpServletRequest req, HttpServletResponse resp) {
        if (initParameter.equals(SESSION)) {
            req.getSession().setAttribute(LANG, req.getParameter(LANG));
        } else if (initParameter.equals(COOKIE)) {
            Cookie cookie = new Cookie(LANG, req.getParameter(LANG));
            cookie.setMaxAge(cookieMaxAge);
            cookie.setValue(req.getParameter(LANG));
            resp.addCookie(cookie);
        }
        return new Locale(req.getParameter(LANG));
    }

    private Locale localeHandle(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getSession().getAttribute(LANG) == null && req.getCookies() == null) {
            return setAvailableLocale(req, resp);
        } else if (req.getParameter(LANG) != null) {
            return setLocaleByParameter(req, resp);
        } else if (req.getSession().getAttribute(LANG) != null) {
            return new Locale((String) req.getSession().getAttribute(LANG));
        } else if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getName().equals(LANG)) {
                    return new Locale(cookie.getValue());
                }
            }
        }
        return null;
    }
}
