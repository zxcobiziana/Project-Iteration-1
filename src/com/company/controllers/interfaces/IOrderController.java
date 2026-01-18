package com.company.controllers.interfaces;

public interface IOrderController {
    String getOrdersByRestaurantId(int restaurant_id);

    String createOrder(String status, int user_id, int restaurant_id);

    String getOrder(int id);

    String updateOrder(int id, String status, int user_id, int restaurant_id);

    String getProductsByOrderId(int id);

    String addOrderProduct(int id, int product_id, int count);

    String modifyOrderProduct(int id, int product_id, int count);
}
