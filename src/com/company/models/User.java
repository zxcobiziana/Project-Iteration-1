package com.company.models;

public class User {
    private int id;
    private String fullname;
    private String login;

    public User() {

    }

    public User(String fullname, String login) {
        setFullname(fullname);
        setLogin(login);
    }

    public User(int id, String fullname, String login) {
        this(fullname, login);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", login='" + login +
                '}';
    }
}
