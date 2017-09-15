package com.epam.poliakov.task8.sequence;

import java.io.*;

/**
 * Class for searching byte sequence.
 */
public class FileSearcher implements Runnable {

    private File file;
    private Object monitor;
    private int length;
    private int firstIndex;
    private int lastIndex;

    /**
     * Constructor obtains monitor.
     * @param monitor
     */
    public FileSearcher(Object monitor) {
        this.monitor = monitor;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private byte[] readFile(File file) throws IOException {

        FileInputStream fileReader = new FileInputStream(file);
        byte[] bytes = new byte[fileReader.available()];
        fileReader.read(bytes, 0, fileReader.available());

        return bytes;
    }

    /**
     * Algorithm of searching byte sequence.
     * @param bytes
     */
    private void searchSequence(byte[] bytes) {

        for (int i = 0; i < bytes.length; i++) {
            int temp = 0;
            for (int j = i + 1; j < bytes.length; j++) {
                if (bytes[i + temp] == bytes[j]) {
                    if (temp >= length) {
                        length = temp + 1;
                        firstIndex = i;
                        lastIndex = j - temp;
                    }
                    temp++;
                } else {
                    temp = 0;
                }
            }
        }
    }

    public int getLength() {
        return length;
    }

    @Override
    public void run() {

        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            byte[] bytes = null;

            try {
                bytes = readFile(file);
            } catch (IOException e) {
                System.err.println("file not found...");
                System.out.println("Enter file name again: ");
            }

            searchSequence(bytes);

            System.out.println("------------------------");
            System.out.printf("first %d - %d\nsecond %d - %d\n", firstIndex, firstIndex + length, lastIndex, lastIndex + length);
        }
    }
}
