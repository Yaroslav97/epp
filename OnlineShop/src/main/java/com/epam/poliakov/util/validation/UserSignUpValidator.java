package com.epam.poliakov.util.validation;

import com.epam.poliakov.controller.signUp.RegistrationDTO;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class UserSignUpValidator implements SignUpValidator<String>, Validator<String> {

    private final String namePattern = "^[A-z]{4,20}$";
    private final String loginPattern = "^[A-Za-z0-9]{4,20}$";
    private final String emailPattern = "[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,8})";
    private final String passwordPattern = "^[A-Za-z0-9]{4,20}$";

    @Override
    public boolean firstName(String firstName) {
        return Pattern.compile(namePattern).matcher(firstName).find();
    }

    @Override
    public boolean lastName(String lastName) {
        return Pattern.compile(namePattern).matcher(lastName).find();
    }

    @Override
    public boolean login(String login) {
        return Pattern.compile(loginPattern).matcher(login).find();
    }

    @Override
    public boolean email(String email) {
        return Pattern.compile(emailPattern).matcher(email).find();
    }

    @Override
    public boolean password(String password) {
        return Pattern.compile(passwordPattern).matcher(password).find();
    }

    @Override
    public Map<String, String> validate(RegistrationDTO user) {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n", user.getLocale());

        Map<String, String> validationError = new HashMap<>();

        if (!firstName(user.getFirstName())) {
            validationError.put("firstName", resourceBundle.getString("wrong_firstName"));
        }
        if (!lastName(user.getLastName())) {
            validationError.put("lastName", resourceBundle.getString("wrong_lastName"));
        }
        if (!login(user.getLogin())) {
            validationError.put("login", resourceBundle.getString("wrong_login"));
        }
        if (!email(user.getEmail())) {
            validationError.put("email", resourceBundle.getString("wrong_email"));
        }
        if (!password(user.getPassword())) {
            validationError.put("password", resourceBundle.getString("wrong_password"));
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            validationError.put("password_conf", resourceBundle.getString("password_is_not_equals"));
        }
        return validationError;
    }
}
