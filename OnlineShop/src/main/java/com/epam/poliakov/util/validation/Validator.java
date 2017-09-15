package com.epam.poliakov.util.validation;

import com.epam.poliakov.controller.signUp.RegistrationDTO;

import java.util.Map;

public interface Validator<T> {

    Map<T, T> validate(RegistrationDTO user);
}
