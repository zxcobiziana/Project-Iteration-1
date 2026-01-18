package com.company.controllers;

import com.company.controllers.interfaces.IProductController;
import com.company.controllers.interfaces.IRestaurantController;
import com.company.models.Product;
import com.company.models.Restaurant;
import com.company.repositories.interfaces.IProductRepository;
import com.company.repositories.interfaces.IRestaurantRepository;

import java.util.List;

public class ProductController implements IProductController {
    private final IProductRepository repo;

    public ProductController(IProductRepository repo) { // Dependency Injection
        this.repo = repo;
    }

    public String createProduct(String title, String description, int price, int restaurant_id) {
        Product product = new Product(title, description, price, restaurant_id);

        boolean created = repo.createProduct(product);

        return (created ? "Product was created!" : "Product creation was failed!");
    }

    public String getProduct(int id) {
        Product product = repo.getProduct(id);

        return (product == null ? "Product was not found!" : product.toString());
    }

    public String getProductsByRestaurantId(int restaurant_id) {
        List<Product> products = repo.getProductsByRestaurantId(restaurant_id);

        StringBuilder response = new StringBuilder();
        for (Product product : products) {
            response.append(product.toString()).append("\n");
        }

        return response.toString();
    }

    public String updateProduct(int id, String title, String description, int price, int restaurant_id) {
        Product product = new Product(id, title, description, price, restaurant_id);

        boolean created = repo.updateProduct(product);

        return (created ? "Product was updated!" : "Product update was failed!");
    }

    public String deleteProduct(int id) {
        boolean deleted = repo.deleteProduct(id);

        return (deleted ? "Product was deleted!" : "Product delete was failed!");
    }
}
