package com.epam.poliakov.task5.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean validSize(String command) {
        Pattern pattern = Pattern.compile("([0-9]+ - [0-9]+)");
        Matcher matcher = pattern.matcher(command);
        return matcher.find();
    }
}
