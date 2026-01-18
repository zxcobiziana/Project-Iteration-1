package com.company.repositories.interfaces;

import com.company.models.Restaurant;

import java.util.List;

public interface IRestaurantRepository {
    boolean createRestaurant(Restaurant restaurant);

    Restaurant getRestaurant(int id);

    List<Restaurant> getAllRestaurants();

    boolean updateRestaurant(Restaurant restaurant);
}
