package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.models.Order;
import com.company.models.OrderProduct;
import com.company.repositories.interfaces.IOrderRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    private final IDB db;  // Dependency Injection

    public OrderRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createOrder(Order order) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO orders(status, user_id, restaurant_id) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, order.getStatus());
            st.setInt(2, order.getUserId());
            st.setInt(3, order.getRestaurantId());
            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean addOrderProduct(int id, int product_id, int count) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO orders_products(order_id, product_id, count) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            st.setInt(2, product_id);
            st.setInt(3, count);
            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean modifyOrderProduct(int id, int product_id, int count) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "UPDATE orders_products set count = ? WHERE order_id = ? AND product_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, count);
            st.setInt(2, id);
            st.setInt(3, product_id);

            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public Order getOrder(int id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT status,user_id,restaurant_id FROM orders WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Order(rs.getInt("id"),
                        rs.getString("status"),
                        rs.getInt("user_id"),
                        rs.getInt("restaurant_id"));
            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Order> getOrdersByRestaurantId(int restaurant_id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,status,user_id,restaurant_id FROM orders WHERE restaurant_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, restaurant_id);

            ResultSet rs = st.executeQuery(sql);
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order(rs.getInt("id"),
                        rs.getString("status"),
                        rs.getInt("user_id"),
                        rs.getInt("restaurant_id"));

                orders.add(order);
            }

            return orders;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean updateOrder(Order order) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "Update orders set status,user_id,restaurant_id FROM orders WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, order.getStatus());
            st.setInt(2, order.getUserId());
            st.setInt(3, order.getRestaurantId());

            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public List<OrderProduct> getProductsByOrderId(int id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,order_id,product_id,count FROM orders_products WHERE order_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery(sql);
            List<OrderProduct> products = new ArrayList<>();
            while (rs.next()) {
                OrderProduct orderProduct = new OrderProduct(rs.getInt("id"),
                        rs.getInt("order_id"),
                        rs.getInt("product_id"),
                        rs.getInt("count"));

                products.add(orderProduct);
            }

            return products;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return null;
    }
}
