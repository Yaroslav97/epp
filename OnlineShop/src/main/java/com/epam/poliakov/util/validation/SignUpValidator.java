package com.epam.poliakov.util.validation;

public interface SignUpValidator<T> {

    boolean firstName(T name);

    boolean lastName(T name);

    boolean login(T login);

    boolean email(T email);

    boolean password(T password);
}
