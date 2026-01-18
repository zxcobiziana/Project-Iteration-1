package com.company.controllers;

import com.company.controllers.interfaces.IRestaurantController;
import com.company.controllers.interfaces.IUserController;
import com.company.models.Restaurant;
import com.company.models.User;
import com.company.repositories.interfaces.IRestaurantRepository;

import java.util.List;

public class RestaurantController implements IRestaurantController {
    private final IRestaurantRepository repo;

    public RestaurantController(IRestaurantRepository repo) { // Dependency Injection
        this.repo = repo;
    }

    public String createRestaurant(String title, String address, String worktime, String phone, boolean is_blocked) {
        Restaurant restaurant = new Restaurant(title, address, worktime, phone, is_blocked);

        boolean created = repo.createRestaurant(restaurant);

        return (created ? "Restaurant was created!" : "Restaurant creation was failed!");
    }

    public String getRestaurant(int id) {
        Restaurant restaurant = repo.getRestaurant(id);

        return (restaurant == null ? "Restaurant was not found!" : restaurant.toString());
    }

    public String getAllRestaurants() {
        List<Restaurant> restaurants = repo.getAllRestaurants();

        StringBuilder response = new StringBuilder();
        for (Restaurant restaurant : restaurants) {
            response.append(restaurant.toString()).append("\n");
        }

        return response.toString();
    }

    public String updateRestaurant(int id, String title, String address, String worktime, String phone, boolean is_blocked) {
        Restaurant restaurant = new Restaurant(id, title, address, worktime, phone, is_blocked);

        boolean created = repo.updateRestaurant(restaurant);

        return (created ? "Restaurant was updated!" : "Restaurant update was failed!");
    }
}
