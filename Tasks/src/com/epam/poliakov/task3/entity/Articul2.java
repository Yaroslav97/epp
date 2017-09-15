package com.epam.poliakov.task3.entity;

public class Articul2 {
    private String articul;

    public Articul2(String articul) {
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
            if (articul.length() >= 4) {
                for (int i = 0; i <= 4; i++) {
                    a += (int) articul.charAt(i);
                }
            } else {
                for (int i = 0; i < articul.length(); i++) {
                    a += (int) articul.charAt(i);
                }
            }
        }
        return a;
    }
}
