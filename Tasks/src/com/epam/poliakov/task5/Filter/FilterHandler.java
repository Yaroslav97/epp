package com.epam.poliakov.task5.Filter;

import com.epam.poliakov.task5.FileFilter;
import com.epam.poliakov.task5.util.Validation;

import java.io.File;
import java.util.Scanner;

public class FilterHandler {

    private File directory;
    private FileFilter fileFilter;

    public FilterHandler(File directory) {
        this.directory = directory;
        fileFilter = new FileFilter(directory);
    }

    public SearchByFileName filterByName(Filter filter, Scanner scanner) {
        System.out.println("Enter fileName (file.txt) ");
        String commandName = scanner.nextLine();
        return new SearchByFileName(filter, commandName, fileFilter);
    }

    public SearchByFileType filterByType(Filter filter, Scanner scanner) {
        System.out.println("Enter file type (txt) ");
        String commandType = scanner.nextLine();
        return new SearchByFileType(filter, commandType, fileFilter);

    }

    public SearchByFileSize filterBySize(Filter filter, Scanner scanner) {

        System.out.println("Enter file size (fromSize - toSize) ");
        String commandSize = scanner.nextLine();
        if (!Validation.validSize(commandSize)) {
            System.err.println("wrong format size\nthis filter skipped");
            return new SearchByFileSize(filter, "0 - 10000", fileFilter);
        }
        return new SearchByFileSize(filter, commandSize, fileFilter);
    }

    public SearchByFileDate filterByDate(Filter filter, Scanner scanner) {
        System.out.println("Enter file date (fromDate - toDate) ");
        String commandDate = scanner.nextLine();
        return new SearchByFileDate(filter, commandDate, fileFilter);
    }
}
