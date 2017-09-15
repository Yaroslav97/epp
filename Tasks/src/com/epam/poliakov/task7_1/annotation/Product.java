package com.epam.poliakov.task7_1.annotation;

import java.lang.annotation.*;

/**
 * Annotation for i18n.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Product {
    String key();
}
