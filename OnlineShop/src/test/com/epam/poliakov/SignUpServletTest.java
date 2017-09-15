package com.epam.poliakov;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import java.util.Map;
import javax.servlet.http.*;

import com.epam.poliakov.controller.signUp.RegistrationDTO;
import com.epam.poliakov.util.validation.UserSignUpValidator;
import com.epam.poliakov.util.validation.Validator;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mock;

public class SignUpServletTest {

    private static final String FIRST_NAME = "firstname";
    private static final String LAST_NAME = "lastname";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String PASSWORD_CONF = "password_conf";

    private static final String WRONG_FIRST_NAME = "235433333333325434";
    private static final String WRONG_LAST_NAME = "Pol23523l";

    @Mock
    private HttpServletRequest req = null;

    @After
    private void verifyRequest(){
        verify(req).getParameter(FIRST_NAME);
        verify(req).getParameter(PASSWORD_CONF);
        verify(req).getParameter(LOGIN);
        verify(req).getParameter(EMAIL);
        verify(req, atLeast(2)).getParameter(PASSWORD);
        verify(req).getParameter(PASSWORD_CONF);
    }

    @Test
    public void testShouldReturnTrueIfDataIsValid() throws Exception {
        req = mock(HttpServletRequest.class);

        when(req.getParameter(FIRST_NAME)).thenReturn("Yaroslav");
        when(req.getParameter(LAST_NAME)).thenReturn("Poll");
        when(req.getParameter(LOGIN)).thenReturn("yaroslav");
        when(req.getParameter(EMAIL)).thenReturn("smith@org.com");
        when(req.getParameter(PASSWORD)).thenReturn("secret");
        when(req.getParameter(PASSWORD_CONF)).thenReturn("secret");

        Validator validator = new UserSignUpValidator();
        Map<String, String> errors = validator.validate(new RegistrationDTO(req));

        assertTrue(errors.isEmpty());
    }

    @Test
    public void testShouldReturnFalseIfDataIsNotValid() throws Exception {
        HttpServletRequest req = mock(HttpServletRequest.class);

        when(req.getParameter(FIRST_NAME)).thenReturn(WRONG_FIRST_NAME);
        when(req.getParameter(LAST_NAME)).thenReturn(WRONG_LAST_NAME);
        when(req.getParameter(LOGIN)).thenReturn("yaroslav");
        when(req.getParameter(EMAIL)).thenReturn("yaroslav@epam.com");
        when(req.getParameter(PASSWORD)).thenReturn("secret");
        when(req.getParameter(PASSWORD_CONF)).thenReturn("secret");

        Validator validator = new UserSignUpValidator();
        Map<String, String> errors = validator.validate(new RegistrationDTO(req));

        assertFalse(errors.isEmpty());
    }
}
