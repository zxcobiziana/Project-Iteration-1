package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.models.Restaurant;
import com.company.models.User;
import com.company.repositories.interfaces.IRestaurantRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository implements IRestaurantRepository {
    private final IDB db;  // Dependency Injection

    public RestaurantRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createRestaurant(Restaurant restaurant) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO restaurants(title,address,worktime,phone,is_blocked) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, restaurant.getTitle());
            st.setString(2, restaurant.getAddress());
            st.setString(3, restaurant.getWorktime());
            st.setString(4, restaurant.getPhone());
            st.setBoolean(5, restaurant.getIsBlocked());

            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public Restaurant getRestaurant(int id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,title,address,worktime,phone,is_blocked FROM restaurants WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Restaurant(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("address"),
                        rs.getString("worktime"),
                        rs.getString("phone"),
                        rs.getBoolean("is_blocked"));
            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,title,address,worktime,phone,is_blocked FROM restaurants";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Restaurant> restaurants = new ArrayList<>();
            while (rs.next()) {
                Restaurant restaurant = new Restaurant(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("address"),
                        rs.getString("worktime"),
                        rs.getString("phone"),
                        rs.getBoolean("is_blocked"));

                restaurants.add(restaurant);
            }

            return restaurants;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean updateRestaurant(Restaurant restaurant) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "UPDATE restaurants set title = ?, address = ?, worktime = ?, phone = ?, is_blocked = ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, restaurant.getTitle());
            st.setString(2, restaurant.getAddress());
            st.setString(3, restaurant.getWorktime());
            st.setString(4, restaurant.getPhone());
            st.setBoolean(5, restaurant.getIsBlocked());
            st.setInt(6, restaurant.getId());

            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return false;
    }

}
