package com.epam.poliakov.controller.signUp;

public class RegistrationTimer {

    public static boolean isValidRegistrationTime(long startTime, int contextTime){
        return (System.currentTimeMillis() - startTime) < (1000 * contextTime);
    }
}
