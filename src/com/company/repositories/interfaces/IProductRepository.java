package com.company.repositories.interfaces;

import com.company.models.Product;

import java.util.List;

public interface IProductRepository {
    boolean createProduct(Product product);

    Product getProduct(int id);

    List<Product> getProductsByRestaurantId(int restaurant_id);

    boolean updateProduct(Product product);

    boolean deleteProduct(int id);
}
