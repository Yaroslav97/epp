package com.epam.poliakov.DAO.entity;

public class Ban {

    private String login;
    private Boolean ban;
    private Integer countFailedLogin;
    private Long failedDate;

    public Ban(String login, Boolean ban, Integer countFailedLogin, Long failedDate) {
        this.login = login;
        this.ban = ban;
        this.countFailedLogin = countFailedLogin;
        this.failedDate = failedDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getBan() {
        return ban;
    }

    public void setBan(Boolean ban) {
        this.ban = ban;
    }

    public Integer getCountFailedLogin() {
        return countFailedLogin;
    }

    public void setCountFailedLogin(Integer countFailedLogin) {
        this.countFailedLogin = countFailedLogin;
    }

    public Long getFailedDate() {
        return failedDate;
    }

    public void setFailedDate(Long failedDate) {
        this.failedDate = failedDate;
    }

    @Override
    public String toString() {
        return "Ban{" +
                "login='" + login + '\'' +
                ", ban=" + ban +
                ", countFailedLogin=" + countFailedLogin +
                ", failedDate=" + failedDate +
                '}';
    }
}
