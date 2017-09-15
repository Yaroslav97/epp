package com.epam.poliakov.task8.simpleNum.executor;

import com.epam.poliakov.task8.simpleNum.NumberSearcherThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorSearcherGeneralList {

    /**
     *  Method start threads in executor.
     * Use general List.
     * @param fromNum
     * @param toNum
     * @param countThread
     */
    public void launch(int fromNum, int toNum, int countThread) {

        List<Integer> simpleNumList = Collections.synchronizedList(new ArrayList<>());

        ExecutorService executor = Executors.newFixedThreadPool(countThread);

        for (int i = 0; i < countThread; i++) {
            executor.execute(new NumberSearcherThread(simpleNumList, fromNum + i, toNum, countThread));
        }
        executor.shutdown();

        while (!executor.isTerminated()) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(simpleNumList);
    }
}
