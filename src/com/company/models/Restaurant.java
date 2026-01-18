package com.company.models;

public class Restaurant {
    private int id;
    private String title;
    private String address;
    private String worktime;
    private String phone;
    private boolean is_blocked;

    public Restaurant() {

    }

    public Restaurant(String title, String address, String worktime, String phone, boolean is_blocked) {
        setTitle(title);
        setAddress(address);
        setWorktime(worktime);
        setPhone(phone);
        setIsBlocked(is_blocked);
    }

    public Restaurant(int id, String title, String address, String worktime, String phone, boolean is_blocked) {
        this(title, address, worktime, phone, is_blocked);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getIsBlocked() {
        return is_blocked;
    }

    public void setIsBlocked(boolean is_blocked) {
        this.is_blocked = is_blocked;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", worktime='" + worktime + '\'' +
                ", phone='" + phone + '\'' +
                ", is_blocked='" + (is_blocked ? "Blocked" : "Active") +
                '}';
    }
}
