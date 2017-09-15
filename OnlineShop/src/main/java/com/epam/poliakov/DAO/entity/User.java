package com.epam.poliakov.DAO.entity;

public class User {

    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
    private String imageName;
    private String role;
    private Boolean ban;
    private Integer countFailedLogin;
    private Long failedDate;

    public User(String firstName, String lastName, String login, String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String firstName, String lastName, String login, String email, String password, String imageName, String role) {
        this(firstName, lastName, login, email, password, role);
        this.imageName = imageName;
    }

    public User(String firstName, String lastName, String login, String email, String password, String imageName, String role, Boolean ban, Integer countFailedLogin, Long failedDate) {
        this(firstName, lastName, login, email, password, imageName, role);
        this.ban = ban;
        this.countFailedLogin = countFailedLogin;
        this.failedDate = failedDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", imageName='" + imageName + '\'' +
                ", role='" + role + '\'' +
                ", ban=" + ban +
                ", countFailedLogin=" + countFailedLogin +
                ", failedDate=" + failedDate +
                '}';
    }
}

