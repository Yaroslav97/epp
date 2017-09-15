package com.epam.poliakov.task5.Filter;

import com.epam.poliakov.task5.FileFilter;

import java.io.File;

public class SearchByFileName extends Filter {

    private String name;
    private FileFilter fileFilter;

    public SearchByFileName(Filter next, String name, FileFilter fileFilter) {
        this.next = next;
        this.name = name;
        this.fileFilter = fileFilter;
    }

    @Override
    public boolean filter(File file) {
        return fileFilter.filterFileByName(name, file);
    }
}
