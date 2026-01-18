package com.company.repositories.interfaces;

import com.company.models.Order;
import com.company.models.OrderProduct;

import java.util.List;

public interface IOrderRepository {
    boolean createOrder(Order order);

    Order getOrder(int id);

    List<Order> getOrdersByRestaurantId(int restaurant_id);

    boolean updateOrder(Order order);

    List<OrderProduct> getProductsByOrderId(int id);

    boolean addOrderProduct(int id, int product_id, int count);

    boolean modifyOrderProduct(int id, int product_id, int count);
}
