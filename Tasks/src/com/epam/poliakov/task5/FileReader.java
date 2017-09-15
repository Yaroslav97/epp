package com.epam.poliakov.task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class FileReader implements Iterable<String> {

    private File file;

    public FileReader(File file) {
        this.file = file;
    }

    @Override
    public Iterator<String> iterator() {
        try {
            return new IteratorImpl();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private class IteratorImpl implements Iterator<String> {
        Scanner scanner = new Scanner(file);

        private IteratorImpl() throws FileNotFoundException {
        }

        @Override
        public boolean hasNext() {
            return scanner.hasNext();
        }

        @Override
        public String next() {
            return scanner.nextLine();
        }
    }
}
