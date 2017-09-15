package com.epam.poliakov.util.xml_parser;

public class Security {

    private String url;
    private String role;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Security{" +
                "url='" + url + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
