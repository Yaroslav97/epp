package com.epam.poliakov.task8.sequence;

import java.io.File;
import java.util.Scanner;

/**
 * Main thread
 * create thread FileSearcher
 */
public class MainThread extends Thread {

    @Override
    public void run() {

        Scanner fileScanner = new Scanner(System.in);
        Object monitor = new Object();

        while (true) {
            System.out.println("Enter file name: ");

            FileSearcher fileSearcher = new FileSearcher(monitor);

            Thread thread = new Thread(fileSearcher);
            thread.start();

            String fileName = fileScanner.nextLine();
            fileSearcher.setFile(new File(fileName));

            synchronized (monitor) {
                monitor.notify();
            }

            while (thread.isAlive()) {
                System.out.println(fileSearcher.getLength());
                try {
                    sleep(750);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
