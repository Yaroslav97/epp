package com.epam.poliakov.task5.Filter;

import com.epam.poliakov.task5.FileFilter;

import java.io.File;

public class SearchByFileType extends Filter {

    private String type;
    private FileFilter fileFilter;

    public SearchByFileType(Filter next, String type, FileFilter fileFilter) {
        this.next = next;
        this.type = type;
        this.fileFilter = fileFilter;
    }

    @Override
    public boolean filter(File file) {
        return fileFilter.filterFileByType(type, file);
    }
}
