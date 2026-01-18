package com.company.controllers;

import com.company.controllers.interfaces.IOrderController;
import com.company.models.Order;
import com.company.models.OrderProduct;
import com.company.models.Product;
import com.company.repositories.interfaces.IOrderRepository;

import java.util.List;

public class OrderController implements IOrderController {
    private final IOrderRepository repo;

    public OrderController(IOrderRepository repo) { // Dependency Injection
        this.repo = repo;
    }

    public String createOrder(String status, int user_id, int restaurant_id) {
        Order order = new Order(status, user_id, restaurant_id);

        boolean created = repo.createOrder(order);

        return (created ? "Order was created!" : "Order creation was failed!");
    }

    public String getOrder(int id) {
        Order order = repo.getOrder(id);

        return (order == null ? "Order was not found!" : order.toString());
    }

    public String getOrdersByRestaurantId(int restaurant_id) {
        List<Order> orders = repo.getOrdersByRestaurantId(restaurant_id);

        StringBuilder response = new StringBuilder();
        for (Order order : orders) {
            response.append(order.toString()).append("\n");
        }

        return response.toString();
    }

    public String updateOrder(int id, String status, int user_id, int restaurant_id) {
        Order order = new Order(id, status, user_id, restaurant_id);

        boolean updated = repo.updateOrder(order);

        return (updated ? "Order was updated!" : "Order update was failed!");
    }

    public String getProductsByOrderId(int id) {
        List<OrderProduct> products = repo.getProductsByOrderId(id);

        StringBuilder response = new StringBuilder();
        for (OrderProduct product : products) {
            response.append(product.toString()).append("\n");
        }

        return response.toString();
    }

    public String addOrderProduct(int id, int product_id, int count) {
        boolean created = repo.addOrderProduct(id, product_id, count);

        return (created ? "OrderProduct was created!" : "OrderProduct creation was failed!");
    }

    public String modifyOrderProduct(int id, int product_id, int count) {
        boolean updated = repo.modifyOrderProduct(id, product_id, count);

        return (updated ? "OrderProduct was created!" : "OrderProduct creation was failed!");
    }
}
