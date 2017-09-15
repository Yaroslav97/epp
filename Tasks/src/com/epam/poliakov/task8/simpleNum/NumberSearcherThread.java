package com.epam.poliakov.task8.simpleNum;

import java.util.List;

/**
 * Class make operations with general List.
 */
public class NumberSearcherThread implements Runnable {

    private List<Integer> integerList;
    private int from;
    private int to;
    private int step;

    /**
     * Constructor should obtains synchronized List
     * @param integerList synchronized List
     * @param from start number
     * @param to finish number
     * @param step count of threads
     */
    public NumberSearcherThread(List<Integer> integerList, int from, int to, int step) {
        this.integerList = integerList;
        this.from = from;
        this.to = to;
        this.step = step;
    }

    @Override
    public void run() {
        for (int i = from; i < to; i += step) {
            if (SimpleNumber.isSimpleNumber(i)) {
                integerList.add(i);
            }
        }
    }
}
