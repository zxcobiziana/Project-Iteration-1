package com.company.models;

public class Order {
    private int id;
    private String status;
    private int user_id;
    private int restaurant_id;

    public Order() {

    }

    public Order(String status, int user_id, int restaurant_id) {
        setStatus(status);
        setUserId(user_id);
        setRestaurantId(restaurant_id);
    }

    public Order(int id, String status, int user_id, int restaurant_id) {
        this(status, user_id, restaurant_id);
        setId(id);
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

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getRestaurantId() {
        return restaurant_id;
    }

    public void setRestaurantId(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", user_id='" + user_id + '\'' +
                ", restaurant_id='" + restaurant_id +
                '}';
    }
}
