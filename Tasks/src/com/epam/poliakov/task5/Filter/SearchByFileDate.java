package com.epam.poliakov.task5.Filter;

import com.epam.poliakov.task5.FileFilter;

import java.io.File;
import java.util.Date;

import static com.epam.poliakov.task5.FileFilter.FIRST_DATE;
import static com.epam.poliakov.task5.FileFilter.SECOND_DATE;
import static com.epam.poliakov.task5.FileFilter.SPLIT;
import static com.epam.poliakov.task5.util.DateUtil.convertStringToDate;

public class SearchByFileDate extends Filter {

    private String date;
    private FileFilter fileFilter;

    public SearchByFileDate(Filter next, String date, FileFilter fileFilter) {
        this.next = next;
        this.date = date;
        this.fileFilter = fileFilter;
    }

    @Override
    public boolean filter(File file) {

        String[] diapasonOfDates = date.split(SPLIT);

        Date fromDate = convertStringToDate(diapasonOfDates[FIRST_DATE]);
        Date toDate = convertStringToDate(diapasonOfDates[SECOND_DATE]);

        return fileFilter.filterFileByDate(fromDate, toDate, file);
    }
}
