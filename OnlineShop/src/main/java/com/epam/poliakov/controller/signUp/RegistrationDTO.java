package com.epam.poliakov.controller.signUp;

import javax.servlet.http.HttpServletRequest;

import java.util.Locale;

public class RegistrationDTO {

    private HttpServletRequest req;

    public RegistrationDTO(HttpServletRequest req) {
        this.req = req;
    }

    public String getFirstName() {
        return req.getParameter("firstname");
    }

    public String getLastName() {
        return req.getParameter("lastname");
    }

    public String getLogin() {
        return req.getParameter("login");
    }

    public String getEmail() {
        return req.getParameter("email");
    }

    public String getPassword() {
        return req.getParameter("password");
    }

    public String getConfirmPassword() {
        return req.getParameter("password_conf");
    }

    public Locale getLocale() {
        return req.getLocale();
    }
}
