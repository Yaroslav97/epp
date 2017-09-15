package com.epam.poliakov.controller.order;

public enum OrderStatus {

    ACTIVE("active"),
    CANCELED("not active");

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
