package com.epam.poliakov.task5;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Date;

import static org.junit.Assert.*;

public class FileFilterTest {

    public static final int FILE_SIZE_FROM_WHEN_TRUE = 500;
    public static final int FILE_SIZE_TO_WHEN_TRUE = 900;
    public static final String FILE = "txt\\text.txt";
    public static final int FILE_SIZE_FROM_WHEN_FALSE = 50;
    public static final int FILE_SIZE_TO_WHEN_FALSE = 100;
    public static final String FILE_FORMAT_TXT = "txt";
    public static final String FILE_FORMAT_PDF = "pdf";
    public static final String PATHNAME = "txt\\";
    private FileFilter fileFilter;

    @Before
    public void init() {
        fileFilter = new FileFilter(new File(PATHNAME));
    }

    @Test
    public void testShouldReturnTrueIfFilterFileByNameFind() {
        assertTrue(fileFilter.filterFileByName("text.txt", new File(FILE)));
    }

    @Test
    public void testShouldReturnFalseIfFilterFileByNameNotFind() {
        assertFalse(fileFilter.filterFileByName("text11.txt", new File(FILE)));
    }

    @Test
    public void testShouldReturnTrueIfFilterFileBySizeFind() {
        assertTrue(fileFilter.filterFileBySize(FILE_SIZE_FROM_WHEN_TRUE, FILE_SIZE_TO_WHEN_TRUE, new File(FILE)));
    }

    @Test
    public void testShouldReturnFalseIfFilterFileBySizeNotFind() {
        assertFalse(fileFilter.filterFileBySize(FILE_SIZE_FROM_WHEN_FALSE, FILE_SIZE_TO_WHEN_FALSE, new File(FILE)));
    }

    @Test
    public void testShouldReturnFalseIfFilterFileByDateNotFind() {
        assertFalse(fileFilter.filterFileByDate(new Date(), new Date(), new File(FILE)));
    }

    @Test
    public void testShouldReturnTrueIfFilterFileByTypeFind() {
        assertTrue(fileFilter.filterFileByType(FILE_FORMAT_TXT, new File(FILE)));
    }

    @Test
    public void testShouldReturnFalseIfFilterFileByTypeNotFind() {
        assertFalse(fileFilter.filterFileByType(FILE_FORMAT_PDF, new File(FILE)));
    }
}