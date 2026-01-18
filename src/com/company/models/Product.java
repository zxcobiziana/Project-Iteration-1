package com.company.models;

public class Product {
    private int id;
    private String title;
    private String description;
    private int price;
    private int restaurant_id;

    public Product() {

    }

    public Product(String title, String description, int price, int restaurant_id) {
        setTitle(title);
        setDescription(description);
        setPrice(price);
        setRestaurantId(restaurant_id);
    }

    public Product(int id, String title, String description, int price, int restaurant_id) {
        this(title, description, price, restaurant_id);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRestaurantId() {
        return restaurant_id;
    }

    public void setRestaurantId(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", restaurant_id='" + restaurant_id +
                '}';
    }
}
