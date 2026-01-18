package com.company.controllers.interfaces;

public interface IProductController {
    String createProduct(String title, String description, int price, int restaurant_id);

    String getProduct(int id);

    String getProductsByRestaurantId(int restaurant_id);

    String updateProduct(int id, String title, String description, int price, int restaurant_id);

    String deleteProduct(int id);
}
