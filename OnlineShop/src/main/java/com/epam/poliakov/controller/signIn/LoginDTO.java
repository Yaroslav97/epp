package com.epam.poliakov.controller.signIn;

import javax.servlet.http.HttpServletRequest;

public class LoginDTO {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    private HttpServletRequest req;

    public LoginDTO(HttpServletRequest req) {
        this.req = req;
    }

    public String getLogin() {
        return req.getParameter(LOGIN);
    }

    public String getPassword() {
        return req.getParameter(PASSWORD);
    }
}
