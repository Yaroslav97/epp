package com.epam.poliakov.task5.Filter;

import java.io.File;

public abstract class Filter {

    protected Filter next;

    public boolean acceptFile(File f) {
        if (!filter(f)){
            return false;
        }
        if (next != null) {
            return next.filter(f);
        } else {
            return true;
        }
    }

    public abstract boolean filter(File file);
}
