package com.epam.poliakov.task8.simpleNum;

import com.epam.poliakov.task8.simpleNum.executor.ExecutorSearcherGeneralList;
import com.epam.poliakov.task8.simpleNum.executor.ExecutorSearcherLocalList;
import com.epam.poliakov.task8.simpleNum.thread.LauncherGeneralListThread;
import com.epam.poliakov.task8.simpleNum.thread.LauncherLocalListThread;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter diapason of numbers: \nfrom: ");
        int fromNum = scanner.nextInt();

        System.out.println("to: ");
        int toNum = scanner.nextInt();

        System.out.println("Count of threads");
        int countThread = scanner.nextInt();

        long before = System.currentTimeMillis();

        LauncherGeneralListThread launcherGeneralListThread = new LauncherGeneralListThread();
        launcherGeneralListThread.launch(fromNum, toNum, countThread);

        long after = System.currentTimeMillis();

        System.out.println("Thread with general List: " + (after - before) + " ms");

        long beforeLocalList = System.currentTimeMillis();

        LauncherLocalListThread launcherLocalListThread = new LauncherLocalListThread();
        launcherLocalListThread.launch(fromNum, toNum, countThread);

        long afterLocalList = System.currentTimeMillis();

        System.out.println("Thread with local List: " + (afterLocalList - beforeLocalList) + " ms");

        long beforeExecutor = System.currentTimeMillis();

        ExecutorSearcherGeneralList executorSearcherGeneralList = new ExecutorSearcherGeneralList();
        executorSearcherGeneralList.launch(fromNum, toNum, countThread);

        long afterExecutor = System.currentTimeMillis();

        System.out.println("Executor general list: " + (afterExecutor - beforeExecutor) + " ms");

        long beforeLocalExecutor = System.currentTimeMillis();

        ExecutorSearcherLocalList executorSearcherLocalList = new ExecutorSearcherLocalList();
        executorSearcherLocalList.launch(fromNum, toNum, countThread);

        long afterLocalExecutor = System.currentTimeMillis();

        System.out.print("Executor local list: " + (afterLocalExecutor - beforeLocalExecutor) + " ms");
    }
}
