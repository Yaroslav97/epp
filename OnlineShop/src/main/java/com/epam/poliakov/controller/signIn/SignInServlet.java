package com.epam.poliakov.controller.signIn;

import com.epam.poliakov.DAO.entity.Ban;
import com.epam.poliakov.DAO.entity.User;
import com.epam.poliakov.DAO.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.epam.poliakov.controller.JSPCons.*;
import static com.epam.poliakov.controller.SessionAttributeCons.*;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    private static final String ERROR_PASS = "errorPass";
    private static final String ERROR_LOGIN = "errorLogin";
    private static final int BAN_TIME = 1000 * 60 * 5;
    private static final int AVAILABLE_LOGIN_COUNT = 3;

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginDTO dto = new LoginDTO(req);

        if (userService.isExistUser(dto.getLogin()) && userService.isLogin(dto.getLogin(), dto.getPassword()) && !userService.getUser(dto.getLogin()).getBan()) {
            req.getSession().setAttribute(SESSION_LOGIN, userService.getUser(dto.getLogin()).getLogin());
            req.getSession().setAttribute(SESSION_ROLE, userService.getUser(dto.getLogin()).getRole());
            req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
        } else if (userService.getUser(dto.getLogin()).getBan() && new Date().getTime() >= (userService.getUser(dto.getLogin()).getFailedDate() + BAN_TIME)) {
            userService.updateUser(new Ban(dto.getLogin(), false, 0, new Date().getTime()));
            req.setAttribute(ERROR_PASS, "You unblocked");
            req.getRequestDispatcher(ACCOUNT_JSP).forward(req, resp);
        } else if (userService.getUser(dto.getLogin()).getBan()) {
            req.setAttribute(ERROR_PASS, "Your account is ban. You'll unblocked at " + new Date(userService.getUser(dto.getLogin()).getFailedDate() + BAN_TIME));
            req.getRequestDispatcher(ACCOUNT_JSP).forward(req, resp);
        } else if (userService.isExistUser(dto.getLogin()) && !userService.isLogin(dto.getLogin(), dto.getPassword())) {
            User user = userService.getUser(dto.getLogin());
            if (user.getCountFailedLogin() <= AVAILABLE_LOGIN_COUNT) {
                userService.updateUser(new Ban(user.getLogin(), user.getBan(), user.getCountFailedLogin() + 1, new Date().getTime()));
                req.setAttribute(ERROR_PASS, "Wrong password");
            } else if (user.getCountFailedLogin() >= AVAILABLE_LOGIN_COUNT) {
                userService.updateUser(new Ban(user.getLogin(), true, user.getCountFailedLogin(), new Date().getTime()));
                req.setAttribute(ERROR_PASS, "Your account is ban. You'll unblocked at " + new Date(user.getFailedDate() + BAN_TIME));
            }
            req.getRequestDispatcher(ACCOUNT_JSP).forward(req, resp);
        } else if (!userService.isExistUser(dto.getLogin())) {
            req.setAttribute(ERROR_LOGIN, "Login is not exists");
            req.getRequestDispatcher(ACCOUNT_JSP).forward(req, resp);
        }
    }
}
