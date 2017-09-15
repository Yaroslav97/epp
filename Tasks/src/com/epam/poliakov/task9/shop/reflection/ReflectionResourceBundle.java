package com.epam.poliakov.task9.shop.reflection;

import com.epam.poliakov.task9.shop.annotation.Product;

import java.lang.reflect.Method;
import java.util.ResourceBundle;

public class ReflectionResourceBundle {

    protected static final String I18N = "i18n";
    private ResourceBundle resourceBundle;
    private Class aClass;

    public ReflectionResourceBundle(Class aClass) {
        this.aClass = aClass;
        resourceBundle = ResourceBundle.getBundle(I18N);
    }

    /**
     * Get key from annotation method and return word from resourceBundle.
     * @param fieldName
     * @return i18n word from resourceBundle;
     */
    public String getI18nWord(String fieldName) {
        for (Method s : aClass.getDeclaredMethods()) {
            if (s.isAnnotationPresent(Product.class) && s.getAnnotation(Product.class).key().equals(fieldName))
                return resourceBundle.getString(fieldName);
        }
        return null;
    }
}
