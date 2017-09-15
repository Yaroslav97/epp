package com.epam.poliakov;

import com.epam.poliakov.util.validation.SignUpValidator;
import com.epam.poliakov.util.validation.UserSignUpValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpValidatorTest {

    private SignUpValidator signUpValidator;

    @Before
    public void init() {
        signUpValidator = new UserSignUpValidator();
    }

    @Test
    public void testShouldReturnTrueIfFirstNameIsValid() throws Exception {
        assertTrue(signUpValidator.firstName("John"));
    }

    @Test
    public void testShouldReturnFalseIfFirstNameIsShort() throws Exception {
        assertFalse(signUpValidator.firstName("Dd"));
    }

    @Test
    public void testShouldReturnFalseIfFirstNameIsNotValid() throws Exception {
        assertFalse(signUpValidator.firstName("@J3252ohn"));
    }

    @Test
    public void testShouldReturnTrueIfLastNameIsValid() throws Exception {
        assertTrue(signUpValidator.lastName("Smith"));
    }

    @Test
    public void testShouldReturnTrueIfLoginIsValid() throws Exception {
        assertTrue(signUpValidator.login("lFgin11"));
    }

    @Test
    public void testShouldReturnFalseIfLoginIsNotValid() throws Exception {
        assertFalse(signUpValidator.login("+_gdfgh+_+_+_"));
    }

    @Test
    public void testShouldReturnFalseIfLoginIsShort() throws Exception {
        assertFalse(signUpValidator.login("sd"));
    }

    @Test
    public void testShouldReturnTrueIfEmailIsValid() throws Exception {
        assertTrue(signUpValidator.email("smith@org.com"));
    }

    @Test
    public void testShouldReturnFalseIfEmailIsNotValid() throws Exception {
        assertFalse(signUpValidator.email("smith*****orgddd/com"));
    }

    @Test
    public void testShouldReturnTrueIfPasswordIsValid() throws Exception {
        assertTrue(signUpValidator.password("adfgHi4234hrewwer"));
    }

    @Test
    public void testShouldReturnFalseIfPasswordIsNotValid() throws Exception {
        assertFalse(signUpValidator.password("a#df#gH%%%ir"));
    }

}