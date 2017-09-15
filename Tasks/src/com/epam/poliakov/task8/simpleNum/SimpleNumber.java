package com.epam.poliakov.task8.simpleNum;

public class SimpleNumber {

    /**
     * Method return true if number is simple (/ 1, num / num)
     * @param value
     * @return
     */
    public static boolean isSimpleNumber(int value) {

        if (value == 1 || value == 0){
            return false;
        }

        for (int i = 2; i < value / 2 + 1; i++) {
            if (value % i == 0)
                return false;
        }
        return true;
    }
}
