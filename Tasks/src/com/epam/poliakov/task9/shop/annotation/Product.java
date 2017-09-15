package com.epam.poliakov.task9.shop.annotation;

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
