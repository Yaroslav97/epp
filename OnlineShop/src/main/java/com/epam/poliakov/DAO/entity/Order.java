package com.epam.poliakov.DAO.entity;

import java.util.Date;

public class Order {

    private int id;
    private String status;
    private String describe;
    private Date date;
    private String login;
    private OrderProduct orderProduct;

    public Order(String status, String describe, Date date, String login, OrderProduct orderProduct) {
        this.status = status;
        this.describe = describe;
        this.date = date;
        this.login = login;
        this.orderProduct = orderProduct;
    }

    public Order(int id, String status, String describe, Date date, String login, OrderProduct orderProduct) {
        this(status, describe, date, login, orderProduct);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", describe='" + describe + '\'' +
                ", date=" + date +
                ", login='" + login + '\'' +
                ", orderProduct=" + orderProduct +
                '}';
    }
}
