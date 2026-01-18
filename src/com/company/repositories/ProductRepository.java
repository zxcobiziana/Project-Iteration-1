package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.models.Product;
import com.company.models.Restaurant;
import com.company.models.User;
import com.company.repositories.interfaces.IProductRepository;
import com.company.repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private final IDB db;  // Dependency Injection

    public ProductRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createProduct(Product product) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO product(title, description, price, restaurant_id) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, product.getTitle());
            st.setString(2, product.getDescription());
            st.setInt(3, product.getPrice());
            st.setInt(4, product.getRestaurantId());

            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public Product getProduct(int id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,title,description, price, restaurant_id FROM products WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getInt("restaurant_id"));
            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Product> getProductsByRestaurantId(int restaurant_id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,title,description, price, restaurant_id FROM products WHERE restaurant_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, restaurant_id);

            ResultSet rs = st.executeQuery(sql);
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getInt("restaurant_id"));

                products.add(product);
            }

            return products;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "UPDATE products set title = ?, description = ?, price = ?, restaurant_id = ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, product.getTitle());
            st.setString(2, product.getDescription());
            st.setInt(3, product.getPrice());
            st.setInt(4, product.getRestaurantId());
            st.setInt(5, product.getId());

            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "DELETE FROM products WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return false;
    }
}
