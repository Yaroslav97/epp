package com.epam.poliakov.task5.Filter;

import com.epam.poliakov.task5.FileFilter;

import java.io.File;

import static com.epam.poliakov.task5.FileFilter.FIRST_SIZE;
import static com.epam.poliakov.task5.FileFilter.SECOND_SIZE;
import static com.epam.poliakov.task5.FileFilter.SPLIT;

public class SearchByFileSize extends Filter {

    private String size;
    private FileFilter fileFilter;

    public SearchByFileSize(Filter next, String size, FileFilter fileFilter) {
        this.next = next;
        this.size = size;
        this.fileFilter = fileFilter;
    }

    @Override
    public boolean filter(File file) {
        String[] diapasonOfSize = size.split(SPLIT);

        int fromSize = Integer.parseInt(diapasonOfSize[FIRST_SIZE]);
        int toSize = Integer.parseInt(diapasonOfSize[SECOND_SIZE]);

        return fileFilter.filterFileBySize(fromSize, toSize, file);
    }
}
