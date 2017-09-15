package com.epam.poliakov.controller.signUp;

import com.epam.poliakov.DAO.service.UserService;
import com.epam.poliakov.util.avatar.UploadImage;
import com.epam.poliakov.util.captcha.CaptchaValidate;
import com.epam.poliakov.DAO.entity.User;
import com.epam.poliakov.util.validation.UserSignUpValidator;
import com.epam.poliakov.util.validation.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.epam.poliakov.controller.JSPCons.*;
import static com.epam.poliakov.controller.SessionAttributeCons.*;
import static com.epam.poliakov.util.ContextTypeCons.CONTEXT_AVATAR_PATH;
import static com.epam.poliakov.util.ContextTypeCons.CONTEXT_REGISTRATION_TIME;
import static com.epam.poliakov.util.ContextTypeCons.CONTEXT_TYPE;

@WebServlet("/signUp")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,    // 10 MB
        maxFileSize = 1024 * 1024 * 50,        // 50 MB
        maxRequestSize = 1024 * 1024 * 100)    // 100 MB
public class SignUpServlet extends HttpServlet {

    private static final String OLD_PARAM = "oldParam";
    private static final String LOGIN_EXIST = "loginExist";
    private static final String ERROR = "error";
    private static final String INCORRECT_CAPTCHA = "captchaIncorrect";
    private static final String TIME_OVER = "timeOver";
    private long startTime;

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        startTime = System.currentTimeMillis();
        req.getRequestDispatcher(REGISTER_JSP).forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RegistrationDTO dto = new RegistrationDTO(req);
        Validator validator = new UserSignUpValidator();
        Map<String, String> validationErrors = validator.validate(dto);
        CaptchaValidate captchaValidate = new CaptchaValidate(req);

        String contextType = getServletContext().getInitParameter(CONTEXT_TYPE);
        String contextImagePath = getServletContext().getInitParameter(CONTEXT_AVATAR_PATH);
        int contextTime = Integer.parseInt(getServletContext().getInitParameter(CONTEXT_REGISTRATION_TIME));
        boolean isValidTime = RegistrationTimer.isValidRegistrationTime(startTime, contextTime);

        if (validationErrors.isEmpty() && !userService.isExistUser(dto.getLogin()) && captchaValidate.getParameter(contextType) && isValidTime) {
            String imagePath = UploadImage.upload(req, contextImagePath);
            userService.registrationUser(new User(dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getEmail(), dto.getPassword(), imagePath, "user"));
            req.getSession().setAttribute(SESSION_LOGIN, dto.getLogin());
            req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
        } else if (validationErrors.isEmpty() && userService.isExistUser(dto.getLogin()) && isValidTime) {
            req.setAttribute(OLD_PARAM, dto);
            req.setAttribute(LOGIN_EXIST, "Login already exists");
            req.getRequestDispatcher(REGISTER_JSP).forward(req, resp);
        } else if (!captchaValidate.getParameter(contextType) && isValidTime) {
            req.setAttribute(OLD_PARAM, dto);
            req.setAttribute(ERROR, validationErrors);
            req.setAttribute(INCORRECT_CAPTCHA, "Incorrect code");
            req.getRequestDispatcher(REGISTER_JSP).forward(req, resp);
        } else if (!isValidTime) {
            req.setAttribute(TIME_OVER, "Time for registration is over");
            doGet(req, resp);
        } else {
            req.setAttribute(ERROR, validationErrors);
            req.setAttribute(OLD_PARAM, dto);
            req.getRequestDispatcher(REGISTER_JSP).forward(req, resp);
        }
    }
}
