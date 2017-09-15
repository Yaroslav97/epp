package com.epam.poliakov.task6.shop.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * Method convert String format date to Date.
     * If input format date is wrong - method return current date.
     *
     * @param stringDate
     * @return Date
     */
    public static Date convertStringToDate(String stringDate) {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = format.parse(stringDate);
        } catch (ParseException e) {
            System.err.println("wrong format date.\nUse current date");
            return new Date();
        }
        return date;
    }
}
