package com.epam.poliakov.task7_1.shop.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LocaleUtil {

    /**
     * Set default locale.
     */
    public static void setLocal(String local) {

        Map<String, Locale> localeMap = new HashMap<>();
        localeMap.put("0", Locale.ENGLISH);
        localeMap.put("1", new Locale("ru"));

        Locale.setDefault(localeMap.get(local));
    }
}
