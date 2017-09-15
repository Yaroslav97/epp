package com.epam.poliakov.task8.simpleNum;

import java.util.ArrayList;
import java.util.List;

/**
 * Class make operations with local List.
 */
public class NumberSearcherLocalThread implements Runnable {

    private int from;
    private int to;
    private int step;
    private List<Integer> integerList;
    private List<Integer> localList;

    /**
     * Constructor should obtains synchronized List
     * @param integerList synchronized List
     * @param from start number
     * @param to finish number
     * @param step count of threads
     */
    public NumberSearcherLocalThread(List<Integer> integerList, int from, int to, int step) {
        this.integerList = integerList;
        this.from = from;
        this.to = to;
        this.step = step;
        localList = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = from; i < to; i += step) {
            if (SimpleNumber.isSimpleNumber(i)) {
                localList.add(i);
            }
        }
        integerList.addAll(localList);
    }
}
