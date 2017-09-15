package com.epam.poliakov.task8.simpleNum.thread;

import com.epam.poliakov.task8.simpleNum.NumberSearcherLocalThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LauncherLocalListThread {

    /**
     * Method start threads.
     * Use local List.
     * @param fromNum
     * @param toNum
     * @param countThread
     * @throws InterruptedException
     */
    public void launch(int fromNum, int toNum, int countThread) throws InterruptedException {

        List<Integer> simpleNumList = Collections.synchronizedList(new ArrayList<>());

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < countThread; i++) {
            threadList.add(new Thread(new NumberSearcherLocalThread(simpleNumList, fromNum + i, toNum, countThread)));
        }
        for (Thread t : threadList) {
            t.start();
        }
        for (Thread t : threadList) {
            t.join();
        }
        System.out.println(simpleNumList);
    }
}
