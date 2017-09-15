package com.epam.poliakov.task3.entity;

public class Articul {
    private String articul;

    public Articul(String articul) {
        this.articul = articul;
    }

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    @Override
    public int hashCode() {
        int a = 0;
        if (articul != null) {
            a = articul.length();
        }
        return a;
    }
}
