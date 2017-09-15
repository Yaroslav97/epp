package com.epam.poliakov.task5;

import java.io.File;
import java.util.Date;

public class FileFilter {

    public static final String SPLIT = " - ";
    public static final int SECOND_DATE = 1;
    public static final int FILE_FORMAT = 1;
    public static final int FIRST_DATE = 0;
    public static final int FIRST_SIZE = 0;
    public static final int SECOND_SIZE = 1;

    private File directory;

    public FileFilter(File directory) {
        this.directory = directory;
    }

    public File getDirectory() {
        return new File(directory + "\\");
    }

    public boolean filterFileByName(String fileName, File file) {
        return file.getName().equals(fileName);
    }

    public boolean filterFileBySize(int fileSizeFrom, int fileSizeTo, File file) {
        return file.length() >= fileSizeFrom && fileSizeTo >= file.length();
    }

    public boolean filterFileByDate(Date fromDate, Date toDate, File file) {
        Date lastModified = new Date(file.lastModified());
        return lastModified.getTime() >= fromDate.getTime() && toDate.getTime() >= lastModified.getTime();
    }

    public boolean filterFileByType(String fileFormat, File file) {
        return file.getName().substring(file.getName().lastIndexOf(".") + FILE_FORMAT, file.getName().length()).equals(fileFormat);
    }
}
